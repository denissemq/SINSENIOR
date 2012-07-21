package edu.upc.galaxy.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alvaro
 */
@XmlRootElement
public class Inmueble  implements Serializable {

    private Integer codigo;
    private String tipoInmueble;
    private String area;
    private String distrito;
    private String direccion;
    private String nroHab;
    private String nroBanos;
    private Boolean hPatio;
	private Boolean hJardin;
    private String observaciones;
    private String tipoPersona;
    private String numRazSocial;
    private String docId;
    private String correo;
    private String telefono;
    private String celular;
    private String tipoInmuebleDesc;
    private String distritoDesc;
    private String tipoPersonaDesc;
    private Integer estado;
    
    public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	public String getTipoPersonaDesc() {
		return tipoPersonaDesc;
	}
	public void setTipoPersonaDesc(String tipoPersonaDesc) {
		this.tipoPersonaDesc = tipoPersonaDesc;
	}
	public String getDistritoDesc() {
		return distritoDesc;
	}
	public void setDistritoDesc(String distritoDesc) {
		this.distritoDesc = distritoDesc;
	}
	public String getTipoInmuebleDesc() {
		return tipoInmuebleDesc;
	}
	public void setTipoInmuebleDesc(String tipoInmuebleDesc) {
		this.tipoInmuebleDesc = tipoInmuebleDesc;
	}
	private List<DropDownList> listtipoInmueble;
    
    public List<DropDownList> getListtipoInmueble() {
		return listtipoInmueble;
	}
	public void setListtipoInmueble(List<DropDownList> listtipoInmueble) {
		this.listtipoInmueble = listtipoInmueble;
	}
	
    public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getTipoInmueble() {
		return tipoInmueble;
	}
	public void setTipoInmueble(String tipoInmueble) {
		this.tipoInmueble = tipoInmueble;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getNroHab() {
		return nroHab;
	}
	public void setNroHab(String nroHab) {
		this.nroHab = nroHab;
	}
	public String getNroBanos() {
		return nroBanos;
	}
	public void setNroBanos(String nroBanos) {
		this.nroBanos = nroBanos;
	}
	public Boolean gethPatio() {
		return hPatio;
	}
	public void sethPatio(Boolean hPatio) {
		this.hPatio = hPatio;
	}
	public Boolean gethJardin() {
		return hJardin;
	}
	public void sethJardin(Boolean hJardin) {
		this.hJardin = hJardin;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getTipoPersona() {
		return tipoPersona;
	}
	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}
	
	public String getNumRazSocial() {
		return numRazSocial;
	}
	public void setNumRazSocial(String numRazSocial) {
		this.numRazSocial = numRazSocial;
	}
	public String getDocId() {
		return docId;
	}
	public void setDocId(String docId) {
		this.docId = docId;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}

     
    
    
    
    
    
    
    
    

 
    
    
}
