package edu.upc.galaxy.dao.impl;

import edu.upc.galaxy.dao.CitaDao;
import edu.upc.galaxy.entity.Cita;
import edu.upc.galaxy.entity.Credential;
import edu.upc.galaxy.entity.Inmueble;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.stereotype.Repository;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
/**
 *
 * @author gian
 */
@Repository
public class CitaDaoImpl extends SimpleJdbcDaoSupport implements CitaDao {
    
    private static Logger log = LoggerFactory.getLogger(CitaDaoImpl.class);
    
    @Autowired
    public CitaDaoImpl(DataSource dataSource) {
            log.info("Asignando el dataSource");
            setDataSource(dataSource);
    }
    
    @Override
    public Integer insertar(Cita cita) {
    /*    
        getJdbcTemplate().update(
                "insert into citas (nombre,premio,cantidad,plazo) values (?, ?, ?, ?)",
                cita.getNombre(),cita.getPremio(),cita.getCantidad(),cita.getPlazo());*/
        return getSimpleJdbcTemplate().queryForInt("call identity()");
    }
    
    @Override
    public void actualizar(Cita cita) {        
    	 getJdbcTemplate().update(
                 "Update detalleSolicitud " +
                 "set activo=0 where codigo=?",
                 cita.getCodigoDetalle());
         
       
         Integer codigoautoPersona;
         codigoautoPersona=getSimpleJdbcTemplate().queryForInt("call identity()");
         log.info("codigoautoPersona" + codigoautoPersona.toString());
         SimpleDateFormat formateador = new SimpleDateFormat(
         		"dd 'de' MMMM 'de' yyyy", new Locale("es_ES"));
         		java.util.Date fechaDate = new java.util.Date();
         		String fecha = formateador.format(fechaDate);

         		Integer codigoEstad;
         		if (cita.getCodigoEstado()==1)
         		{
         			codigoEstad=3;
         		}else{
         			codigoEstad=4;
         		}
         		
         getJdbcTemplate().update(
        		 "insert into detalleSolicitud (codigoInmueble, codigoPersona, codigoUsuario,codigoEstado,activo,credat,fecha,lugar) " +
        	     "select codigoInmueble, codigoPersona, ?, ?, 1, ?,?,? from detalleSolicitud where codigo=?",
                 cita.getCodigoUsuario(),codigoEstad,fecha,cita.getFecha(),cita.getLugar(), cita.getCodigoDetalle());
   
    }

    @Override
    public void Aceptar(Cita cita) {        
    	 getJdbcTemplate().update(
                 "Update detalleSolicitud " +
                 "set activo=0 where codigo=?",
                 cita.getCodigoDetalle());
         
       
         Integer codigoautoPersona;
         codigoautoPersona=getSimpleJdbcTemplate().queryForInt("call identity()");
         log.info("codigoautoPersona" + codigoautoPersona.toString());
         SimpleDateFormat formateador = new SimpleDateFormat(
         		"dd 'de' MMMM 'de' yyyy", new Locale("es_ES"));
         		java.util.Date fechaDate = new java.util.Date();
         		String fecha = formateador.format(fechaDate);

         		Integer codigoEstad;
         		if (cita.getCodigoEstado()==3)
         		{
         			codigoEstad=7;
         		}else{
         			codigoEstad=6;
         		}
         		
         getJdbcTemplate().update(
        		 "insert into detalleSolicitud (codigoInmueble, codigoPersona, codigoUsuario,codigoEstado,activo,credat,fecha,lugar) " +
        	     "select codigoInmueble, codigoPersona, ?, ?, 1, ?,?,? from detalleSolicitud where codigo=?",
                 cita.getCodigoUsuario(),codigoEstad,fecha,cita.getFecha(),cita.getLugar(), cita.getCodigoDetalle());
   
    }
    @Override
    public void anular(Integer id, Integer Codigousuario) {
    	   
   	 getJdbcTemplate().update(
                "Update detalleSolicitud " +
                "set activo=0 where codigo=?",
                id);

     Integer codigoautoPersona;
     codigoautoPersona=getSimpleJdbcTemplate().queryForInt("call identity()");
     log.info("codigoautoPersona" + codigoautoPersona.toString());
     SimpleDateFormat formateador = new SimpleDateFormat(
     		"dd 'de' MMMM 'de' yyyy", new Locale("es_ES"));
     		java.util.Date fechaDate = new java.util.Date();
     		String fecha = formateador.format(fechaDate);
     		
     getJdbcTemplate().update(
    		 "insert into detalleSolicitud (codigoInmueble, codigoPersona, codigoUsuario,codigoEstado,activo,credat) " +
    	     "select codigoInmueble, codigoPersona, ?, 5, 1, ? from detalleSolicitud where codigo=?",
    	     Codigousuario,fecha,id);
    }
    @Override
    public void anularOperacion(Integer id, Integer Codigousuario, Integer codigoEstado) {
    	   
   	 getJdbcTemplate().update(
                "Update detalleSolicitud " +
                "set activo=0 where codigo=?",
                id);

     Integer codigoautoPersona;
     codigoautoPersona=getSimpleJdbcTemplate().queryForInt("call identity()");
     log.info("codigoautoPersona" + codigoautoPersona.toString());
     SimpleDateFormat formateador = new SimpleDateFormat(
     		"dd 'de' MMMM 'de' yyyy", new Locale("es_ES"));
     		java.util.Date fechaDate = new java.util.Date();
     		String fecha = formateador.format(fechaDate);
     	
     		Integer codigoEstad;
     		if (codigoEstado==1)
     		{
     			codigoEstad=6;
     		}else{
     			codigoEstad=5;
     		}
     		
     		
     getJdbcTemplate().update(
    		 "insert into detalleSolicitud (codigoInmueble, codigoPersona, codigoUsuario,codigoEstado,activo,credat) " +
    	     "select codigoInmueble, codigoPersona, ?, ?, 1, ? from detalleSolicitud where codigo=?",
    	     Codigousuario,codigoEstad,fecha,id);
    }
    @Override
    public Cita buscar(Integer id) {
        try {
        	System.out.println(id);
                return getSimpleJdbcTemplate().queryForObject(
                                "select i.tipoInmueble, i.area, i.distrito,i.direccion,i.nroHab,i.nroBanos,i.hPatio,i.hJardin,i.observaciones, " +
                                "p.tipoPersona, p.numRazSocial, p.docId,p.telefono,p.celular,p.correo, ds.credat , ds.codigo codigoDetalle, ds.codigoEstado, i.codigo, ds.fecha, ds.lugar "+
                                "from inmuebles i " +
                                "left join tipoInmueble t on i.tipoInmueble=t.codigo " +
                                "left join distrito d on i.distrito=d.codigo " +
                                "left join detalleSolicitud ds on ds.codigoInmueble=i.codigo " +
                                "left join persona p on p.codigo=ds.codigoPersona " +
                                "left join estado e on e.codigo=ds.codigoEstado " +
                                "where  i.codigo = ? and ds.activo=1",
                                new BeanPropertyRowMapper<Cita>(Cita.class), id);
        } catch (EmptyResultDataAccessException e) {
                return null;
        }        
    }

    @Override
    public List<Cita> buscarTodosDisponibles() {
        return getSimpleJdbcTemplate().query(
        	       "select codigo ,e.descripcion tipoEstadoDesc,d.descripcion distritoDesc , " +
        	       "p.numRazSocial,p.docID, ds.credat " +
                         "from inmuebles i " +
                         "left join tipoInmueble t on i.tipoInmueble=t.codigo " +
                         "left join distrito d on i.distrito=d.codigo " +
                         "left join detalleSolicitud ds on ds.codigoInmueble=i.codigo " +
                         "left join persona p on p.codigo=ds.codigoPersona " +
                         "left join estado e on e.codigo=ds.codigoEstado " +
                         "where ds.activo=1 and codigoEstado in (1,2) order by ds.creDat" ,
                         new BeanPropertyRowMapper<Cita>(Cita.class));
    }

    @Override
    public List<Cita> buscarTodosPendientes(Integer id) {
        return getSimpleJdbcTemplate().query(
        	       "select codigo ,e.descripcion tipoEstadoDesc,d.descripcion distritoDesc , " +
        	       "p.numRazSocial,p.docID, ds.credat, ds.fecha, ds.lugar " +
                         "from inmuebles i " +
                         "left join tipoInmueble t on i.tipoInmueble=t.codigo " +
                         "left join distrito d on i.distrito=d.codigo " +
                         "left join detalleSolicitud ds on ds.codigoInmueble=i.codigo " +
                         "left join persona p on p.codigo=ds.codigoPersona " +
                         "left join estado e on e.codigo=ds.codigoEstado " +
                         "where ds.activo=1 and codigoEstado in (3,4) and ds.codigoUsuario= " + id +"order by ds.fecha" ,
                         new BeanPropertyRowMapper<Cita>(Cita.class));
    }

    @Override
    public Cita buscar(String nombre) {
        try {
                return getSimpleJdbcTemplate().queryForObject(
                                "select id,nombre,premio,cantidad,plazo from citas where nombre = ?",
                                new BeanPropertyRowMapper<Cita>(Cita.class), nombre);
        } catch (EmptyResultDataAccessException e) {
                return null;
        }           
    }

	@Override
	public List<Cita> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}
}