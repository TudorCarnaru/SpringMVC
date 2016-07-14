package co.uk.endava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView welcome(HttpServletRequest request) {
        //new ModelAndView("Test");
        //new ModelAndView("Test","modelName", "model value");
        //new ModelAndView("Test",new HashMap<String, Object>());
        return new ModelAndView("welcome","message","Good morning!");
    }
    @RequestMapping(value="/InsertStuff", method= RequestMethod.GET)
    public ModelAndView student() {
        return new ModelAndView("LogIn", "command", new User());
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("SpringWeb")User user,
                             ModelMap model) {
        model.addAttribute("username", user.getUsername());
        model.addAttribute("password", user.getPassword());
        return "result";
    }
}
