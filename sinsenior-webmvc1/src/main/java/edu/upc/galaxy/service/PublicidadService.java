package edu.upc.galaxy.service;

import edu.upc.galaxy.entity.Publicidad;
import java.util.List;

public interface PublicidadService {
    public Integer insertar(Publicidad publicidad);
    public void actualizar(Publicidad publicidad);
    public void eliminar(Publicidad publicidad);
    public List<Publicidad> buscarTodos();
    public Publicidad buscar(Integer id);
    public Boolean autenticar(String titulo,String contenido);    
}