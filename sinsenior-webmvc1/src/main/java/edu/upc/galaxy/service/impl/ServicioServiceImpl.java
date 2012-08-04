package edu.upc.galaxy.service.impl;

import edu.upc.galaxy.dao.ServicioDao;
import edu.upc.galaxy.dao.impl.ServicioDaoImpl;
import edu.upc.galaxy.entity.Servicio;
import edu.upc.galaxy.service.ServicioService;
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
public class ServicioServiceImpl implements ServicioService {

    private static Logger log = LoggerFactory.getLogger(ServicioDaoImpl.class);    
    
    @Autowired
    private ServicioDao servicioDao;

    @Override
    public Integer insertar(Servicio servicio) {
        log.info("Creando servicio");
        return servicioDao.insertar(servicio);
    }

    @Override
    public void actualizar(Servicio servicio) {
        log.info("Actualizando servicio");
        servicioDao.actualizar(servicio);
    }

    @Override
    public void eliminar(Servicio servicio) {
        log.info("Eliminando servicio");
        servicioDao.eliminar(servicio);
    }

    @Override
    public List<Servicio> buscarTodos() {
        log.info("Buscando todas las servicios");
        return servicioDao.buscarTodos();
    }

    @Override
    public Servicio buscar(Integer id) {
        log.info("Buscar servicio por id");
        return servicioDao.buscar(id);
    }

    @Override
    public Boolean autenticar(String tiposervicio,String descripcion) {        
        Servicio user = servicioDao.buscar(tiposervicio);
        if (user != null) {
            return user.getDescripcion().equals(descripcion);
        }
        return Boolean.FALSE;
    }
}
