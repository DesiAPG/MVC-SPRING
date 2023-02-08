package com.course.mvc.Controller;


import com.course.mvc.Model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/app")
public class IndexController {

    @RequestMapping(path = {"/", "/home", "index"}, method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("title", "Hi from spring");
        return modelAndView;
    }

    @RequestMapping(path = "/profile", method = RequestMethod.GET)
    public ModelAndView profile() {
        User user = new User();
        user.setName("Duvan");
        user.setSurname("Marin");
        user.setEmail("duvan@gmail.com");
        ModelAndView modelAndView = new ModelAndView("profile");
        modelAndView.addObject("title", "Welcome, ".concat(user.getName()));
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    /*@RequestMapping(path = "/users", method = RequestMethod.GET)
    public ModelAndView profiles() {
        List<User> users = Arrays.asList(
                new User("juan", "camacho", "juan@email.com"),
                new User("Joan", "sarmiento", "joan@email.com"),
                new User("jose", "marin", "jose@email.com"),
                new User("julio", "cardona", "julio@email.com"));

        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("title", "List of users");
        modelAndView.addObject("users", users);
        return modelAndView;
    }*/

    @ModelAttribute("users")
    public List<User> userPoblate() {
        List<User> users = Arrays.asList(
                new User("juan", "camacho", "juan@email.com"),
                new User("Joan", "sarmiento", "joan@email.com"),
                new User("jose", "marin", "jose@email.com"),
                new User("Julio", "cardona", "julio@email.com"));
        return users;
    }
}
