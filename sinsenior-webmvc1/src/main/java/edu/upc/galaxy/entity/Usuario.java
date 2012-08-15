package edu.upc.galaxy.entity;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;


public class Usuario implements Serializable {
    
    private Integer id;
    private String tipousuario; 
    private String nombre;
    private String apellidos;
    private String sexo;
    private String tipodocumento;
    private String numerodocumento;
    private String correo;
    private String password;
    private String fechaNacimiento;
    private String numerocelular;

    public Usuario() {}
    
    public Usuario(Integer id, String tipousuario, String nombre, String apellidos, String sexo, String tipodocumento, String numerodocumento, String correo, String password, String fechaNacimiento, String numerocelular) {
        this.id = id;
        this.tipousuario = tipousuario; 
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.tipodocumento = tipodocumento;
        this.numerodocumento = numerodocumento;
        this.correo = correo;
        this.password = password;
        this.fechaNacimiento = fechaNacimiento;
        this.numerocelular = numerocelular;        
    }

    public Usuario(String nombre, String correo, String password) {
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
    }
    
    public Usuario(String nombre,String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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

    public String getNumerocelular() {
        return numerocelular;
    }

    public void setNumerocelular(String numerocelular) {
        this.numerocelular = numerocelular;
    }

    public String getNumerodocumento() {
        return numerodocumento;
    }

    public void setNumerodocumento(String numerodocumento) {
        this.numerodocumento = numerodocumento;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(String tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public String getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(String tipousuario) {
        this.tipousuario = tipousuario;
    }

  
    
    
    
    
    
    
}