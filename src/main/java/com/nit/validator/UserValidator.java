package com.nit.validator;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

import com.nit.model.User;
import com.nit.service.IUserService;

@Component
public class UserValidator {
	@Autowired
	private IUserService userService;

	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		// Down cast form object
		User user = (User) target;
		// Text input validation
		if (!Pattern.matches("[A-Z a-z]{3,10}", user.getUserName())) {
			errors.rejectValue("userName", null, "Please inter 3-10 chars");
		}
		// passord validation
		if (!Pattern.matches("[A-Z a-z]{4,15}", user.getUserPassword())) {
			errors.rejectValue("userPassword", null, "please enter 4-15  chars");

		}
		// radio buttion
		if (StringUtils.isEmpty(user.getUserGen())) {
			errors.rejectValue("userGen", null, "Please choose one gender");
		}
		// DropDown validation
		if (StringUtils.isEmpty(user.getUserCity())) {
			errors.rejectValue("userCity", null, "please choose one city");

		}
		// checking list is empty
		if (user.getUserRoles().isEmpty() || user.getUserRoles() == null) {
			errors.rejectValue("userRoles", null, "please select atleast one ");
		}

	}
	

}
