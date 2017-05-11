package com.zslin.web.controller.web;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zsl-pc on 2016/10/10.
 */
@Controller
public class AppErrorController implements ErrorController {

    private static final String PATH = "/error";

    @RequestMapping(value = "/404")
    public String e404(Model model, HttpServletRequest request) {
        return "404";
    }

    @RequestMapping(value = "/500")
    public String e500(Model model, HttpServletRequest request) {
        return "/500.html";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
