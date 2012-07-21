package edu.upc.galaxy.dao;

import edu.upc.galaxy.entity.Inmueble;
import edu.upc.galaxy.entity.DropDownList;
import java.util.List;

/**
 *
 * @author gian
 */
public interface InmuebleDao {
    public Integer insertar(Inmueble inmueble);
    public void actualizar(Inmueble inmueble);
    public void eliminar(Inmueble inmueble);
    public List<Inmueble> buscarTodos();
    public Inmueble buscar(Integer id);
    public Inmueble buscar(String nombre);
    public List<Inmueble> buscarTodosActivos();
    public List<DropDownList> buscarTipoInmueble();
    public List<DropDownList> buscarDistrito();
    public List<DropDownList> buscarTipoPersona();
    public List<DropDownList> buscarEstado();
   public List<Inmueble> buscarFiltro(Integer codigoDistrito, Integer codigoInmueble,Integer deArea, Integer HastaArea,Integer deHab, Integer HastaHab);
}
