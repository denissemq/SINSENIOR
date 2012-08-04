package edu.upc.galaxy.service;

import edu.upc.galaxy.entity.Servicio;
import java.util.List;

public interface ServicioService {
    public Integer insertar(Servicio servicio);
    public void actualizar(Servicio servicio);
    public void eliminar(Servicio servicio);
    public List<Servicio> buscarTodos();
    public Servicio buscar(Integer id);
    public Boolean autenticar(String tiposervicio, String descripcion);    
}