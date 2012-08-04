package edu.upc.galaxy.service.impl;

import edu.upc.galaxy.dao.UsuarioDao;
import edu.upc.galaxy.dao.impl.UsuarioDaoImpl;
import edu.upc.galaxy.entity.Credential;
import edu.upc.galaxy.entity.DropDownList;
import edu.upc.galaxy.entity.Usuario;
import edu.upc.galaxy.service.UsuarioService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gian
 *
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

    private static Logger log = LoggerFactory.getLogger(UsuarioDaoImpl.class);    
    
    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public Integer insertar(Usuario usuario) {
        log.info("Creando usuario");
        return usuarioDao.insertar(usuario);
    }

    @Override
    public void actualizar(Usuario usuario) {
        log.info("Actualizando usuario");
        usuarioDao.actualizar(usuario);
    }

    @Override
    public void eliminar(Usuario usuario) {
        log.info("Eliminando usuario");
        usuarioDao.eliminar(usuario);
    }

    @Override
    public List<Usuario> buscarTodos() {
        log.info("Buscando todos los usuarios");
        return usuarioDao.buscarTodos();
    }

    @Override
    public Usuario buscar(Integer id) {
        log.info("Buscar usuario por id");
        return usuarioDao.buscar(id);
    }

    @Override
    public Boolean autenticar(String correo,String password) {        
        Usuario user = usuarioDao.buscar(correo);
        if (user != null) {
            return user.getPassword().equals(password);
        }
        return Boolean.FALSE;
    }
    @Override
   	public List<DropDownList> buscarTipoInmueble() {
           log.info("Buscando todas los tipos de Inmueble");
           return usuarioDao.buscarTipoInmueble();
   	}

   	@Override
   	public List<DropDownList> buscarDistrito() {
           log.info("Buscando todas los distritos");
           return usuarioDao.buscarDistrito();
   	}

   	@Override
   	public List<DropDownList> buscarTipoPersona() {
           log.info("Buscando todas los tipos de persona");
           return usuarioDao.buscarTipoPersona();
   	}

   	@Override
   	public List<DropDownList> buscarEstado() {
           log.info("Buscando todas los estados");
           return usuarioDao.buscarEstado();
   	}

	@Override
	public Credential buscarxCorreo(String correo) {
        log.info("Buscando info usuario");
        return usuarioDao.buscarxCorreo(correo);
	}

}
