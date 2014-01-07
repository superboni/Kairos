package com.kairos.ebillquezelco.controller.user;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kairos.ebillquezelco.domain.user.UserAccount;
import com.kairos.ebillquezelco.service.user.UserAccountService;

/**
 * Handles requests for the Users Module.
 */
@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	private static final String USER_MGMT_URL = "user/userManagement";
	
	@Autowired
	private UserAccountService userAccountService;
	
	@Autowired
	private Validator userValidator;
	
	@RequestMapping(value="/users/main", method=RequestMethod.GET)
	public String showUserMainPage(Model model) {
		logger.info("Displaying all User Accounts in View");
		List<UserAccount> userAccounts = new ArrayList<UserAccount>();
		userAccounts = userAccountService.getAll();
		model.addAttribute("userAccounts", userAccounts);
		logger.info("User Accounts List Size: {}", userAccounts.size());
		return "user/userMain";
	}

	@RequestMapping(value="/users/add", method=RequestMethod.GET)
	public String showUserModificationPage(Model model) {
		logger.info("Displaying Add User Page");
		model.addAttribute("userAccount", new UserAccount());
		return USER_MGMT_URL;
	}
	
	@RequestMapping(value="/users/add", method=RequestMethod.POST)
	public String manageUserAccounts(@Valid @ModelAttribute("userAccount") UserAccount userAccount, 
									Errors error, Model model) {
		userValidator.validate(userAccount, error);
		
		if (error.hasErrors()) {
			model.addAttribute("userAccount", userAccount);
			return USER_MGMT_URL;
		}
		userAccountService.create(userAccount);
		model.addAttribute("addSuccess", true);
		return "redirect:/users/main";
	}
	
	
	
}
