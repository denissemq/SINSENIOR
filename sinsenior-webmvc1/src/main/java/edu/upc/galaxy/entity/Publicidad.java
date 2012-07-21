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
public class Publicidad implements Serializable {
    
    private Integer id;
    private String titulo;
    private String contenido;
    private String fechainicio;
    private String fechafinal;
    private String tarifa;
    private String clicks;
    private String ubicacion;
 
    
    
    
    
    
        public Publicidad() {}
    
    public Publicidad(Integer id, String titulo, String contenido, String fechainicio) {
        this.id = id;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechainicio = fechainicio;
    }

    public Publicidad(String titulo, String contenido, String fechainicio) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechainicio = fechainicio;
    }
    
    public Publicidad(String titulo,String contenido) {
        this.titulo = titulo;
        this.contenido = contenido;
    }

    public String getClicks() {
        return clicks;
    }

    public void setClicks(String clicks) {
        this.clicks = clicks;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getFechafinal() {
        return fechafinal;
    }

    public void setFechafinal(String fechafinal) {
        this.fechafinal = fechafinal;
    }

    public String getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(String fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTarifa() {
        return tarifa;
    }

    public void setTarifa(String tarifa) {
        this.tarifa = tarifa;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }


    
    
    
    
    
    
    
    
    
    
    
    
    
      
}

