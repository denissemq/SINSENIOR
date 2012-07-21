package edu.upc.galaxy.dao.impl;

import edu.upc.galaxy.dao.ServicioDao;
import edu.upc.galaxy.entity.Servicio;
import java.util.List;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gian
 */
@Repository
public class ServicioDaoImpl extends SimpleJdbcDaoSupport implements ServicioDao {
    
    private static Logger log = LoggerFactory.getLogger(ServicioDaoImpl.class);
    
    @Autowired
    public ServicioDaoImpl(DataSource dataSource) {
            log.info("Asignando el dataSource");
            setDataSource(dataSource);
    }
    
    @Override
    public Integer insertar(Servicio servicio) {
        getJdbcTemplate().update(
                "insert into servicios (tiposervicio,descripcion,tarifa) values (?, ?, ?)",
                servicio.getTiposervicio(),servicio.getDescripcion(),servicio.getTarifa());
        return getSimpleJdbcTemplate().queryForInt("call identity()");
    }
    
    @Override
    public void actualizar(Servicio servicio) {        
        getJdbcTemplate().update(
                "update servicios set tiposervicio = ?, descripcion = ?, tarifa = ? where id = ?",
                servicio.getTiposervicio(),servicio.getDescripcion(),servicio.getTarifa(),servicio.getId());        
    }
    
    @Override
    public void eliminar(Servicio servicio) {
        getJdbcTemplate().update(
                "delete from servicios where id = ?",servicio.getId());        
    }

    @Override
    public Servicio buscar(Integer id) {
        try {
                return getSimpleJdbcTemplate().queryForObject(
                 "select id,tiposervicio,descripcion,tarifa from servicios where id=?",
                new BeanPropertyRowMapper<Servicio>(Servicio.class), id);
        } catch (EmptyResultDataAccessException e) {
                return null;
        }        
    }

    @Override
    public List<Servicio> buscarTodos() {
        return getSimpleJdbcTemplate().query(
                        "select id,tiposervicio,descripcion,tarifa from servicios",
                        new BeanPropertyRowMapper<Servicio>(Servicio.class));
    }

    @Override
    public Servicio buscar(String tiposervicio) {
        try {
                return getSimpleJdbcTemplate().queryForObject(
                                "select id,tiposervicio,descripcion,tarifa from servicios where tiposervicio=?",
                                new BeanPropertyRowMapper<Servicio>(Servicio.class), tiposervicio);
        } catch (EmptyResultDataAccessException e) {
                return null;
        }           
    }
}