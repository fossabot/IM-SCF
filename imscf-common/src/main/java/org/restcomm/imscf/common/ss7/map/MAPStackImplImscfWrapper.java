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
package org.restcomm.imscf.common.ss7.map;

import org.restcomm.imscf.common.ss7.tcap.ImscfTCAPUtil;

import org.mobicents.protocols.ss7.map.MAPStackImpl;
import org.mobicents.protocols.ss7.tcap.api.TCAPProvider;

/**
 * Wrapper class to extends MAPStackImpl class functionality with IMSCF specific features.
 *
 *
 * @author Balogh Gábor
 *
 */
public class MAPStackImplImscfWrapper extends MAPStackImpl {

    public MAPStackImplImscfWrapper(int subSystemNumber, TCAPProvider tcapProvider) {
        this(ImscfTCAPUtil.getMapStackNameForSsn(subSystemNumber), tcapProvider);
    }

    protected MAPStackImplImscfWrapper(String name, TCAPProvider tcapProvider) {
        super(name);
        mapProvider = new MAPProviderImplImscfWrapper(name, tcapProvider);
    }

}
