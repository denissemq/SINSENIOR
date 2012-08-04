package edu.upc.galaxy.dao;

import edu.upc.galaxy.entity.Local;
import java.util.List;

/**
 *
 * @author gian
 */
public interface LocalDao {
    public Integer insertar(Local Local);
    public void actualizar(Local Local);
    public void eliminar(Local Local);
    public List<Local> buscarTodos();
    public Local buscar(Integer id);
    public Local buscar(String nombre);
}
