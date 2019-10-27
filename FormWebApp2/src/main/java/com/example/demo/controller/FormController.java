package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.demo.dao.UserRepository;
import com.example.demo.entity.UserEntity;
import com.example.demo.pojo.User;

@Controller
public class FormController {
	@Autowired
	private UserRepository repo;

	public FormController() {
		System.out.println("***** FormController.constructor ***** ");
	}

	@RequestMapping(value = "/registerForm", method = RequestMethod.GET)
	public String formLoad(Model model) {

		User user = new User();
		model.addAttribute("user", user);
		selectCountries(model);
		return "userForm";
	}

	@RequestMapping(value = "/viewUsers", method = RequestMethod.GET)
	public String selectAllUsers(Model model) {
		System.out.println("**** FormController.selectAllUsers() ****");
		Iterable<UserEntity> userEntity = repo.findAll();
		List<User> userList = new ArrayList<>();

		for (UserEntity entity : userEntity) {
			User user = new User();
			BeanUtils.copyProperties(entity, user);
			userList.add(user);
		}

		model.addAttribute("users", userList);
		return "viewUser";
	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
	public String deleteUser(@RequestParam("userId") Integer userid) {
		System.out.println("**** FormController.deleteUser() ****");
		repo.deleteById(userid);
		return "redirect:viewUsers";
	}

	@RequestMapping(value = "/registerForm", method = RequestMethod.POST)
	public String formRegister(@ModelAttribute("user") User user, RedirectAttributes attribute /* Model model */)
			throws Exception {
		System.out.println("****** FormController.formRegister() *****");
		// add validations
		// Set<ConstraintViolation<User>> violations = validator.validate(user);
		if (user.getCountries().equals("- select -")) {
			throw new Exception();
		}
		System.out.println(user);
		UserEntity entity = new UserEntity();
		// convert user to entity
		BeanUtils.copyProperties(user, entity);
		UserEntity save = repo.save(entity);
		if (save.getUserid() != null) {
			// model.addAttribute(AppCostant.FORM_MSG,
			// prop.getMessages().get(AppCostant.FORM_SUCCESS_MSG));
			attribute.addFlashAttribute("msg", "successfull");
		} else {
			// model.addAttribute(AppCostant.FORM_MSG,
			// prop.getMessages().get(AppCostant.FORM_FAILURE_MSG));
			attribute.addFlashAttribute("msg", "filure");

		}
		selectCountries(attribute);
		return "redirect:/userAccCreationSuccess";
	}

	@RequestMapping(value = "/userAccCreationSuccess", method = RequestMethod.GET)
	public String userAccCreationSuccess(Model model) {
		System.out.println("******* FormController.userAccCreationSuccess() ******");
		User user = new User();
		model.addAttribute("user", user);
		selectCountries(model);
		return "userForm";
	}

	@RequestMapping(value = "/updateRequest", method = RequestMethod.GET)
	public String requestUpdate(Model model, @RequestParam("userId") Integer userid) {
		Optional<UserEntity> findById = repo.findById(userid);

		UserEntity userEntity = findById.get();
		User user = new User();
		BeanUtils.copyProperties(userEntity, user);
		model.addAttribute("user", user);
		selectCountries(model);
		return "updateForm";
	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public String updateUserDetails(@ModelAttribute("user") User user, @RequestParam("userId") Integer userid,
			Model model) {
		UserEntity entity = new UserEntity();
		BeanUtils.copyProperties(user, entity);
		entity.setUserid(userid);
		repo.save(entity);
		model.addAttribute("msg", "Update Successfully !");
		selectCountries(model);
		return "updateForm";
	}

	public void selectCountries(Model model) {
		List<String> list = new ArrayList<>();
		list.add("- select -");
		list.add("India");
		list.add("USA");
		list.add("Australia");
		list.add("Shri Lanka");
		model.addAttribute("cnt", list);
	}
}
