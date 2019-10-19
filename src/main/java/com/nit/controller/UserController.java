package com.nit.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nit.model.User;
import com.nit.service.IUserService;
import com.nit.util.AppConstants;
import com.nit.validator.UserValidator;

@Controller
public class UserController {

	@Autowired
	private IUserService userService;
	@Autowired
	private UserValidator userValidator;

	// To Display RegistrationForm
	@RequestMapping("/show")
	public String showForm(ModelMap map) {
		map.addAttribute("user", new User());// form backing object
		return "RegistrationForm";
	}

	// This method will be called on submit
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveUserData(@ModelAttribute User user, ModelMap map, Errors errors) {
		userValidator.validate(user, errors);
		if (!errors.hasErrors()) {

			User u = userService.saveUser(user);
			if (u.getUserId() != null) {
				map.addAttribute(AppConstants.SUCCESS, AppConstants.REG_SUCCESS);

			} else {
				map.addAttribute(AppConstants.ERROR, AppConstants.REG_ERROR);
			}

			map.addAttribute("user", new User());
		} else {
			map.addAttribute(AppConstants.ERROR, AppConstants.REG_ERROR);
		}
		return "RegistrationForm";

	}

	// View all records
	@RequestMapping("/all")
	public String getAllUserData(ModelMap map) {
		List<User> userData = userService.getAllUsers();
		map.addAttribute("list", userData);
		// System.out.println(userService.findByCitySorted("Pune"));
		System.out.println(userService.findByUserGender("Male"));

		return "UserDataPage";
	}

	// Deleted record based on userId
	@RequestMapping("/delete")
	public String deleteById(@RequestParam("userId") Integer uid, ModelMap map) {
		try {
			userService.deleteUserById(uid);
			map.addAttribute("msg", "One User Details are deleted with Id :" + uid);

		} catch (Exception e) {
			map.addAttribute("msg", "User Details are not found with Id:" + uid);

		}
		// read data
		List<User> userData = userService.getAllUsers();
		// add data to ui
		map.addAttribute("list", userData);
		return "UserDataPage";
	}

	// To show edit page
	@RequestMapping("/edit")
	public String editPage(@RequestParam("userId") Integer uid, ModelMap map) {
		Optional<User> u = userService.getUserById(uid);
		map.addAttribute("user", u);
		return "UserEditPage";
	}

	// To update user data ,on click submit button
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute User user, ModelMap map) {
		userService.updateUser(user);
		List<User> list = userService.getAllUsers();
		map.addAttribute("list", list);
		return "UserDataPage";

	}

	// View all records2

	/*@RequestMapping("/all")
	public String getAllUserDataPage(ModelMap map, @RequestParam("pn") Integer currPage ) {
		Integer pageSize = 3;
		Integer currPageNo = 1;

		PageRequest page = PageRequest.of(currPageNo, pageSize);

		Page<User> pageData = userService.findPageOfRecords(page);

		List<User> lists = pageData.getContent();
		int totalPage = pageData.getTotalPages();

		map.addAttribute("list", lists);
		map.addAttribute("tp", totalPage);
		map.addAttribute("cp", currPageNo);
		//map.addAttribute("pn", currPage);
	
	lists.forEach(System.out::println);

		return "UserDataPage";
	}*/

	@RequestMapping("allCity")
	public @ResponseBody List<String> getAllUserCity(@RequestParam("city") String userCity) {

		return userService.findAllCity();
	}

}
