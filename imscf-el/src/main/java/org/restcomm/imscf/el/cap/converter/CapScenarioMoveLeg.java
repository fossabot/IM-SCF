/*
 * TeleStax, Open Source Cloud Communications
 * Copyright 2011-2016, Telestax Inc and individual contributors
 * by the @authors tag.
 *
 * This program is free software: you can redistribute it and/or modify
 * under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>
 */
package org.restcomm.imscf.el.cap.converter;

import org.restcomm.imscf.el.cap.call.CAPCSCall;
import org.restcomm.imscf.el.cap.call.CallSegment;
import org.restcomm.imscf.el.cap.call.CapSipCsCall;
import org.restcomm.imscf.el.cap.sip.SipUtil;
import org.restcomm.imscf.el.stack.CallContext;

import javax.servlet.sip.SipServletRequest;
import javax.servlet.sip.SipServletResponse;

import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.errors.CAPErrorMessage;
import org.mobicents.protocols.ss7.cap.api.primitives.CAPExtensions;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.MoveLegResponse;
import org.mobicents.protocols.ss7.inap.api.primitives.LegType;
import org.mobicents.protocols.ss7.inap.primitives.LegIDImpl;
import org.mobicents.protocols.ss7.tcap.asn.comp.Problem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** CAP scenario for moveLeg. */
public final class CapScenarioMoveLeg implements
        org.restcomm.imscf.el.cap.scenarios.CapScenarioTypesCsCall.CapScenarioMoveLeg {

    private static final Logger LOG = LoggerFactory.getLogger(CapScenarioMoveLeg.class);
    private SipServletRequest req;
    private Long invokeId;
    private int legId;
    private Runnable onSuccess;

    public static CapScenarioMoveLeg start(CAPCSCall call, int legToBeMoved, CAPExtensions extensions,
            SipServletRequest reInviteRequest, Runnable onSuccess) throws CAPException {
        Long invokeId = call.getCapDialog().addMoveLegRequest(new LegIDImpl(true, LegType.getInstance(legToBeMoved)),
                extensions);
        // send this immediately
        call.getCapDialog().send();
        return new CapScenarioMoveLeg(reInviteRequest, invokeId, legToBeMoved, onSuccess);
    }

    private CapScenarioMoveLeg(SipServletRequest req, Long invokeId, int legId, Runnable onSuccess) {
        this.req = req;
        this.invokeId = invokeId;
        this.legId = legId;
        this.onSuccess = onSuccess;
    }

    @Override
    public Long getInvokeId() {
        return invokeId;
    }

    @Override
    public void onSuccess(MoveLegResponse response) {
        LOG.debug("CAP moveLeg operation success: L{} -> CS-1", legId);
        try (CapSipCsCall call = (CapSipCsCall) CallContext.getCallStore().getCallByLocalTcapTrId(
                response.getCAPDialog().getLocalDialogId())) {
            CallSegment cs = call.getCallSegmentAssociation().moveLeg(legId);
            // send continueWithArgument for this CS if enabled
            if (call.isAutomaticCallProcessingEnabled()) {
                LOG.debug("Sending CWA after moveLeg");
                try {
                    call.add(CapScenarioContinueWithArgument.start(call, cs.getId()));
                    cs.continueCS();
                } catch (CAPException e) {
                    LOG.warn("Failed to send CAP CWA: {}", e.getMessage(), e);
                    if (req != null) {
                        SipUtil.sendOrWarn(req.createResponse(SipServletResponse.SC_SERVER_INTERNAL_ERROR),
                                "Failed to send error response to moveLeg request");
                    }
                    return;
                }
            } else {
                LOG.debug("Not sending CWA after moveLeg");
            }

            if (onSuccess != null) {
                LOG.trace("Running task on moveLeg success");
                onSuccess.run();
            } else if (req != null) {
                LOG.trace("Simply answering moveLeg request");
                // TODO: include SDP?
                // respond with 200
                SipUtil.sendOrWarn(req.createResponse(SipServletResponse.SC_OK),
                        "Failed to send success response to disconnectLeg request");
            }
        }
    }

    @Override
    public void onFailureIndicated(CAPErrorMessage error, Problem problem) {
        LOG.warn("CAP moveLeg operation failed, error {}, problem {}", error, problem);

        if (req != null) {
            // respond with 400
            SipServletResponse resp = req.createResponse(SipServletResponse.SC_BAD_REQUEST);
            SipUtil.createAndSetWarningHeader(resp, "Error response for moveLeg");
            SipUtil.sendOrWarn(resp, "Failed to send response to moveLeg request");
        }
    }

    @Override
    public void onFailureTimeout() {
        LOG.warn("CAP moveLeg operation timed out!");

        if (req != null) {
            // respond with 408 timeout
            SipServletResponse resp = req.createResponse(SipServletResponse.SC_REQUEST_TIMEOUT);
            SipUtil.createAndSetWarningHeader(resp, "Invoke timeout for moveLeg");
            SipUtil.sendOrWarn(resp, "Failed to send response to moveLeg request");
        }
    }

}
