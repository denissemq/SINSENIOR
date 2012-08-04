/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.galaxy.entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Alvaro
 */
public class Local implements Serializable {
    
    private Integer id;
    private String nombre;
    private String direccion;
    private String distrito;
    private String direcciongooglemaps;
    private String telefono;
 
    
    
    
    
    
    
    
    
        public Local() {}
    
    public Local(Integer id, String nombre, String direccion,String distrito) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.distrito = distrito;
    }

    public Local(String nombre, String direccion, String distrito) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.distrito = distrito;
    }
    
    public Local(String nombre,String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDirecciongooglemaps() {
        return direcciongooglemaps;
    }

    public void setDirecciongooglemaps(String direcciongooglemaps) {
        this.direcciongooglemaps = direcciongooglemaps;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
}

