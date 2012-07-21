package edu.upc.galaxy.service;

import edu.upc.galaxy.entity.Evento;
import java.util.List;

public interface EventoService {
    public Integer insertar(Evento evento);
    public void actualizar(Evento evento);
    public void eliminar(Evento evento);
    public List<Evento> buscarTodos();
    public Evento buscar(Integer id);
    public Boolean autenticar(String nombre,String premio);    
}