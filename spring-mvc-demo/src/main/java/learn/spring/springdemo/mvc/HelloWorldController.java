package learn.spring.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/helloworld")
public class HelloWorldController {

    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    @RequestMapping("processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model) {
        // read the request parameter from html form
        String name = request.getParameter("studentName");
        // convert data to all caps
        name = name.toUpperCase();
        // create message
        String result = "Yo! " + name;
        // add message to model
        model.addAttribute("message", result);
        
        return "helloworld";
    }
    
    @RequestMapping("processFormVersionThree")
    public String letsShoutDude(@RequestParam("studentName") String name, Model model) {
        // convert data to all caps
        name = name.toUpperCase();
        // create message
        String result = "Hey! " + name;
        // add message to model
        model.addAttribute("message", result);
        
        return "helloworld";
    }
    
}
