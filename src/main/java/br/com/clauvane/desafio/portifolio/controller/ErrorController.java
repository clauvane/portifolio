package br.com.clauvane.desafio.portifolio.controller;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@Service
public class ErrorController {

    @ExceptionHandler(Exception.class)
    public String handleException(HttpServletRequest request, Exception ex, Model model) {
        model.addAttribute("exception", ex.getLocalizedMessage());
        model.addAttribute("url", request.getRequestURL());

        return "error";
    }

}
