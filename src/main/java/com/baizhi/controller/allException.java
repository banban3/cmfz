package com.baizhi.controller;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class allException implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object method, Exception exec) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(exec.getMessage());
        modelAndView.setViewName("500");
        modelAndView.addObject("message", exec.getMessage());

        return modelAndView;
    }
}
