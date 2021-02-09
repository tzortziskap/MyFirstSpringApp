package emergon.controller;

import emergon.entity.Salesman;
import emergon.service.SalesmanService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/salesman")
public class SalesmanController {
    
    @Autowired
    private SalesmanService service;
    
    @RequestMapping
    public ModelAndView showSalesmans(ModelAndView modelAndView){
        List<Salesman> salesmans = service.getSalesmans();
        modelAndView.addObject("listOfSalesmans", salesmans);
        modelAndView.setViewName("salesmanList");
        return modelAndView;
    }
    
    /**
     * URLs
     * /salesman/create : GET  (salesmanList.jsp - link)
     * /salesman/create : POST (salesmanForm.jsp - form)
     * @return 
     */
    
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showForm(){
        return "salesmanForm";
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Salesman salesman, RedirectAttributes attributes){
        service.addSalesman(salesman);
        String minima = "Salesman "+ salesman.getSname()+ " successfully created!!";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/salesman";//Redirect instructs client to sent a new GET request to /salesman
    }
    
    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id, RedirectAttributes attributes){
        String minima = service.deleteSalesman(id);
        attributes.addFlashAttribute("message", minima);
        return "redirect:/salesman";
    }
    
    @GetMapping("/update/{scode}")
    public String showFormUpdate(@PathVariable("scode") int scode, Model model){
        Salesman salesman = service.getSalesmanById(scode);
        model.addAttribute("salesmanToEdit", salesman);
        return "salesmanForm";
    }
    
    @PostMapping("/update")
    public String update(Salesman salesman, RedirectAttributes attributes){
        service.updateSalesman(salesman);
        String minima = "Salesman updated successfully!!";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/salesman";
    }
    
    
    
    
    
    
}
