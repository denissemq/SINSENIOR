package edu.upc.galaxy.service;

import edu.upc.galaxy.entity.Local;
import java.util.List;

public interface LocalService {
    public Integer insertar(Local local);
    public void actualizar(Local local);
    public void eliminar(Local local);
    public List<Local> buscarTodos();
    public Local buscar(Integer id);
    public Boolean autenticar(String nombre,String direccion);    
}