
package com.mycompany.servicio;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.mycompany.servicio package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ConsultarPersona_QNAME = new QName("http://servicio.mycompany.com/", "consultarPersona");
    private final static QName _ConsultarPersonaResponse_QNAME = new QName("http://servicio.mycompany.com/", "consultarPersonaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.mycompany.servicio
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConsultarPersona }
     * 
     */
    public ConsultarPersona createConsultarPersona() {
        return new ConsultarPersona();
    }

    /**
     * Create an instance of {@link ConsultarPersonaResponse }
     * 
     */
    public ConsultarPersonaResponse createConsultarPersonaResponse() {
        return new ConsultarPersonaResponse();
    }

    /**
     * Create an instance of {@link Persona }
     * 
     */
    public Persona createPersona() {
        return new Persona();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarPersona }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.mycompany.com/", name = "consultarPersona")
    public JAXBElement<ConsultarPersona> createConsultarPersona(ConsultarPersona value) {
        return new JAXBElement<ConsultarPersona>(_ConsultarPersona_QNAME, ConsultarPersona.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarPersonaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.mycompany.com/", name = "consultarPersonaResponse")
    public JAXBElement<ConsultarPersonaResponse> createConsultarPersonaResponse(ConsultarPersonaResponse value) {
        return new JAXBElement<ConsultarPersonaResponse>(_ConsultarPersonaResponse_QNAME, ConsultarPersonaResponse.class, null, value);
    }

}
