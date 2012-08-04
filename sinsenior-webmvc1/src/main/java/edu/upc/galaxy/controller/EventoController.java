package edu.upc.galaxy.controller;

import edu.upc.galaxy.entity.Credential;
import edu.upc.galaxy.entity.Evento;
import edu.upc.galaxy.service.EventoService;
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

/**
 *
 * @author gian
 */
@Controller("eventoController")
public class EventoController {

    @Autowired
    private EventoService eventoService;
    private static Logger log = LoggerFactory.getLogger(EventoController.class);

    @RequestMapping("/eventos/index")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("eventos/index");
        List<Evento> eventos = eventoService.buscarTodos();
        mav.addObject("eventos", eventos);
        return mav;
    }
    
    @RequestMapping(value = "/eventos/new", method = RequestMethod.GET)
    public ModelAndView newEvento() {
        ModelAndView mav = new ModelAndView("eventos/new");
        Evento evento = new Evento();
        mav.getModelMap().put("evento", evento);
        return mav;
    }

    @RequestMapping(value = "/eventos/new", method = RequestMethod.POST)
    public String createEvento(@ModelAttribute("evento")Evento evento, SessionStatus status) {    
        eventoService.insertar(evento);
        status.setComplete();
        return "redirect:/pages/eventos/index";
    }
    
    @RequestMapping(value = "/eventos/edit", method = RequestMethod.GET)
    public ModelAndView editEvento(@RequestParam("id")Integer id) {    
        ModelAndView mav = new ModelAndView("eventos/edit");
        Evento evento = eventoService.buscar(id);
        mav.getModelMap().put("evento", evento);
        return mav;        
    }
    
    @RequestMapping(value="/eventos/edit", method=RequestMethod.POST)
    public String update(@ModelAttribute("evento") Evento evento, SessionStatus status) {
        eventoService.actualizar(evento);
        status.setComplete();
        return "redirect:/pages/eventos/index";
    }
    
    @RequestMapping("/eventos/delete")
    public ModelAndView delete(@RequestParam("id")Integer id)
    {
        ModelAndView mav = new ModelAndView("redirect:/pages/eventos/index");
        Evento evento = eventoService.buscar(id);
        eventoService.eliminar(evento);
        return mav;
    }
    
    @RequestMapping("/eventos/login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("eventos/login");
        Credential credential = new Credential();
        mav.getModelMap().put("credential", credential);
        return mav;
    }    
    
    @RequestMapping(value = "/eventos/autenticar", method=RequestMethod.POST)
    public String autenticar(@ModelAttribute("credential") Credential credential,HttpServletRequest request) {
        if (eventoService.autenticar(credential.getCorreo(), credential.getPassword())) {
            request.getSession().setAttribute("credential",credential);
            return "redirect:/pages/eventos/index";
        }
        return "redirect:/pages/eventos/login";
    }
    
    @RequestMapping("/eventos/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/pages/eventos/login";
    }        
    
    
}
