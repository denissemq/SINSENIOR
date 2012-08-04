package edu.upc.galaxy.dao;

import edu.upc.galaxy.entity.Evento;
import java.util.List;

/**
 *
 * @author gian
 */
public interface EventoDao {
    public Integer insertar(Evento evento);
    public void actualizar(Evento evento);
    public void eliminar(Evento evento);
    public List<Evento> buscarTodos();
    public Evento buscar(Integer id);
    public Evento buscar(String nombre);
}

