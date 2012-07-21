package edu.upc.galaxy.service.impl;

import edu.upc.galaxy.dao.DropDownListDao;
import edu.upc.galaxy.dao.impl.DropDownListDaoImpl;
import edu.upc.galaxy.entity.DropDownList;
import edu.upc.galaxy.service.DropDownListService;
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
public class DropDownListServiceImpl implements DropDownListService {

    private static Logger log = LoggerFactory.getLogger(DropDownListDaoImpl.class);    
    
    @Autowired
    private DropDownListDao dropDownListDao;

	@Override
	public List<DropDownList> buscarTipoInmueble() {
        log.info("Buscando todas los tipos de Inmueble");
        return dropDownListDao.buscarTipoInmueble();
	}

	@Override
	public List<DropDownList> buscarDistrito() {
        log.info("Buscando todas los distritos");
        return dropDownListDao.buscarDistrito();
	}

	@Override
	public List<DropDownList> buscarTipoPersona() {
        log.info("Buscando todas los tipos de persona");
        return dropDownListDao.buscarTipoPersona();
	}

	@Override
	public List<DropDownList> buscarEstado() {
        log.info("Buscando todas los estados");
        return dropDownListDao.buscarEstado();
	}

   

    
}
