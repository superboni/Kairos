package com.kairos.ebillquezelco.service.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.kairos.ebillquezelco.domain.user.UserAccount;
import com.kairos.ebillquezelco.service.user.UserAccountService;

@Service("userValidator")
public class UserAccountValidator implements Validator {

	@Autowired
	private UserAccountService userAccountService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return UserAccount.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserAccount user = (UserAccount) target;
		if (user.getId()==null && (!(user.getUsername()==null || "".equals(user.getUsername())))) {
			if (userAccountService.getByUsername(user.getUsername())!=null) {
				errors.rejectValue("username", "user.maintain.duplicate");
			}
		}
		if (user.getDesignations()==null) {
			errors.rejectValue("designations", "NotNull");
		}
	}
	
}
