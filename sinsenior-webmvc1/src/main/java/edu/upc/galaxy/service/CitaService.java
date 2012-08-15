package edu.upc.galaxy.service;

import edu.upc.galaxy.entity.Cita;
import java.util.List;

public interface CitaService {
    public Integer insertar(Cita cita);
    public void actualizar(Cita cita);
    public void Aceptar(Cita cita);
    public void anular(Integer id, Integer codigoUsuario);
    public void anularOperacion(Integer id, Integer codigoUsuario, Integer codigoEstado);    
    public List<Cita> buscarTodos();
    public Cita buscar(Integer id);   
    public Cita ValidarDocumento(String tipoPersona, String docId, Integer id); 
    public Cita ValidarRegpublicos(String tipoPersona, String docId, Integer id);    
    
    public List<Cita> buscarTodosDisponibles();
    public List<Cita> buscarTodosPendientes(Integer id);
}