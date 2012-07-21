package edu.upc.galaxy.service.impl;

import edu.upc.galaxy.dao.UsuarioDao;
import edu.upc.galaxy.dao.impl.UsuarioDaoImpl;
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
}
