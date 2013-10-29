package com.boo.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.boo.model.BooModel;
import com.boo.service.BooService;

@Controller
public class BooController {

	@Autowired
	BooService boo;

	@RequestMapping(value = "/start", method = RequestMethod.GET)
	public ModelAndView startIt(@RequestParam(value = "pol", required = false, defaultValue = "Guest") String name,
	    HttpServletResponse res, ModelMap map) throws ServletException, IOException {

		Map<String, Object> objectToView = new HashMap();
		List<BooModel> booModelList = boo.GetUsersList();
		objectToView.put("users", booModelList);
		objectToView.put("name", name);
		objectToView.put("now", new Date());
		map.get("name");
		return new ModelAndView("hello", objectToView);

		/* get the model filled using the map in Model Map below. */
		// int id = Integer.parseInt(req.getParameter("pol"));
		// System.out.println(req.getParameter("pol").toString());
		// map.addAttribute("name", name);

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String stopIt(ModelMap map) {

		return "login";

	}

	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {

		model.addAttribute("error", "true");
		return "login";

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {

		return "login";

	}

	@RequestMapping(value = "add/", method = RequestMethod.POST)
	public String addIt(HttpServletRequest req, ModelMap map) {

		String fname, lname;
		fname = req.getParameter("fname");
		lname = req.getParameter("lname");
		System.out.println(lname);
		System.out.println(fname);
		try {
			boo.updateUserDetails(fname, lname);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "redirect:/start?pol=" + fname;

	}
}
