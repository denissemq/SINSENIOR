package edu.upc.galaxy.dao;

import edu.upc.galaxy.entity.Credential;
import edu.upc.galaxy.entity.DropDownList;
import edu.upc.galaxy.entity.Usuario;
import java.util.List;

/**
 *
 * @author gian
 */
public interface UsuarioDao {
    public Integer insertar(Usuario usuario);
    public void actualizar(Usuario usuario);
    public void eliminar(Usuario usuario);
    public List<Usuario> buscarTodos();
    public Usuario buscar(Integer id);
    public Usuario buscar(String correo);
    public List<DropDownList> buscarTipoInmueble();
    public List<DropDownList> buscarDistrito();
    public List<DropDownList> buscarTipoPersona();
    public List<DropDownList> buscarEstado();
    public Credential buscarxCorreo(String correo);
}

