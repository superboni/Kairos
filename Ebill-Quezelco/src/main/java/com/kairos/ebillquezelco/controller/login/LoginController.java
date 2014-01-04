package com.kairos.ebillquezelco.controller.login;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value = "/login",  method=RequestMethod.GET)
	public String login() {
		// Check if user is already authenticated, redirect them to home page.
		Boolean isAuthenticated = SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
		if (isAuthenticated) {
			return "home/index";
		}
		return "login/login";
	}
}
