package emergon.controller;

import emergon.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")//This will be inherited from all the methods of the controller
public class HomeController {
    
    @Autowired
    private HomeService homeService;
    
    //    /application/
    @RequestMapping("/")
    public String showHome(Model model){
        String message = homeService.getWelcomeMessage();
//        Key = Value (myMessage = message)
        model.addAttribute("myMessage", message);
        return "home";//This method returns the name of the jsp page.
    }
    
    //     /application/appName
//    localhost:8080/MySpringMVCApp/ is implicit
    @RequestMapping("/appName")//Where does this method listen to (which URL).
    public String showNameOfApplication(Model model){
        String appName = homeService.getApplicationName();
        model.addAttribute("myMessage", appName);
        return "home";
    }
}
