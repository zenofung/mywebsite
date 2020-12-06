package com.website.company.controller.api;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author pengyangyan
 */
@Controller
@RequestMapping("/error")
public class BaseErrorPage implements ErrorController {

    @Override
    public String getErrorPath() {
        return "redirect:/404";
    }

    @RequestMapping
    public String error() {
        return getErrorPath();
    }
}
