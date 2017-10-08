package com.springguru.springbootjokesapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Do My Duyen on 8/18/2017.
 */
@Controller
public class ChuckController {

    @RequestMapping({"/", ""})
    public String chuckNorris(Model model) {
        model.addAttribute("joke", "Joke test");
        return "chucknorris";
    }
}
