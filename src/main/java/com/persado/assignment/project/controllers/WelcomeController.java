package com.persado.assignment.project.controllers;

// Created by Anagnostakis *\n \*/

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

    @RequestMapping({"", "/", "/index"})
    public String greeting() {
        return "welcome";
    }

    //========Return button========//
    @RequestMapping("/welcome")
    public String returnTo(Model model) {
        return "welcome";
    }
}
