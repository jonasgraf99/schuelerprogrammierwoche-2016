package com.sybit.education.taschengeldboerse.controller;


import com.sybit.education.taschengeldboerse.domain.Schueler;
import com.sybit.education.taschengeldboerse.service.UserService;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



/**
 * Handles requests for the application home page.
 */
@Controller
public class AnbieterController {

    private static final Logger logger = LoggerFactory.getLogger(AnbieterController.class);

    
    @Autowired
    private UserService userService;
   
    /**
    * Simply selects the home view to render by returning its name.
    *
    * @param request needed to get the referring url
    * @return the logical view to be returned
    */
   @RequestMapping(value = "/registrieren/anbieter", method = RequestMethod.GET)
   public String registrierenFormular( final HttpServletRequest request) {
     
      return "registrieren-anbieter";
   }
   
    /**
     * Speichere neuen Anbieter.
     *
     * @param anbieter
     * @return the logical view to be returned
     */
    @RequestMapping(value = "/registrieren/anbieter", method = RequestMethod.POST)
    public ModelAndView saveForm(@ModelAttribute("anbieter") Schueler anbieter) {
        
        anbieter = userService.saveSchueler(anbieter);
        
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("anbieter", anbieter);

        modelAndView.setViewName("registrieren-anbieter");

        return modelAndView;
    }
}