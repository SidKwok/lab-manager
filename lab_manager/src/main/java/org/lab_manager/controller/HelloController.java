package org.lab_manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/")
public class HelloController {
    /**
     * 首页导航，将用户导向index.jsp
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        System.out.println("HelloController called !");
        return "front/index";
    }
}