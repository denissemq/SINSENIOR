package edu.upc.galaxy.service;

import edu.upc.galaxy.entity.DropDownList;
import edu.upc.galaxy.entity.Inmueble;
import edu.upc.galaxy.entity.inmueblesLista;

import java.util.List;

public interface InmuebleService {
    public Integer insertar(Inmueble Inmueble);
    public Integer suscribir(inmueblesLista Inmueble);
    
    public void actualizar(Inmueble Inmueble);
    public void eliminar(Inmueble Inmueble);
    public List<Inmueble> buscarTodos();
    public List<Inmueble> buscarTodosEstadistico();
    public List<inmueblesLista> buscarPreferencias();
    
    public List<Inmueble> buscarTodosActivos();  
    public Integer solicita(Inmueble Inmueble);
    
    public Inmueble buscar(Integer id);  
	public inmueblesLista buscarFiltro(String distrito, String tipoInmueble,
			String deArea, String hastaArea, String deHab, String hastaHab);
	public void AnulSuscrip(Integer id);
}