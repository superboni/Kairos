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
	private static final String USER_MGMT_VIEW = "user/usermanagement";
	private static final String USER_MAIN_VIEW = "user/usermain";
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
		return USER_MAIN_VIEW;
	}

	@RequestMapping(value="/users/add", method=RequestMethod.GET)
	public String addUserAccount(Model model) {
		logger.info("Displaying Add User Page");
		model.addAttribute(USER_ATTR, new UserAccount());
		model.addAttribute("mode", "add");
		populateSelectFields(model, new UserAccount());
		return USER_MGMT_VIEW;
	}
	
	@RequestMapping(value="/users/edit", method=RequestMethod.GET)
	public String editUserAccount(Model model, 
							@ModelAttribute("id") Long id) {
		logger.info("Displaying Edit User Page");
		UserAccount existingUser = userAccountService.getById(id);
		model.addAttribute(USER_ATTR, existingUser);
		model.addAttribute("mode", "edit");
		populateSelectFields(model, existingUser);
		return USER_MGMT_VIEW;
	}
	
	@RequestMapping(value="/users/delete", method=RequestMethod.GET)
	public String deleteUserAccount(Model model, 
							@ModelAttribute("id") Long id) {
		userAccountService.delete(id);
		model.addAttribute("deleteSuccess", true);
		return "redirect:/users/main";
	}
	
	@RequestMapping(value="/users/add", method=RequestMethod.POST)
	public String addUserAccount(@Valid @ModelAttribute(USER_ATTR) UserAccount userAccount, 
									Errors error, Model model) {
		if (hasValidationErros(error, model, userAccount, "add")) {
			return USER_MGMT_VIEW;
		}
		userAccountService.create(userAccount);
		model.addAttribute("addSuccess", true);
		return "redirect:/users/main";
	}
	
	@RequestMapping(value="/users/edit", method=RequestMethod.POST)
	public String editUserAccount(@Valid @ModelAttribute(USER_ATTR) UserAccount userAccount, 
									Errors error, Model model) {
		if (hasValidationErros(error, model, userAccount, "edit")) {
			return USER_MGMT_VIEW;
		}
		userAccountService.update(userAccount);
		model.addAttribute("editSuccess", true);
		return "redirect:/users/main";
	}
	
	private Boolean hasValidationErros(Errors error, Model model, UserAccount userAccount, String mode) {
		userValidator.validate(userAccount, error);
		if (error.hasErrors()) {
			model.addAttribute(USER_ATTR, userAccount);
			model.addAttribute("mode", mode);
			populateSelectFields(model, userAccount);
			return true;
		}
		return false;
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
