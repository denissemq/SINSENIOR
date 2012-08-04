package edu.upc.galaxy.controller;

import edu.upc.galaxy.entity.Credential;
import edu.upc.galaxy.entity.Publicidad;
import edu.upc.galaxy.service.PublicidadService;
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
@Controller("publicidadController")
public class PublicidadController {

    @Autowired
    private PublicidadService publicidadService;
    private static Logger log = LoggerFactory.getLogger(PublicidadController.class);

    @RequestMapping("/publicidades/index")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("publicidades/index");
        List<Publicidad> publicidades = publicidadService.buscarTodos();
        mav.addObject("publicidades", publicidades);
        return mav;
    }
    
    @RequestMapping(value = "/publicidades/new", method = RequestMethod.GET)
    public ModelAndView newPublicidad() {
        ModelAndView mav = new ModelAndView("publicidades/new");
        Publicidad publicidad = new Publicidad();
        mav.getModelMap().put("publicidad", publicidad);
        return mav;
    }

    @RequestMapping(value = "/publicidades/new", method = RequestMethod.POST)
    public String createPublicidad(@ModelAttribute("publicidad")Publicidad publicidad, SessionStatus status) {    
        publicidadService.insertar(publicidad);
        status.setComplete();

        return "redirect:/pages/publicidades/index";
        
    }
    
    @RequestMapping(value = "/publicidades/edit", method = RequestMethod.GET)
    public ModelAndView editPublicidad(@RequestParam("id")Integer id) {    
        ModelAndView mav = new ModelAndView("publicidades/edit");
        Publicidad publicidad = publicidadService.buscar(id);
        mav.getModelMap().put("publicidad", publicidad);
        return mav;        
    }
    
    @RequestMapping(value="/publicidades/edit", method=RequestMethod.POST)
    public String update(@ModelAttribute("publicidad") Publicidad publicidad, SessionStatus status) {
        publicidadService.actualizar(publicidad);
        status.setComplete();
        return "redirect:/pages/publicidades/index";
    }
    
    @RequestMapping("/publicidades/delete")
    public ModelAndView delete(@RequestParam("id")Integer id)
    {
        ModelAndView mav = new ModelAndView("redirect:/pages/publicidades/index");
        Publicidad publicidad = publicidadService.buscar(id);
        publicidadService.eliminar(publicidad);
        return mav;
    }
    
    @RequestMapping("/publicidades/login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("publicidades/login");
        Credential credential = new Credential();
        mav.getModelMap().put("credential", credential);
        return mav;
    }    
    
    @RequestMapping(value = "/publicidades/autenticar", method=RequestMethod.POST)
    public String autenticar(@ModelAttribute("credential") Credential credential,HttpServletRequest request) {
        if (publicidadService.autenticar(credential.getCorreo(), credential.getPassword())) {
            request.getSession().setAttribute("credential",credential);
            return "redirect:/pages/publicidades/index";
        }
        return "redirect:/pages/publicidades/login";
    }
    
    @RequestMapping("/publicidades/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/pages/publicidades/login";
    }        
    
    
}
