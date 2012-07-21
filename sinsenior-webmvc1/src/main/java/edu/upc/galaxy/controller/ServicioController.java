package edu.upc.galaxy.controller;

import edu.upc.galaxy.entity.Credential;
import edu.upc.galaxy.entity.Servicio;
import edu.upc.galaxy.service.ServicioService;
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
@Controller("servicioController")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;
    private static Logger log = LoggerFactory.getLogger(ServicioController.class);

    @RequestMapping("/servicios/index")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("servicios/index");
        List<Servicio> servicios = servicioService.buscarTodos();
        mav.addObject("servicios", servicios);
        return mav;
    }
    
    @RequestMapping(value = "/servicios/new", method = RequestMethod.GET)
    public ModelAndView newServicio() {
        ModelAndView mav = new ModelAndView("servicios/new");
        Servicio servicio = new Servicio();
        mav.getModelMap().put("servicio", servicio);
        return mav;
    }

    @RequestMapping(value = "/servicios/new", method = RequestMethod.POST)
    public String createServicio(@ModelAttribute("servicio")Servicio servicio, SessionStatus status) {    
        servicioService.insertar(servicio);
        status.setComplete();

        return "redirect:/pages/servicios/index";
        
    }
    
    @RequestMapping(value = "/servicios/edit", method = RequestMethod.GET)
    public ModelAndView editServicio(@RequestParam("id")Integer id) {    
        ModelAndView mav = new ModelAndView("servicios/edit");
        Servicio servicio = servicioService.buscar(id);
        mav.getModelMap().put("servicio", servicio);
        return mav;        
    }
    
    @RequestMapping(value="/servicios/edit", method=RequestMethod.POST)
    public String update(@ModelAttribute("servicio") Servicio servicio, SessionStatus status) {
        servicioService.actualizar(servicio);
        status.setComplete();
        return "redirect:/pages/servicios/index";
    }
    
    @RequestMapping("/servicios/delete")
    public ModelAndView delete(@RequestParam("id")Integer id)
    {
        ModelAndView mav = new ModelAndView("redirect:/pages/servicios/index");
        Servicio servicio = servicioService.buscar(id);
        servicioService.eliminar(servicio);
        return mav;
    }
    
    @RequestMapping("/servicios/login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("servicios/login");
        Credential credential = new Credential();
        mav.getModelMap().put("credential", credential);
        return mav;
    }    
    
    @RequestMapping(value = "/servicios/autenticar", method=RequestMethod.POST)
    public String autenticar(@ModelAttribute("credential") Credential credential,HttpServletRequest request) {
        if (servicioService.autenticar(credential.getCorreo(), credential.getPassword())) {
            request.getSession().setAttribute("credential",credential);
            return "redirect:/pages/servicios/index";
        }
        return "redirect:/pages/servicios/login";
    }
    
    @RequestMapping("/servicios/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/pages/servicios/login";
    }        
    
    
}
