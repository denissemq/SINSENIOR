package edu.upc.galaxy.service.impl;

import edu.upc.galaxy.dao.PublicidadDao;
import edu.upc.galaxy.dao.impl.PublicidadDaoImpl;
import edu.upc.galaxy.entity.Publicidad;
import edu.upc.galaxy.service.PublicidadService;
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
public class PublicidadServiceImpl implements PublicidadService {

    private static Logger log = LoggerFactory.getLogger(PublicidadDaoImpl.class);    
    
    @Autowired
    private PublicidadDao publicidadDao;

    @Override
    public Integer insertar(Publicidad publicidad) {
        log.info("Creando publicidad");
        return publicidadDao.insertar(publicidad);
    }

    @Override
    public void actualizar(Publicidad publicidad) {
        log.info("Actualizando publicidad");
        publicidadDao.actualizar(publicidad);
    }

    @Override
    public void eliminar(Publicidad publicidad) {
        log.info("Eliminando publicidad");
        publicidadDao.eliminar(publicidad);
    }

    @Override
    public List<Publicidad> buscarTodos() {
        log.info("Buscando todos los locales");
        return publicidadDao.buscarTodos();
    }

    @Override
    public Publicidad buscar(Integer id) {
        log.info("Buscar publicidad por id");
        return publicidadDao.buscar(id);
    }

    @Override
    public Boolean autenticar(String titulo,String contenido) {        
        Publicidad user = publicidadDao.buscar(titulo);
        if (user != null) {
            return user.getContenido().equals(contenido);
        }
        return Boolean.FALSE;
    }
}
