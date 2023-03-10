package com.course.mvc.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static java.awt.SystemColor.text;

@Controller
@RequestMapping("/params")
public class ParamsController {

    @GetMapping("/")
    public String index() {
        return "params/index";
    }

    @GetMapping("/watch")
    public String param(@RequestParam(name = "text", defaultValue = "No text") String text, Model model) {
        model.addAttribute("result", "Text sent is: " + text);
        return "params/watch";
    }

    @GetMapping("/mix-params")
    public String param(@RequestParam String wave, @RequestParam Integer number, Model model) {
        model.addAttribute("result", "Text sent is: '" + wave + "' and the number is '" + number + "'");
        return "params/watch";
    }

    @GetMapping("/mix-params-request")
    public String param(HttpServletRequest request, Model model) {
        String wave = request.getParameter("wave");
        Integer number = null;
        try {
            number = Integer.parseInt(request.getParameter("number"));
        } catch (NumberFormatException e) {
            number = 0;
        }
        model.addAttribute("result", "Text sent is: '" + wave + "' and the number is '" + number + "'");
        return "params/watch";
    }
}
