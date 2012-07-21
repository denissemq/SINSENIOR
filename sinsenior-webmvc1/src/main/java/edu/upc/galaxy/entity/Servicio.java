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
public class Servicio  implements Serializable {

    private Integer id;
    private String tiposervicio; // 0 - Camisetas, 1 - Arbitros, 2 - Fotografia, 3 - Pelota.
    private String descripcion;
    private String tarifa;

    
    
    
    
    
    
    
        public Servicio() {}
    
    public Servicio(Integer id, String tiposervicio, String descripcion,String tarifa) {
        this.id = id;
        this.tiposervicio = tiposervicio;
        this.descripcion = descripcion;
        this.tarifa = tarifa;
    }

    public Servicio(String tiposervicio, String descripcion, String tarifa) {
        this.tiposervicio = tiposervicio;
        this.descripcion = descripcion;
        this.tarifa = tarifa;
    }
    
    public Servicio(String tiposervicio,String descripcion) {
        this.tiposervicio = tiposervicio;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public String getTiposervicio() {
        return tiposervicio;
    }

    public void setTiposervicio(String tiposervicio) {
        this.tiposervicio = tiposervicio;
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
