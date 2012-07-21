package edu.upc.galaxy.dao.impl;

import edu.upc.galaxy.dao.EventoDao;
import edu.upc.galaxy.entity.Evento;
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
public class EventoDaoImpl extends SimpleJdbcDaoSupport implements EventoDao {
    
    private static Logger log = LoggerFactory.getLogger(EventoDaoImpl.class);
    
    @Autowired
    public EventoDaoImpl(DataSource dataSource) {
            log.info("Asignando el dataSource");
            setDataSource(dataSource);
    }
    
    @Override
    public Integer insertar(Evento evento) {
        
        getJdbcTemplate().update(
                "insert into eventos (nombre,premio,cantidad,plazo) values (?, ?, ?, ?)",
                evento.getNombre(),evento.getPremio(),evento.getCantidad(),evento.getPlazo());
        return getSimpleJdbcTemplate().queryForInt("call identity()");
    }
    
    @Override
    public void actualizar(Evento evento) {        
        getJdbcTemplate().update(
                "update eventos set nombre = ?, premio = ?, cantidad = ?, plazo = ? where id = ?",
                evento.getNombre(),evento.getPremio(),evento.getCantidad(),evento.getPlazo(),evento.getId());        
    }
    
    @Override
    public void eliminar(Evento evento) {
        getJdbcTemplate().update(
                "delete from eventos where id = ?",evento.getId());        
    }

    @Override
    public Evento buscar(Integer id) {
        try {
                return getSimpleJdbcTemplate().queryForObject(
                                "select id,nombre,premio,cantidad,plazo from eventos where id = ?",
                                new BeanPropertyRowMapper<Evento>(Evento.class), id);
        } catch (EmptyResultDataAccessException e) {
                return null;
        }        
    }

    @Override
    public List<Evento> buscarTodos() {
        return getSimpleJdbcTemplate().query(
                        "select id,nombre,premio,cantidad,plazo from eventos",
                        new BeanPropertyRowMapper<Evento>(Evento.class));
    }

    @Override
    public Evento buscar(String nombre) {
        try {
                return getSimpleJdbcTemplate().queryForObject(
                                "select id,nombre,premio,cantidad,plazo from eventos where nombre = ?",
                                new BeanPropertyRowMapper<Evento>(Evento.class), nombre);
        } catch (EmptyResultDataAccessException e) {
                return null;
        }           
    }
}