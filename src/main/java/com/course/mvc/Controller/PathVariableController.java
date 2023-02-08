package com.course.mvc.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/path-variable")
public class PathVariableController {
    @GetMapping("/String/{text}")
    public String variablePath(@PathVariable String text, Model model) {
        model.addAttribute("title", "Recive params from path (@PathVariable)");
        model.addAttribute("result", "Text sent is: " + text);
        return "variables/watch";
    }

}
