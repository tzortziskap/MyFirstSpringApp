package emergon.controller;

import emergon.entity.Customer;
import emergon.service.CustomerService;
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
@RequestMapping("/customer")
public class CustomerController {
    
    @Autowired
    private CustomerService service;
    
    @RequestMapping
    public ModelAndView showCustomers(ModelAndView modelAndView){
        List<Customer> customers = service.getCustomers();
        modelAndView.addObject("listOfCustomers", customers);
        modelAndView.setViewName("customerList");
        return modelAndView;
    }
    
    /**
     * URLs
     * /customer/create : GET  (customerList.jsp - link)
     * /customer/create : POST (customerForm.jsp - form)
     */
    
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showForm(){
        return "customerForm";
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Customer customer, RedirectAttributes attributes){
        service.addCustomer(customer);
        String minima = "Customer "+ customer.getCname() + " successfully created!!";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/customer";//Redirect instructs client to sent a new GET request to /customer
    }
    
    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id, RedirectAttributes attributes){
        service.deleteCustomer(id);
        String minima = "Customer successfully deleted!!";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/customer";
    }
    
    @GetMapping("/update/{ccode}")
    public String showFormUpdate(@PathVariable("ccode") int ccode, Model model){
        Customer customer = service.getCustomerById(ccode);
        model.addAttribute("customerToEdit", customer);
        return "customerForm";
    }
    
    @PostMapping("/update")
    public String update(Customer customer, RedirectAttributes attributes){
        service.updateCustomer(customer);
        String minima = "Customer updated successfully!!";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/customer";
    }
    
    
    
    
    
    
}
