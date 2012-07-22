package edu.upc.galaxy.dao.impl;

import edu.upc.galaxy.dao.UsuarioDao;
import edu.upc.galaxy.entity.Credential;
import edu.upc.galaxy.entity.DropDownList;
import edu.upc.galaxy.entity.Usuario;
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
public class UsuarioDaoImpl extends SimpleJdbcDaoSupport implements UsuarioDao {
    
    private static Logger log = LoggerFactory.getLogger(UsuarioDaoImpl.class);
    
    @Autowired
    public UsuarioDaoImpl(DataSource dataSource) {
            log.info("Asignando el dataSource");
            setDataSource(dataSource);
    }
    
    @Override
    public Integer insertar(Usuario usuario) {
        getJdbcTemplate().update(
                "insert into usuarios (tipousuario,nombre,apellidos,sexo,tipodocumento,numerodocumento,correo,password,fechaNacimiento,numerocelular) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                usuario.getTipousuario(),usuario.getNombre(),usuario.getApellidos(),usuario.getSexo(),usuario.getTipodocumento(),usuario.getNumerodocumento(),usuario.getCorreo(),usuario.getPassword(),usuario.getFechaNacimiento(),usuario.getNumerocelular());
        return getSimpleJdbcTemplate().queryForInt("call identity()");
    }
    @Override
    public void actualizar(Usuario usuario) {        
        getJdbcTemplate().update(
                "update usuarios set tipousuario = ?, nombre = ?, apellidos = ?, sexo = ?, tipodocumento = ?, numerodocumento = ?, correo = ?, password = ?, fechaNacimiento = ?, numerocelular = ? where id = ?",
                usuario.getTipousuario(),usuario.getNombre(),usuario.getApellidos(),usuario.getSexo(),usuario.getTipodocumento(),usuario.getNumerodocumento(),usuario.getCorreo(),usuario.getPassword(),usuario.getFechaNacimiento(),usuario.getNumerocelular(),usuario.getId());        
    }
    
    @Override
    public void eliminar(Usuario usuario) {
        getJdbcTemplate().update(
                "delete from usuarios where id = ?",usuario.getId());        
    }

    @Override
    public Usuario buscar(Integer id) {
        try {
                return getSimpleJdbcTemplate().queryForObject(
                 "select id, tipousuario, nombre, apellidos, sexo,tipodocumento,numerodocumento,correo,password,fechaNacimiento,numerocelular from usuarios where id=?",
                new BeanPropertyRowMapper<Usuario>(Usuario.class), id);
        } catch (EmptyResultDataAccessException e) {
                return null;
        }        
    }

    @Override
    public List<Usuario> buscarTodos() {
        return getSimpleJdbcTemplate().query(
                        "select id,tipousuario,nombre,apellidos,sexo,tipodocumento,numerodocumento,correo,password,fechaNacimiento,numerocelular from usuarios",
                        new BeanPropertyRowMapper<Usuario>(Usuario.class));
    }

    @Override
    public Usuario buscar(String correo) {
        try {
                return getSimpleJdbcTemplate().queryForObject(
                                "select id, tipousuario, nombre, apellidos, sexo, tipodocumento, numerodocumento, correo, password, fechaNacimiento, numerocelular from usuarios where correo=?",
                                new BeanPropertyRowMapper<Usuario>(Usuario.class), correo);
        } catch (EmptyResultDataAccessException e) {
                return null;
        }           
    }
    @Override
    public Credential buscarxCorreo(String correo) {
        try {
                return getSimpleJdbcTemplate().queryForObject(
                                "select id,  correo, password from usuarios where correo=?",
                                new BeanPropertyRowMapper<Credential>(Credential.class), correo);
        } catch (EmptyResultDataAccessException e) {
                return null;
        }           
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