package edu.upc.galaxy.dao;

import edu.upc.galaxy.entity.Publicidad;
import java.util.List;

/**
 *
 * @author gian
 */
public interface PublicidadDao {
    public Integer insertar(Publicidad publicidad);
    public void actualizar(Publicidad publicidad);
    public void eliminar(Publicidad publicidad);
    public List<Publicidad> buscarTodos();
    public Publicidad buscar(Integer id);
    public Publicidad buscar(String titulo);
}
