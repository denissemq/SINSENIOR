package edu.upc.galaxy.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;


public class inmueblesLista  implements Serializable {

    private String tipoInmueble;
    private String distrito;
    private String Dearea;
    private String Hastaarea;
    private String DeHab;
    private String HastaHab;
    private List<Inmueble> inmuebles;
    
	public String getTipoInmueble() {
		return tipoInmueble;
	}
	public void setTipoInmueble(String tipoInmueble) {
		this.tipoInmueble = tipoInmueble;
	}
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	public String getDearea() {
		return Dearea;
	}
	public void setDearea(String dearea) {
		Dearea = dearea;
	}
	public String getHastaarea() {
		return Hastaarea;
	}
	public void setHastaarea(String hastaarea) {
		Hastaarea = hastaarea;
	}
	public String getDeHab() {
		return DeHab;
	}
	public void setDeHab(String deHab) {
		DeHab = deHab;
	}
	public String getHastaHab() {
		return HastaHab;
	}
	public void setHastaHab(String hastaHab) {
		HastaHab = hastaHab;
	}
	public List<Inmueble> getInmuebles() {
		return inmuebles;
	}
	public void setInmuebles(List<Inmueble> inmuebles) {
		this.inmuebles = inmuebles;
	}
    
    
    
    
    
    
    
    

 
    
    
}
