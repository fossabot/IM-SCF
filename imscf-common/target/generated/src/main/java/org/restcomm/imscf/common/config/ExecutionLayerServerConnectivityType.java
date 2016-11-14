//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.11.14 at 11:44:58 AM CET 
//


package org.restcomm.imscf.common.config;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.cxf.jaxb.JAXBToStringStyle;


/**
 * <p>Java class for ExecutionLayerServerConnectivityType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExecutionLayerServerConnectivityType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://common.imscf.restcomm.org/config}ServerConnectivityType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="sipListenAddresses"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="sipListenAddress" type="{http://common.imscf.restcomm.org/config}ListenAddressType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExecutionLayerServerConnectivityType", propOrder = {
    "sipListenAddresses"
})
public class ExecutionLayerServerConnectivityType
    extends ServerConnectivityType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElementWrapper(required = true)
    @XmlElement(name = "sipListenAddress", namespace = "http://common.imscf.restcomm.org/config")
    protected List<ListenAddressType> sipListenAddresses = new ArrayList<ListenAddressType>();

    public List<ListenAddressType> getSipListenAddresses() {
        return sipListenAddresses;
    }

    public void setSipListenAddresses(List<ListenAddressType> sipListenAddresses) {
        this.sipListenAddresses = sipListenAddresses;
    }

    /**
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

}
