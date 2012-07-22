package edu.upc.galaxy.controller;

import edu.upc.galaxy.entity.Credential;
import edu.upc.galaxy.entity.DropDownList;
import edu.upc.galaxy.entity.Inmueble;
import edu.upc.galaxy.service.InmuebleService;
import edu.upc.galaxy.service.DropDownListService;
import edu.upc.galaxy.service.impl.DropDownListServiceImpl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.junit.runner.Request;
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
@Controller("inmuebleController")
public class InmuebleController {

    @Autowired
    private InmuebleService inmuebleService;
    
    private static Logger log = LoggerFactory.getLogger(InmuebleController.class);

    @RequestMapping("/inmuebles/index")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("inmuebles/index");
        List<Inmueble> inmuebles = inmuebleService.buscarTodos();
        mav.addObject("inmuebles", inmuebles);
        return mav;
    }
    @RequestMapping("/inmuebles/indexcomenta")
    public ModelAndView indexcomenta() {
        ModelAndView mav = new ModelAndView("inmuebles/indexcomenta");
        List<Inmueble> inmuebles = inmuebleService.buscarTodos();
        mav.addObject("inmuebles", inmuebles);
        return mav;
    }

    @RequestMapping("/inmuebles/compra")
    public ModelAndView compra() {
        ModelAndView mav = new ModelAndView("inmuebles/compra");
        List<Inmueble> inmuebles = inmuebleService.buscarTodos();
        mav.addObject("inmuebles", inmuebles);
        return mav;
    }

    @RequestMapping("/inmuebles/venta")
    public ModelAndView venta(HttpServletRequest request) {
    	 ModelAndView mav = new ModelAndView("inmuebles/venta");
         Inmueble inmueble = new Inmueble();
         mav.getModelMap().put("inmuebles", inmueble);
         
         return mav;
    }


    @RequestMapping(value = "/inmuebles/new", method = RequestMethod.GET)
    public ModelAndView newinmueble() {
        ModelAndView mav = new ModelAndView("inmuebles/new");
        Inmueble inmueble = new Inmueble();
        mav.getModelMap().put("inmueble", inmueble);
        return mav;
    }

    @RequestMapping(value = "/inmuebles/new", method = RequestMethod.POST)
    public String createinmueble(@ModelAttribute("inmueble")Inmueble inmueble, SessionStatus status) {    
        inmuebleService.insertar(inmueble);
        status.setComplete();
        return "redirect:/pages/inmuebles/compra";
    }
    
    
    
    @RequestMapping(value = "/inmuebles/editcomenta", method = RequestMethod.GET)
    public ModelAndView editcomentainmueble(@RequestParam("id")Integer id) {    
        ModelAndView mav = new ModelAndView("inmuebles/editcomenta");
        Inmueble inmueble = inmuebleService.buscar(id);
        mav.getModelMap().put("inmueble", inmueble);
        return mav;        
    }   
    
  
/*     @RequestMapping(value="/inmuebles/editcomenta", method=RequestMethod.POST)
    public String update(@ModelAttribute("inmueble") inmueble inmueble, SessionStatus status) {
        inmuebleService.actualizar(inmueble);
        status.setComplete();
        return "redirect:/pages/inmuebles/indexcomenta";
    }   
  */
    @RequestMapping("/inmuebles/delete")
    public ModelAndView delete(@RequestParam("id")Integer id)
    {
        ModelAndView mav = new ModelAndView("redirect:/pages/inmuebles/index");
        Inmueble inmueble = inmuebleService.buscar(id);
        inmuebleService.eliminar(inmueble);
        return mav;
    }
    
    @RequestMapping("/inmuebles/login")
    public ModelAndView login(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("inmuebles/login");
        Credential credential = new Credential();
        mav.getModelMap().put("credential", credential);
        return mav;
    }    
    
   
    
    @RequestMapping("/inmuebles/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/pages/inmuebles/login";
    }        
    
    
}
