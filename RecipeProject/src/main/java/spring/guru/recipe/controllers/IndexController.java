package spring.guru.recipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Do My Duyen on 8/19/2017.
 */
@Controller
public class IndexController {

    @RequestMapping({"","/","/index"})
    public String getIndexPage() {
        System.out.println("kjdaskjdakjsdkjadasdaskjdskjfsdkj");
        return "index";
    }
}
