package com.example.relationdb_java.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Halaman Home
    @GetMapping("/")
    public String home() {
        return "index";
    }

}
