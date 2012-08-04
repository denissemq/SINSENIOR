package edu.upc.galaxy.dao.impl;

import edu.upc.galaxy.dao.LocalDao;
import edu.upc.galaxy.entity.Local;
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
public class LocalDaoImpl extends SimpleJdbcDaoSupport implements LocalDao {
    
    private static Logger log = LoggerFactory.getLogger(LocalDaoImpl.class);
    
    @Autowired
    public LocalDaoImpl(DataSource dataSource) {
            log.info("Asignando el dataSource");
            setDataSource(dataSource);
    }
    
    @Override
    public Integer insertar(Local local) {
        getJdbcTemplate().update(
                "insert into locales (nombre, direccion, distrito, direcciongooglemaps, telefono) values (?, ?, ?, ?, ?)",
                local.getNombre(),local.getDireccion(),local.getDistrito(),local.getDirecciongooglemaps(),local.getTelefono());
        return getSimpleJdbcTemplate().queryForInt("call identity()");
    }
    
    @Override
    public void actualizar(Local local) {        
        getJdbcTemplate().update(
                "update locales set nombre = ?, direccion = ?, distrito = ?, direcciongooglemaps = ?, telefono = ? where id = ?",
                local.getNombre(),local.getDireccion(),local.getDistrito(),local.getDirecciongooglemaps(),local.getTelefono(),local.getId());        
    }
    
    @Override
    public void eliminar(Local local) {
        getJdbcTemplate().update(
                "delete from locales where id = ?",local.getId());        
    }

    @Override
    public Local buscar(Integer id) {
        try {
                return getSimpleJdbcTemplate().queryForObject(
                                "select id, nombre, direccion, distrito, direcciongooglemaps, telefono from locales where id=?",
                                new BeanPropertyRowMapper<Local>(Local.class), id);
        } catch (EmptyResultDataAccessException e) {
                return null;
        }        
    }

    @Override
    public List<Local> buscarTodos() {
        return getSimpleJdbcTemplate().query(
                        "select id, nombre, direccion, distrito, direcciongooglemaps, telefono from locales",
                        new BeanPropertyRowMapper<Local>(Local.class));
    }

    @Override
    public Local buscar(String nombre) {
        try {
                return getSimpleJdbcTemplate().queryForObject(
                                "select id, nombre, direccion, distrito, direcciongooglemaps, telefono from locales where nombre=?",
                                new BeanPropertyRowMapper<Local>(Local.class), nombre);
        } catch (EmptyResultDataAccessException e) {
                return null;
        }           
    }
}