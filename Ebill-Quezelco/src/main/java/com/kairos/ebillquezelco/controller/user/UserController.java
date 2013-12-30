package com.kairos.ebillquezelco.controller.user;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

	@Autowired
	private UserAccountService userAccountService;
	
	@RequestMapping(value="/useraccounts", method=RequestMethod.GET)
	public String viewUserAccounts(Model model) {
		logger.info("Displaying all User Accounts in View");
		List<UserAccount> userAccounts = new ArrayList<UserAccount>();
		userAccounts = userAccountService.getAll();
		model.addAttribute("userAccounts", userAccounts);
		logger.info("User Accounts List Size: {}", userAccounts.size());
		return "user/userAccount";
	}
	
}
