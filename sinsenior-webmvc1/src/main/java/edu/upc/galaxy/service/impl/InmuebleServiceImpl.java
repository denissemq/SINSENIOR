package edu.upc.galaxy.service.impl;

import edu.upc.galaxy.dao.InmuebleDao;
import edu.upc.galaxy.dao.impl.InmuebleDaoImpl;
import edu.upc.galaxy.entity.DropDownList;
import edu.upc.galaxy.entity.Inmueble;
import edu.upc.galaxy.service.InmuebleService;
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
public class InmuebleServiceImpl implements InmuebleService {

    private static Logger log = LoggerFactory.getLogger(InmuebleDaoImpl.class);    
    
    @Autowired
    private InmuebleDao inmuebleDao;

    @Override
    public Integer insertar(Inmueble Inmueble) {
        log.info("Creando Inmueble");
        return inmuebleDao.insertar(Inmueble);
    }

    @Override
	public List<DropDownList> buscarTipoInmueble() {
        log.info("Buscando todas los tipos de Inmueble");
        return inmuebleDao.buscarTipoInmueble();
	}

	@Override
	public List<DropDownList> buscarDistrito() {
        log.info("Buscando todas los distritos");
        return inmuebleDao.buscarDistrito();
	}

	@Override
	public List<DropDownList> buscarTipoPersona() {
        log.info("Buscando todas los tipos de persona");
        return inmuebleDao.buscarTipoPersona();
	}

	@Override
	public List<DropDownList> buscarEstado() {
        log.info("Buscando todas los estados");
        return inmuebleDao.buscarEstado();
	}

    @Override
    public void actualizar(Inmueble Inmueble) {
        log.info("Actualizando Inmueble");
        inmuebleDao.actualizar(Inmueble);
    }

    @Override
    public void eliminar(Inmueble Inmueble) {
        log.info("Eliminando Inmueble");
        inmuebleDao.eliminar(Inmueble);
    }

    @Override
    public List<Inmueble> buscarTodos() {
        log.info("Buscando todas las inmuebles");
        return inmuebleDao.buscarTodos();
    }

    public List<Inmueble> buscarTodosActivos() {
        log.info("Buscando todas las inmuebles Activos");
        return inmuebleDao.buscarTodosActivos();
    }

    @Override
    public Inmueble buscar(Integer id) {
        log.info("Buscar Inmueble por id" + id);
        return inmuebleDao.buscar(id);
    }

    @Override
    public List<Inmueble> buscarFiltro(Integer codigoDistrito, Integer codigoInmueble,Integer deArea, Integer HastaArea,Integer deHab, Integer HastaHab) {
        log.info("Buscar Inmueble por id" + codigoDistrito);
        return inmuebleDao.buscarFiltro( codigoDistrito,  codigoInmueble, deArea,  HastaArea, deHab,  HastaHab);
    }
    
}
