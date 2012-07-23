package edu.upc.galaxy.dao;

import edu.upc.galaxy.entity.Cita;
import java.util.List;


public interface CitaDao {
    public Integer insertar(Cita evento);
    public void actualizar(Cita evento);
    public void Aceptar(Cita evento);
    public void anular(Integer id, Integer codigoUsuario);
    public void anularOperacion(Integer id, Integer codigoUsuario, Integer codigoEstado);
    public List<Cita> buscarTodos();
    public Cita buscar(Integer id);
    public Cita buscar(String nombre); 
    public List<Cita> buscarTodosDisponibles();
    public List<Cita> buscarTodosPendientes(Integer id);
}

