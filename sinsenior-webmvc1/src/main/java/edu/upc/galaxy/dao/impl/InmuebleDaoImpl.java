package edu.upc.galaxy.dao.impl;

import edu.upc.galaxy.dao.InmuebleDao;
import edu.upc.galaxy.entity.DropDownList;
import edu.upc.galaxy.entity.Inmueble;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

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
public class InmuebleDaoImpl extends SimpleJdbcDaoSupport implements InmuebleDao {
    
    private static Logger log = LoggerFactory.getLogger(InmuebleDaoImpl.class);
    
    @Autowired
    public InmuebleDaoImpl(DataSource dataSource) {
            log.info("Asignando el dataSource");
            setDataSource(dataSource);
    }
    
    @Override
    public Integer insertar(Inmueble Inmueble) {
        
        getJdbcTemplate().update(
                "insert into inmuebles (tipoInmueble, area, distrito,direccion,nroHab,nroBanos,hPatio,hJardin,observaciones) values (?, ?, ?, ?,?, ?, ?, ?, ?)",
                Inmueble.getTipoInmueble(),Inmueble.getArea(),Inmueble.getDistrito(),Inmueble.getDireccion(),Inmueble.getNroHab(),Inmueble.getNroBanos(),Inmueble.gethPatio(),Inmueble.gethJardin(),Inmueble.getObservaciones());
        
        Integer codigoautoInmueble;
        codigoautoInmueble=getSimpleJdbcTemplate().queryForInt("call identity()");
        log.info("codigoautoInmueble" + codigoautoInmueble.toString());
        
        getJdbcTemplate().update(
                "insert into persona (tipoPersona, numRazSocial, docId,telefono,celular,correo) values (?, ?, ?, ?, ?, ?)",
                Inmueble.getTipoPersona(),Inmueble.getNumRazSocial(),Inmueble.getDocId(),Inmueble.getTelefono(),Inmueble.getCelular(),Inmueble.getCorreo());

        Integer codigoautoPersona;
        codigoautoPersona=getSimpleJdbcTemplate().queryForInt("call identity()");
        log.info("codigoautoPersona" + codigoautoPersona.toString());
        SimpleDateFormat formateador = new SimpleDateFormat(
        		"dd 'de' MMMM 'de' yyyy", new Locale("es_ES"));
        		java.util.Date fechaDate = new java.util.Date();
        		String fecha = formateador.format(fechaDate);
        getJdbcTemplate().update(
                "insert into detalleSolicitud (codigoInmueble, codigoPersona, codigoEstado,activo,credat) values (?, ?, ?, ?,?)",
                codigoautoInmueble,codigoautoPersona,Inmueble.getEstado(),true,fecha);

        Integer codigoautoDetalle;
        codigoautoDetalle=getSimpleJdbcTemplate().queryForInt("call identity()");
        log.info("codigoautoDetalle" + codigoautoDetalle.toString());
        return codigoautoDetalle;
    }
    
    @Override
    public void actualizar(Inmueble Inmueble) {        
        getJdbcTemplate().update(
                "update inmuebles set tipoInmueble = ?, area = ?, distrito = ?, direccion = ? ,nroHab=?, nroBanos=?, hPatio=?, hJardin=?, observaciones=?  where codigo = ?",
                Inmueble.getTipoInmueble(),Inmueble.getArea(),Inmueble.getDistrito(),Inmueble.getDireccion(),Inmueble.getNroHab(),Inmueble.getNroBanos(),Inmueble.gethPatio(),Inmueble.gethJardin(),Inmueble.getObservaciones(),Inmueble.getCodigo());        
    }
    
    @Override
    public void eliminar(Inmueble Inmueble) {
        getJdbcTemplate().update(
                "delete from inmuebles where id = ?",Inmueble.getCodigo());        
    }

    @Override
    public Inmueble buscar(Integer id) {
        try {
                return getSimpleJdbcTemplate().queryForObject(
                                "select id, nombre ,doc ,correo ,telefono ,tipoInmueble,descripcion,direccion, dia, hora, corredor, usuarioId from inmuebles where id=?",
                                new BeanPropertyRowMapper<Inmueble>(Inmueble.class), id);
        } catch (EmptyResultDataAccessException e) {
                return null;
        }        
    }
    
   

    @Override
    public List<Inmueble> buscarTodos() {
        return getSimpleJdbcTemplate().query(
                        "select codigo ,t.descripcion tipoInmuebleDesc,d.descripcion distritoDesc ,i.direccion," +
                        "p.numRazSocial, i.distrito, i.area, i.tipoInmueble " +
                        "from inmuebles i " +
                        "left join tipoInmueble t on i.tipoInmueble=t.codigo " +
                        "left join distrito d on i.distrito=d.codigo " +
                        "left join detalleSolicitud ds on ds.codigoInmueble=i.codigo " +
                        "left join persona p on p.codigo=ds.codigoPersona " +
                        "where ds.activo=1 and codigoEstado=2 " ,
                        new BeanPropertyRowMapper<Inmueble>(Inmueble.class));
    }
    @Override
    public List<Inmueble> buscarTodosActivos() {
        return getSimpleJdbcTemplate().query(
                        "select id,nombre, doc,correo,telefono,tipoInmueble,descripcion,direccion,Activo from inmuebles",
                        new BeanPropertyRowMapper<Inmueble>(Inmueble.class));
    }
    
    @Override
    public Inmueble buscar(String id) {
        try {
                return getSimpleJdbcTemplate().queryForObject(
                                "select id,nombre,caracteristica,fechaatencion,tarifa,promocion from inmuebles where id=?",
                                new BeanPropertyRowMapper<Inmueble>(Inmueble.class), id);
                
        } catch (EmptyResultDataAccessException e) {
                return null;
        }           
    }

	@Override
	public List<Inmueble> buscarFiltro(Integer codigoDistrito,
			Integer codigoInmueble, Integer deArea, Integer HastaArea,
			Integer deHab, Integer HastaHab) {
		try {
	        return getSimpleJdbcTemplate().query(
            		  "select codigo ,t.descripcion tipoInmuebleDesc,d.descripcion distritoDesc ,i.direccion," +
                              "p.numRazSocial " +
                              "from inmuebles i " +
                              "left join tipoInmueble t on i.tipoInmueble=t.codigo " +
                              "left join distrito d on i.distrito=d.codigo " +
                              "left join detalleSolicitud ds on ds.codigoInmueble=i.codigo " +
                              "left join persona p on p.codigo=ds.codigoPersona " +
                              "where ds.activo=1 and codigoEstado=2 " +
                              "and (codigoDistrito=?)",
                              new BeanPropertyRowMapper<Inmueble>(Inmueble.class), codigoDistrito);
            
    } catch (EmptyResultDataAccessException e) {
            return null;
    }        
	}
}