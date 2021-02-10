/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.controller;

import emergon.entity.Family;
import emergon.entity.Salesman;
import emergon.service.FamilyService;
import emergon.service.SalesmanService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author tzortziskapellas
 */ @Controller
    @RequestMapping("/family")
public class FamilyController {
   
    @Autowired
    private FamilyService service;

    @RequestMapping
    public ModelAndView showSalesmen(ModelAndView modelAndView) {
        List<Family> family = service.getFamily();
        modelAndView.addObject("listOfSalesmen", family);
        //return the path where the jsp page exists. 
        //  WEB-INF/views/salesman/salesmanList.jsp
        modelAndView.setViewName("family/familyList");
        return modelAndView;
    }

}
