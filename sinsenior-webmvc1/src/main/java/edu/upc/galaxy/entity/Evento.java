/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.galaxy.entity;

import java.io.Serializable;
//import java.util.Date;

/**
 *
 * @author Alvaro
 */
public class Evento  implements Serializable {

    private Integer id;
    private String nombre;
    private String premio;
    private String cantidad;
    private String plazo;

    
    
    
    
    
    
    
        public Evento() {}
    

    public Evento(Integer id, String nombre, String premio, String cantidad, String plazo) {
        this.id = id;
        this.nombre = nombre;
        this.premio = premio;
        this.cantidad = cantidad;
        this.plazo = plazo;
    }
    public Evento(String nombre, String premio, String plazo) {
        this.nombre = nombre;
        this.premio = premio;
        this.plazo = plazo;
    }
    
    public Evento(String nombre,String premio) {
        this.nombre = nombre;
        this.premio = premio;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPlazo() {
        return plazo;
    }

    public void setPlazo(String plazo) {
        this.plazo = plazo;
    }

    public String getPremio() {
        return premio;
    }

    public void setPremio(String premio) {
        this.premio = premio;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
