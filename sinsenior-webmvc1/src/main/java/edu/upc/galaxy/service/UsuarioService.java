package edu.upc.galaxy.service;

import edu.upc.galaxy.entity.Usuario;
import java.util.List;

public interface UsuarioService {
    public Integer insertar(Usuario usuario);
    public void actualizar(Usuario usuario);
    public void eliminar(Usuario usuario);
    public List<Usuario> buscarTodos();
    public Usuario buscar(Integer id);
    public Boolean autenticar(String correo,String password);    
}