package edu.upc.galaxy.dao;

import edu.upc.galaxy.entity.Inmueble;
import edu.upc.galaxy.entity.DropDownList;
import edu.upc.galaxy.entity.inmueblesLista;

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
    public List<Inmueble> buscarTodosEstadistico();
    
    public Inmueble buscar(Integer id);
    public Inmueble buscar(String nombre);
    public List<Inmueble> buscarTodosActivos();
    public inmueblesLista buscarFiltro(String distrito, String tipoInmueble,String deArea, String hastaArea, String deHab, String hastaHab);
    public Integer solicita(Inmueble inmueble);
	public Integer suscribir(inmueblesLista inmueble);
	public List<inmueblesLista> buscarPreferencias();
	public void AnulSuscrip(Integer id);
}
