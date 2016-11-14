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
 * <p>Java class for LwCommParametersType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LwCommParametersType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="heartbeatIntervalMs" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="heartbeatTimeoutMs" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="poolConfigurations"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="poolConfiguration" type="{http://common.imscf.restcomm.org/config}PoolConfigurationType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="retransmitPattern"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="retransmitIntervalMs" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LwCommParametersType", propOrder = {
    "heartbeatIntervalMs",
    "heartbeatTimeoutMs",
    "poolConfigurations",
    "retransmitPattern"
})
public class LwCommParametersType implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected int heartbeatIntervalMs;
    protected int heartbeatTimeoutMs;
    @XmlElementWrapper(required = true)
    @XmlElement(name = "poolConfiguration", namespace = "http://common.imscf.restcomm.org/config")
    protected List<PoolConfigurationType> poolConfigurations = new ArrayList<PoolConfigurationType>();
    @XmlElementWrapper(required = true)
    @XmlElement(name = "retransmitIntervalMs", namespace = "http://common.imscf.restcomm.org/config", type = Integer.class)
    protected List<Integer> retransmitPattern = new ArrayList<Integer>();

    /**
     * Gets the value of the heartbeatIntervalMs property.
     * 
     */
    public int getHeartbeatIntervalMs() {
        return heartbeatIntervalMs;
    }

    /**
     * Sets the value of the heartbeatIntervalMs property.
     * 
     */
    public void setHeartbeatIntervalMs(int value) {
        this.heartbeatIntervalMs = value;
    }

    /**
     * Gets the value of the heartbeatTimeoutMs property.
     * 
     */
    public int getHeartbeatTimeoutMs() {
        return heartbeatTimeoutMs;
    }

    /**
     * Sets the value of the heartbeatTimeoutMs property.
     * 
     */
    public void setHeartbeatTimeoutMs(int value) {
        this.heartbeatTimeoutMs = value;
    }

    public List<PoolConfigurationType> getPoolConfigurations() {
        return poolConfigurations;
    }

    public void setPoolConfigurations(List<PoolConfigurationType> poolConfigurations) {
        this.poolConfigurations = poolConfigurations;
    }

    public List<Integer> getRetransmitPattern() {
        return retransmitPattern;
    }

    public void setRetransmitPattern(List<Integer> retransmitPattern) {
        this.retransmitPattern = retransmitPattern;
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
