package edu.upc.galaxy.dao.impl;

import edu.upc.galaxy.dao.PublicidadDao;
import edu.upc.galaxy.entity.Publicidad;
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
public class PublicidadDaoImpl extends SimpleJdbcDaoSupport implements PublicidadDao {
    
    private static Logger log = LoggerFactory.getLogger(PublicidadDaoImpl.class);
    
    @Autowired
    public PublicidadDaoImpl(DataSource dataSource) {
            log.info("Asignando el dataSource");
            setDataSource(dataSource);
    }
    
    @Override
    public Integer insertar(Publicidad publicidad) {
        
        getJdbcTemplate().update(
                "insert into publicidades (titulo,contenido,fechainicio,fechafinal,tarifa,clicks,ubicacion) values (?, ?, ?, ?, ?, ?, ?)",
                publicidad.getTitulo(),publicidad.getContenido(),publicidad.getFechainicio(),publicidad.getFechafinal(),publicidad.getTarifa(),publicidad.getClicks(),publicidad.getUbicacion());
        return getSimpleJdbcTemplate().queryForInt("call identity()");
    }
    
    @Override
    public void actualizar(Publicidad publicidad) {        
        getJdbcTemplate().update(
                "update publicidades set titulo = ?, contenido = ?, fechainicio = ?, fechafinal = ?, tarifa = ?, clicks = ?, ubicacion = ? where id = ?",
                publicidad.getTitulo(),publicidad.getContenido(),publicidad.getFechainicio(),publicidad.getFechafinal(),publicidad.getTarifa(),publicidad.getClicks(),publicidad.getUbicacion(),publicidad.getId());        
    }
    
    @Override
    public void eliminar(Publicidad publicidad) {
        getJdbcTemplate().update(
                "delete from publicidades where id = ?",publicidad.getId());        
    }

    @Override
    public Publicidad buscar(Integer id) {
        try {
                return getSimpleJdbcTemplate().queryForObject(
                                "select id,titulo,contenido,fechainicio,fechafinal,tarifa,clicks,ubicacion from publicidades where id=?",
                                new BeanPropertyRowMapper<Publicidad>(Publicidad.class), id);
        } catch (EmptyResultDataAccessException e) {
                return null;
        }        
    }

    @Override
    public List<Publicidad> buscarTodos() {
        return getSimpleJdbcTemplate().query(
                        "select id,titulo,contenido,fechainicio,fechafinal,tarifa,clicks,ubicacion from publicidades",
                        new BeanPropertyRowMapper<Publicidad>(Publicidad.class));
    }

    @Override
    public Publicidad buscar(String titulo) {
        try {
                return getSimpleJdbcTemplate().queryForObject(
                                "select id,titulo,contenido,fechainicio,fechafinal,tarifa,clicks,ubicacion from publicidades where titulo = ?",
                                new BeanPropertyRowMapper<Publicidad>(Publicidad.class), titulo);
        } catch (EmptyResultDataAccessException e) {
                return null;
        }           
    }
}