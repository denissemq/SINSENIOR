package edu.upc.galaxy.dao.impl;

import edu.upc.galaxy.dao.DropDownListDao;
import edu.upc.galaxy.entity.DropDownList;

import java.util.List;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gian
 */
@Repository
public class DropDownListDaoImpl extends SimpleJdbcDaoSupport implements DropDownListDao {

	    
	    private static Logger log = LoggerFactory.getLogger(DropDownListDaoImpl.class);
	    
	    @Autowired
	    public DropDownListDaoImpl(DataSource dataSource) {
	            log.info("Asignando el dataSource");
	            setDataSource(dataSource);
	    }
	    
	@Override
	public List<DropDownList> buscarTipoInmueble() {
        log.info("Asignando el tipoInmueble");
		 return getSimpleJdbcTemplate().query(
                 "select codigo,descripcion from tipoInmueble",
                 new BeanPropertyRowMapper<DropDownList>(DropDownList.class));
	}

	@Override
	public List<DropDownList> buscarDistrito() {
		 return getSimpleJdbcTemplate().query(
                 "select codigo,descripcion from distrito",
                 new BeanPropertyRowMapper<DropDownList>(DropDownList.class));
	}

	@Override
	public List<DropDownList> buscarTipoPersona() {
		 return getSimpleJdbcTemplate().query(
                 "select codigo, descripcion from tipoPersona",
                 new BeanPropertyRowMapper<DropDownList>(DropDownList.class));
	}

	@Override
	public List<DropDownList> buscarEstado() {
		 return getSimpleJdbcTemplate().query(
                 "select codigo, descripcion from estado",
                 new BeanPropertyRowMapper<DropDownList>(DropDownList.class));
	}

}
