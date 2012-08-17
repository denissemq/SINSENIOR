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
<<<<<<< HEAD
    public Cita ValidarInfocorp(String tipoPersona, String docId, Integer id);    
=======
>>>>>>> 74eea3a6b3d863bb64df89d620e35f3a4c36de2a
    
    public List<Cita> buscarTodosDisponibles();
    public List<Cita> buscarTodosPendientes(Integer id);
}