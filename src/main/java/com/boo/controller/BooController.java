package com.boo.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BooController {

	@RequestMapping(value = "/start", method = RequestMethod.GET)
	public ModelAndView startIt(@RequestParam(value = "pol", required = false, defaultValue = "Guest") String name,
	    HttpServletResponse res) throws ServletException, IOException {
		// System.out.println(req.getAttributeNames().toString());
		// System.out.println(req.getParameter("pol"));

		// int id = Integer.parseInt(req.getParameter("pol"));
		// System.out.println(req.getParameter("pol").toString());
		return new ModelAndView("hello " + name, "now", new Date());
	}
}
