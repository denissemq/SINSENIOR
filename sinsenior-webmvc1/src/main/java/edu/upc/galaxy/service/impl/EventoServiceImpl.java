package edu.upc.galaxy.service.impl;

import edu.upc.galaxy.dao.EventoDao;
import edu.upc.galaxy.dao.impl.EventoDaoImpl;
import edu.upc.galaxy.entity.Evento;
import edu.upc.galaxy.service.EventoService;
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
public class EventoServiceImpl implements EventoService {

    private static Logger log = LoggerFactory.getLogger(EventoDaoImpl.class);    
    
    @Autowired
    private EventoDao eventoDao;

    @Override
    public Integer insertar(Evento evento) {
        log.info("Creando evento");
        return eventoDao.insertar(evento);
    }

    @Override
    public void actualizar(Evento evento) {
        log.info("Actualizando evento");
        eventoDao.actualizar(evento);
    }

    @Override
    public void eliminar(Evento evento) {
        log.info("Eliminando evento");
        eventoDao.eliminar(evento);
    }

    @Override
    public List<Evento> buscarTodos() {
        log.info("Buscando todas las eventos");
        return eventoDao.buscarTodos();
    }

    @Override
    public Evento buscar(Integer id) {
        log.info("Buscar evento por id");
        return eventoDao.buscar(id);
    }

    @Override
    public Boolean autenticar(String nombre,String premio) {        
        Evento user = eventoDao.buscar(nombre);
        if (user != null) {
            return user.getPremio().equals(premio);
        }
        return Boolean.FALSE;
    }
}
