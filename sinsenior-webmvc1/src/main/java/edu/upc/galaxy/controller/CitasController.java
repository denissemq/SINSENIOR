package edu.upc.galaxy.controller;

import edu.upc.galaxy.entity.Credential;
import edu.upc.galaxy.entity.Cita;
import edu.upc.galaxy.service.CitaService;
import edu.upc.galaxy.service.InmuebleService;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gian
 */
@Controller("citasController")
public class CitasController {

    @Autowired
    private CitaService citaservice;
    private InmuebleService inmuebleService;
    private static Logger log = LoggerFactory.getLogger(CitasController.class);

    @RequestMapping("/citas/pendientes")
    public ModelAndView pendientes() {
        ModelAndView mav = new ModelAndView("citas/pendientes");
        List<Cita> citas = citaservice.buscarTodosPendientes();
        mav.addObject("cita", citas);
        return mav;
    }

    @RequestMapping("/citas/disponibles")
    public ModelAndView disponibles() {
        ModelAndView mav = new ModelAndView("citas/disponibles");
        List<Cita> citas = citaservice.buscarTodosDisponibles();
        mav.addObject("cita", citas);
        return mav;
    }
    @RequestMapping(value = "/citas/new", method = RequestMethod.GET)
    public ModelAndView newCita() {
        ModelAndView mav = new ModelAndView("citas/new");
        Cita cita = new Cita();
        mav.getModelMap().put("cita", cita);
        return mav;
    }

    @RequestMapping(value = "/citas/new", method = RequestMethod.POST)
    public String createCita(@ModelAttribute("cita")Cita cita, SessionStatus status) {    
        citaservice.insertar(cita);
        status.setComplete();
        return "redirect:/pages/citas/index";
    }
    
    @RequestMapping(value = "/citas/edit", method = RequestMethod.GET)
    public ModelAndView editCita(@RequestParam("id")Integer id,HttpServletRequest request) {    
        ModelAndView mav = new ModelAndView("citas/edit");
 
        Cita cita = citaservice.buscar(id);
        mav.getModelMap().put("cita", cita);
        
        return mav;        
    }
    
    @RequestMapping(value="/citas/edit", method=RequestMethod.POST)
    public String update(@ModelAttribute("cita") Cita cita, SessionStatus status) {
        citaservice.actualizar(cita);
        status.setComplete();
        return "redirect:/pages/citas/disponibles";
    }
    
    @RequestMapping("/citas/anular")
    public ModelAndView anular(@RequestParam("id")Integer id,@RequestParam("codigoUsuario")Integer codigoUsuario, SessionStatus status)
    {
        ModelAndView mav = new ModelAndView("redirect:/pages/citas/disponibles");
        citaservice.anular(id,codigoUsuario);
        status.setComplete();
        return mav;
    }
    
    @RequestMapping("/citas/login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("citas/login");
        Credential credential = new Credential();
        mav.getModelMap().put("credential", credential);
        return mav;
    }    
    
     
    @RequestMapping("/citas/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/pages/citas/login";
    }        
    
    
}
