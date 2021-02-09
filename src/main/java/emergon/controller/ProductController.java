/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.controller;

import emergon.entity.Product;
import emergon.service.ProductService;
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

/**
 *
 * @author tzortziskapellas
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    
    @Autowired
    private ProductService service;
    
     @RequestMapping
    public ModelAndView showProducts(ModelAndView modelAndView){
        List<Product> products = service.getProducts();
        modelAndView.addObject("listOfProducts", products);
        modelAndView.setViewName("productList");
        return modelAndView;
    }
    
    /**
     * URLs
     * /product/create : GET  (productList.jsp - link)
     * /product/create : POST (productForm.jsp - form)
     */
    
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showForm(){
        return "productForm";
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Product product, RedirectAttributes attributes){
        service.addProduct(product);
        String minima = "Product "+ product.getPdescr() + " successfully created!!";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/product";//Redirect instructs client to sent a new GET request to /product
    }
    
    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id, RedirectAttributes attributes){
        service.deleteProduct(id);
        String minima = "Product successfully deleted!!";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/product";
    }
    
    @GetMapping("/update/{pcode}")
    public String showFormUpdate(@PathVariable("pcode") int pcode, Model model){
        Product product = service.getProductById(pcode);
        model.addAttribute("productToEdit", product);
        return "productForm";
    }
    
    @PostMapping("/update")
    public String update(Product product, RedirectAttributes attributes){
        service.updateProduct(product);
        String minima = "Product updated successfully!!";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/product";
    }
    
}
