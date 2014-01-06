package com.kairos.ebillquezelco.controller.login;


import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value = "/login",  method=RequestMethod.GET)
	public String login(Principal principal, Model model) {
		/*// If user is already authenticated, redirect them to home page.
		if (principal!=null) {
			return "redirect:/";
		}*/
		return "login/login";
	}
}
