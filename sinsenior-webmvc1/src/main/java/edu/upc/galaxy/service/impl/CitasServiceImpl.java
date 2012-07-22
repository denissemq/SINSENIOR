package edu.upc.galaxy.service.impl;

import edu.upc.galaxy.dao.CitaDao;
import edu.upc.galaxy.dao.impl.CitaDaoImpl;
import edu.upc.galaxy.entity.Cita;
import edu.upc.galaxy.service.CitaService;
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
public class CitasServiceImpl implements CitaService {

    private static Logger log = LoggerFactory.getLogger(CitaDaoImpl.class);    
    
    @Autowired
    private CitaDao CitaDao;

    @Override
    public Integer insertar(Cita Cita) {
        log.info("Creando Cita");
        return CitaDao.insertar(Cita);
    }

    @Override
    public void actualizar(Cita Cita) {
        log.info("Actualizando Cita");
        CitaDao.actualizar(Cita);
    }

    @Override
    public void anular(Integer id, Integer codigoUsuario) {
        log.info("Anulando Cita");
        CitaDao.anular(id, codigoUsuario);
    }

    @Override
    public List<Cita> buscarTodos() {
        log.info("Buscando todas las Citas");
        return CitaDao.buscarTodos();
    }

    @Override
    public List<Cita> buscarTodosDisponibles() {
        log.info("Buscando todas las Citas");
        return CitaDao.buscarTodosDisponibles();
    }
    @Override
    public List<Cita> buscarTodosPendientes() {
        log.info("Buscando todas las Citas");
        return CitaDao.buscarTodosPendientes();
    }
    @Override
    public Cita buscar(Integer id) {
        log.info("Buscar Cita por id");
        return CitaDao.buscar(id);
    }

}
