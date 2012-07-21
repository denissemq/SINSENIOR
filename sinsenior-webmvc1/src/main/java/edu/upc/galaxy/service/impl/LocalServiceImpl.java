package edu.upc.galaxy.service.impl;

import edu.upc.galaxy.dao.LocalDao;
import edu.upc.galaxy.dao.impl.LocalDaoImpl;
import edu.upc.galaxy.entity.Local;
import edu.upc.galaxy.service.LocalService;
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
public class LocalServiceImpl implements LocalService {

    private static Logger log = LoggerFactory.getLogger(LocalDaoImpl.class);    
    
    @Autowired
    private LocalDao localDao;

    @Override
    public Integer insertar(Local local) {
        log.info("Creando local");
        return localDao.insertar(local);
    }

    @Override
    public void actualizar(Local local) {
        log.info("Actualizando local");
        localDao.actualizar(local);
    }

    @Override
    public void eliminar(Local local) {
        log.info("Eliminando local");
        localDao.eliminar(local);
    }

    @Override
    public List<Local> buscarTodos() {
        log.info("Buscando todos los locales");
        return localDao.buscarTodos();
    }

    @Override
    public Local buscar(Integer id) {
        log.info("Buscar local por id");
        return localDao.buscar(id);
    }

    @Override
    public Boolean autenticar(String nombre,String direccion) {        
        Local user = localDao.buscar(nombre);
        if (user != null) {
            return user.getDireccion().equals(direccion);
        }
        return Boolean.FALSE;
    }
}
