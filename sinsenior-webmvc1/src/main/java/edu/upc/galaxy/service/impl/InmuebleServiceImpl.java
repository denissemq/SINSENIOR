package edu.upc.galaxy.service.impl;

import edu.upc.galaxy.dao.InmuebleDao;
import edu.upc.galaxy.dao.impl.InmuebleDaoImpl;
import edu.upc.galaxy.entity.DropDownList;
import edu.upc.galaxy.entity.Inmueble;
import edu.upc.galaxy.entity.inmueblesLista;
import edu.upc.galaxy.service.InmuebleService;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;

import com.vortexbird.spring.demo.mail.IEnviarMensajeSimpleMailMessage;

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
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("/applicationContext.xml");
        
        IEnviarMensajeSimpleMailMessage enviarMensajeSimpleMailMessage=(IEnviarMensajeSimpleMailMessage)beanFactory.getBean(IEnviarMensajeSimpleMailMessage.class);
 
        
        try {
        	String mensaje;
        	
        	mensaje = "Estimado(a): " + Inmueble.getNumRazSocial() + "\n";
        	mensaje = mensaje + "Un encargado se estará comunicando con ud. a los números " + Inmueble.getCelular() + " - " + Inmueble.getTelefono() + "\n";
        	mensaje = mensaje + "Saludos," + "\n";
        	mensaje = mensaje + "SINSENIOR CORP." + "\n";
        	enviarMensajeSimpleMailMessage.enviarMensaje(Inmueble.getCorreo(), mensaje,"Venta-SINSENIOR");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inmuebleDao.insertar(Inmueble);
    }

    @Override
    public Integer suscribir(inmueblesLista Inmueble) {
        log.info("Suscribir Inmueble");
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("/applicationContext.xml");
        
        IEnviarMensajeSimpleMailMessage enviarMensajeSimpleMailMessage=(IEnviarMensajeSimpleMailMessage)beanFactory.getBean(IEnviarMensajeSimpleMailMessage.class);
 
        
        try {
        	String mensaje;
        	
        	mensaje = "Estimado(a): " + Inmueble.getNumRazSocial() + "\n";
        	mensaje = mensaje + "Mensualmente le estar[an llegando las novedades sobre inmuebles de acuerdo a las caracteristicas ingresadas." + "\n";
        	mensaje = mensaje + "Saludos," + "\n";
        	mensaje = mensaje + "SINSENIOR CORP." + "\n";
        	enviarMensajeSimpleMailMessage.enviarMensaje(Inmueble.getCorreo(), mensaje,"Suscripcion-SINSENIOR");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inmuebleDao.suscribir(Inmueble);
    }

    @Override
    public Integer solicita(Inmueble Inmueble) {
        log.info("suscribe Inmueble");
        return inmuebleDao.solicita(Inmueble);
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
    @Override
    public List<Inmueble> buscarTodosEstadistico() {
        log.info("Buscando todas las inmuebles");
        return inmuebleDao.buscarTodosEstadistico();
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
    public inmueblesLista buscarFiltro(String codigoDistrito, String codigoInmueble,String deArea, String HastaArea,String deHab, String HastaHab) {
        log.info("Buscar Inmueble por id" + codigoDistrito);
        return inmuebleDao.buscarFiltro( codigoDistrito,  codigoInmueble, deArea,  HastaArea, deHab,  HastaHab);
    }

	@Override
	public List<inmueblesLista> buscarPreferencias() {

        log.info("Buscando Preferencias");
        return inmuebleDao.buscarPreferencias();
	}

	@Override
	public void AnulSuscrip(Integer id) {
        log.info("Eliminando Preferencias");
        inmuebleDao.AnulSuscrip(id);
		
	}
    
}
