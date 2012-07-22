package edu.upc.galaxy.service;

import edu.upc.galaxy.entity.Credential;
import edu.upc.galaxy.entity.DropDownList;
import edu.upc.galaxy.entity.Usuario;
import java.util.List;

public interface UsuarioService {
    public Integer insertar(Usuario usuario);
    public void actualizar(Usuario usuario);
    public void eliminar(Usuario usuario);
    public List<Usuario> buscarTodos();
    public Usuario buscar(Integer id);
    public Boolean autenticar(String correo,String password);   
    public Credential buscarxCorreo(String correo); 
    
    public List<DropDownList> buscarTipoInmueble();
    public List<DropDownList> buscarDistrito();
    public List<DropDownList> buscarTipoPersona();
    public List<DropDownList> buscarEstado();
}