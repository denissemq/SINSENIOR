package edu.upc.galaxy.controller;

import edu.upc.galaxy.entity.Credential;
import edu.upc.galaxy.entity.Local;
import edu.upc.galaxy.service.LocalService;
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
@Controller("localController")
public class LocalController {

    @Autowired
    private LocalService localService;
    private static Logger log = LoggerFactory.getLogger(LocalController.class);

    @RequestMapping("/locales/index")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("locales/index");
        List<Local> locales = localService.buscarTodos();
        mav.addObject("locales", locales);
        return mav;
    }
    
    @RequestMapping(value = "/locales/new", method = RequestMethod.GET)
    public ModelAndView newLocal() {
        ModelAndView mav = new ModelAndView("locales/new");
        Local local = new Local();
        mav.getModelMap().put("local", local);
        return mav;
    }

    @RequestMapping(value = "/locales/new", method = RequestMethod.POST)
    public String createLocal(@ModelAttribute("local")Local local, SessionStatus status) {    
        localService.insertar(local);
        status.setComplete();

        return "redirect:/pages/locales/index";
        
    }
    
    @RequestMapping(value = "/locales/edit", method = RequestMethod.GET)
    public ModelAndView editLocal(@RequestParam("id")Integer id) {    
        ModelAndView mav = new ModelAndView("locales/edit");
        Local local = localService.buscar(id);
        mav.getModelMap().put("local", local);
        return mav;        
    }
    
    @RequestMapping(value="/locales/edit", method=RequestMethod.POST)
    public String update(@ModelAttribute("local") Local local, SessionStatus status) {
        localService.actualizar(local);
        status.setComplete();
        return "redirect:/pages/locales/index";
    }
    
    @RequestMapping("/locales/delete")
    public ModelAndView delete(@RequestParam("id")Integer id)
    {
        ModelAndView mav = new ModelAndView("redirect:/pages/locales/index");
        Local local = localService.buscar(id);
        localService.eliminar(local);
        return mav;
    }
    
    @RequestMapping("/locales/login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("locales/login");
        Credential credential = new Credential();
        mav.getModelMap().put("credential", credential);
        return mav;
    }    
    
    @RequestMapping(value = "/locales/autenticar", method=RequestMethod.POST)
    public String autenticar(@ModelAttribute("credential") Credential credential,HttpServletRequest request) {
        if (localService.autenticar(credential.getCorreo(), credential.getPassword())) {
            request.getSession().setAttribute("credential",credential);
            return "redirect:/pages/locales/index";
        }
        return "redirect:/pages/locales/login";
    }
    
    @RequestMapping("/locales/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/pages/locales/login";
    }        
    
    
}
