package edu.upc.galaxy.service;

import edu.upc.galaxy.entity.DropDownList;
import edu.upc.galaxy.entity.Inmueble;
import java.util.List;

public interface InmuebleService {
    public Integer insertar(Inmueble Inmueble);
    public void actualizar(Inmueble Inmueble);
    public void eliminar(Inmueble Inmueble);
    public List<Inmueble> buscarTodos();
    public List<Inmueble> buscarTodosEstadistico();
    
    public List<Inmueble> buscarTodosActivos();    
    public Inmueble buscar(Integer id);  
	public List<Inmueble> buscarFiltro(Integer codigoDistrito, Integer codigoInmueble,
			Integer deArea, Integer HastaArea, Integer deHab, Integer HastaHab);
}