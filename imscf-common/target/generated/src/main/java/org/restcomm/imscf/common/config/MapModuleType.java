//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.11.14 at 11:44:58 AM CET 
//


package org.restcomm.imscf.common.config;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.cxf.jaxb.JAXBToStringStyle;


/**
 * <p>Java class for MapModuleType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MapModuleType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;element name="localGt" type="{http://www.w3.org/2001/XMLSchema}IDREF"/&gt;
 *           &lt;element name="localSsn" type="{http://www.w3.org/2001/XMLSchema}IDREF"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="mapGsmScfAddress" type="{http://common.imscf.restcomm.org/config}Ss7AddressType"/&gt;
 *         &lt;element name="mapTimeoutSec" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MapModuleType", propOrder = {
    "localGt",
    "localSsn",
    "mapGsmScfAddress",
    "mapTimeoutSec"
})
public class MapModuleType implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(type = Object.class)
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected GtAddressType localGt;
    @XmlElement(type = Object.class)
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected SubSystemType localSsn;
    @XmlElement(required = true)
    protected Ss7AddressType mapGsmScfAddress;
    protected int mapTimeoutSec;
    @XmlAttribute(name = "name", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String name;

    /**
     * Gets the value of the localGt property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public GtAddressType getLocalGt() {
        return localGt;
    }

    /**
     * Sets the value of the localGt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setLocalGt(GtAddressType value) {
        this.localGt = value;
    }

    /**
     * Gets the value of the localSsn property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public SubSystemType getLocalSsn() {
        return localSsn;
    }

    /**
     * Sets the value of the localSsn property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setLocalSsn(SubSystemType value) {
        this.localSsn = value;
    }

    /**
     * Gets the value of the mapGsmScfAddress property.
     * 
     * @return
     *     possible object is
     *     {@link Ss7AddressType }
     *     
     */
    public Ss7AddressType getMapGsmScfAddress() {
        return mapGsmScfAddress;
    }

    /**
     * Sets the value of the mapGsmScfAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link Ss7AddressType }
     *     
     */
    public void setMapGsmScfAddress(Ss7AddressType value) {
        this.mapGsmScfAddress = value;
    }

    /**
     * Gets the value of the mapTimeoutSec property.
     * 
     */
    public int getMapTimeoutSec() {
        return mapTimeoutSec;
    }

    /**
     * Sets the value of the mapTimeoutSec property.
     * 
     */
    public void setMapTimeoutSec(int value) {
        this.mapTimeoutSec = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
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
