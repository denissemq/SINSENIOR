package edu.upc.galaxy.service.impl;

import edu.upc.galaxy.dao.CitaDao;
import edu.upc.galaxy.dao.impl.CitaDaoImpl;
import edu.upc.galaxy.entity.Cita;
import edu.upc.galaxy.service.CitaService;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
/**
 *
 * @author gian
 *
 */
@Service
public class CitasServiceImpl implements CitaService {

    private static Logger log = LoggerFactory.getLogger(CitaDaoImpl.class);    
    
    @Autowired
    private CitaDao CitaDao;

    @Override
    public Integer insertar(Cita Cita) {
        log.info("Creando Cita");
        return CitaDao.insertar(Cita);
    }

    @Override
    public void actualizar(Cita Cita) {
        log.info("Actualizando Cita");
        CitaDao.actualizar(Cita);
    }
    @Override
    public void Aceptar(Cita Cita) {
        log.info("Actualizando Cita");
        CitaDao.Aceptar(Cita);
    }
    
    @Override
    public void anular(Integer id, Integer codigoUsuario) {
        log.info("Anulando Cita");
        CitaDao.anular(id, codigoUsuario);
    }

    @Override
    public void anularOperacion(Integer id, Integer codigoUsuario, Integer codigoEstado) {
        log.info("Anulando Cita");
        CitaDao.anularOperacion(id, codigoUsuario,codigoEstado);
    }
    @Override
    public List<Cita> buscarTodos() {
        log.info("Buscando todas las Citas");
        return CitaDao.buscarTodos();
    }

    @Override
    public List<Cita> buscarTodosDisponibles() {
        log.info("Buscando todas las Citas");
        return CitaDao.buscarTodosDisponibles();
    }
    @Override
    public List<Cita> buscarTodosPendientes(Integer id) {
        log.info("Buscando todas las Citas");
        return CitaDao.buscarTodosPendientes(id);
    }
    @Override
    public Cita buscar(Integer id) {
        log.info("Buscar Cita por id");
        return CitaDao.buscar(id);
    }
    @Override

    public Cita ValidarDocumento(String tipoPersona, String docId, Integer id){
        log.info("Buscar Cita por id");
        Cita cita = new Cita();
        cita = CitaDao.buscar(id);
        if (tipoPersona.equalsIgnoreCase("1")){
        	cita= cita;
        }else{
        	cita= ValidarDatos(tipoPersona,docId,cita);
        
        }
        return cita;
    }
    public Cita ValidarDatos(String tipoPersona, String docId,Cita cita) {
    	
			    	
			URL url;
			try {
				url = new URL("http://www.sunat.gob.pe/w/wapS01Alias?ruc="+ docId );
			
			BufferedReader br;
			try {
				br = new BufferedReader(new InputStreamReader(url.openStream()));
			
			String entrada;
			String cadena="";
			
			while ((entrada = br.readLine()) != null){
				cadena = cadena + entrada;
			    		}
			if (cadena.indexOf("Resultado")!=-1){
			cadena = cadena.substring(cadena.indexOf("Resultado"));

			cadena = cadena.replaceAll("<small>", "¬");
			cadena = cadena.replaceAll("</small>", "");
			cadena = cadena.replaceAll("<strong>", "");
			cadena = cadena.replaceAll("</strong>", "");
			cadena = cadena.replaceAll("<b>", "");
			cadena = cadena.replaceAll("</b>", "");
			cadena = cadena.replaceAll("<p>", "");
			cadena = cadena.replaceAll("</p>", "");
			cadena = cadena.replaceAll("  ", "");
			cadena = cadena.replaceAll("<br/>", "");
			
	        log.info("cadena:   " + cadena);
	        
			String[] arreglo = cadena.split("¬");

			cadena="";
	        log.info("asrreglo tam-" + arreglo.length);
			for (Integer contar=0; contar <= arreglo.length-1; contar ++){
				String nodo;
				nodo = arreglo[contar];
				
		        log.info("arreglo["+ contar.toString() + "]:   " + nodo);
		        log.info("index" + nodo.indexOf("mero Ruc."));
				if (nodo.indexOf("mero Ruc.")>-1){
			        log.info("ruc:   " + nodo);
			        nodo =  nodo.substring(nodo.indexOf("mero Ruc."));
			        nodo = nodo.replaceAll("mero Ruc.","RUC: ");
					cadena = cadena + nodo;
				}
		        log.info("index" + nodo.indexOf("Estado."));
				if (nodo.indexOf("Estado.")>-1){
			        log.info("Estado.:   " + nodo);
			        nodo =  nodo.substring(nodo.indexOf("Estado."));
			        nodo = nodo.replaceAll("Estado.","\nEstado: ");
					cadena = cadena + nodo;
				}
		        log.info("index" + nodo.indexOf("Direcci&#xF3;n."));
				if (nodo.indexOf("Direcci&#xF3;n.")>-1){
			        log.info("Direcci&#xF3;n.:   " + nodo);
			        nodo =  nodo.substring(nodo.indexOf("Direcci&#xF3;n."));
			        nodo = nodo.replaceAll("Direcci&#xF3;n.","\nDireccion: ");
					cadena = cadena + nodo;
				}
				
			}
	        log.info("cadena:   " + cadena);
			}else{
				cadena="El numero Ruc ingresado es invalido.";
		        log.info("cadena:   " + cadena);
			}
			cita.setObservacionesic(cadena);
						} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
			
				return cita;
				
			}
    
}
