package apap.tugas.sipes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SipesController {
    @GetMapping("/")
    private String home() {
        return "home";
    }
}