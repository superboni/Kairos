package com.kairos.ebillquezelco.controller.user;

import java.beans.PropertyEditorSupport;
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
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kairos.ebillquezelco.domain.designation.Designation;
import com.kairos.ebillquezelco.domain.role.Roles;
import com.kairos.ebillquezelco.domain.user.UserAccount;
import com.kairos.ebillquezelco.service.designation.DesignationService;
import com.kairos.ebillquezelco.service.role.RoleService;
import com.kairos.ebillquezelco.service.user.UserAccountService;

/**
 * Handles requests for the Users Module.
 */
@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	private static final String USER_MGMT_VIEW_URL = "user/usermanagement";
	private static final String USER_MGMT_REQUEST_URL = "/users/add";
	private static final String USER_ATTR = "userAccount";

	@Autowired
	private UserAccountService userAccountService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private DesignationService designationService;
	
	@Autowired
	private Validator userValidator;
	
	@RequestMapping(value="/users/main", method=RequestMethod.GET)
	public String showUserMainPage(Model model) {
		logger.info("Displaying all User Accounts in View");
		model.addAttribute("userAccounts", userAccountService.getAll());
		return "user/usermain";
	}

	@RequestMapping(value=USER_MGMT_REQUEST_URL, method=RequestMethod.GET)
	public String showUserModificationPage(Model model) {
		logger.info("Displaying Add User Page");
		model.addAttribute(USER_ATTR, new UserAccount());
		populateSelectFields(model, new UserAccount());
		return USER_MGMT_VIEW_URL;
	}
	
	@RequestMapping(value=USER_MGMT_REQUEST_URL, method=RequestMethod.POST)
	public String manageUserAccounts(@Valid @ModelAttribute(USER_ATTR) UserAccount userAccount, 
									Errors error, Model model) {
		userValidator.validate(userAccount, error);
		if (error.hasErrors()) {
			model.addAttribute(USER_ATTR, userAccount);
			populateSelectFields(model, userAccount);
			return USER_MGMT_VIEW_URL;
		}
		userAccountService.create(userAccount);
		model.addAttribute("addSuccess", true);
		return "redirect:/users/main";
	}
	
	private void populateSelectFields(Model model, UserAccount userAccount) {
		model.addAttribute("roleList", roleService.getAll());
		model.addAttribute("designationList", designationService.getAll());

		List<Long> selectedDesignationList = new ArrayList<Long>();
		if (userAccount.getDesignations() != null) {
			for (Designation des : userAccount.getDesignations()) {
				selectedDesignationList.add(des.getId());
			}
		}
		model.addAttribute("selectedDesignationList", selectedDesignationList);
		
		Long roleId = new Long(0);
		if (userAccount.getRole() != null) {
			roleId = userAccount.getRole().getId();
		}
		model.addAttribute("selectedRole", roleId);
	}
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Roles.class, "role", new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) {
				if (!(text==null||"".equals(text))) {
					Roles role = roleService.getById(Long.parseLong(text));
					setValue(role);
				}
			}
		});
		
		binder.registerCustomEditor(Designation.class, "designations", new PropertyEditorSupport()	{
			@Override
			public void setAsText(String text) {
				Designation designations = designationService.getById(Long.parseLong(text));
				setValue(designations);
			}
		});
	}
	
}
