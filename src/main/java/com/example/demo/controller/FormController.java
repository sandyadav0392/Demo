package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Validator;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.constant.AppCostant;
import com.example.demo.dao.UserRepository;
import com.example.demo.entity.UserEntity;
import com.example.demo.pojo.User;
import com.example.demo.properties.AppProperties;

/**
 * This class use to create as a spring controller
 * 
 * @author Lenovo
 *
 */
@Controller
public class FormController {
	/**
	 * This variable use to inject AppProperties class to FormController class
	 * 
	 */
	@Autowired
	private AppProperties prop;
	/**
	 * this property is use to access repository class
	 */
	@Autowired
	private UserRepository repo;

	private Validator validator;

	public FormController() {
		System.out.println("***** FormController.constructor ***** ");
	}

	/**
	 * This method use to load a Form data
	 * 
	 * @param model
	 * @return String
	 */

	@RequestMapping(value = "/registerForm", method = RequestMethod.GET)
	public String formLoad(Map<String,Object> map) {

		User user = new User();
		map.put(AppCostant.MODEL_ATTRIBUTE_NAME, user);
		//selectCountries(map);
		return AppCostant.USER_FROM;
	}

	/**
	 * Find All User
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/viewUsers", method = RequestMethod.GET)
	public String selectAllUsers(Model model, @RequestParam("page") Integer currentPage) {
		System.out.println("**** FormController.selectAllUsers() ****");
		Integer pageSize=3;
		    PageRequest of = PageRequest.of(currentPage-1, pageSize);
		     Page<UserEntity> page = repo.findAllAfterSoftDeletion(of);
             List<UserEntity> content = page.getContent();
		   List<User> userList = new ArrayList<>();
		     int totalPages = page.getTotalPages();
		      System.out.println(totalPages);
		    model.addAttribute("tp", totalPages);
		    model.addAttribute("cp", currentPage);
		for (UserEntity entity : content) {
			User user = new User();
			BeanUtils.copyProperties(entity, user);
			userList.add(user);
		}

		model.addAttribute(AppCostant.USERS, userList);
		return AppCostant.USER_VIEW;
	}

	/**
	 * Delete Operations
	 * 
	 * @param userIdy
	 * @return
	 */
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
	public String deleteUser(@RequestParam("userId") Integer userid) {
		System.out.println("**** FormController.deleteUser() ****");
		repo.softDeleteById(userid);
		return AppCostant.REDIRECT_METHOD_VIEWUSERS;
	}

	/**
	 * This method is use to Fatch data from Form (UI) to Controller
	 * 
	 * @param user
	 * @param model
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value = "/registerForm", method = RequestMethod.POST)
	public String formRegister(Map<String,Object> map,@ModelAttribute("user") User user, RedirectAttributes attribute /* Model model */)
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
			attribute.addFlashAttribute(AppCostant.FORM_MSG, prop.getMessages().get(AppCostant.FORM_SUCCESS_MSG));
		} else {
			// model.addAttribute(AppCostant.FORM_MSG,
			// prop.getMessages().get(AppCostant.FORM_FAILURE_MSG));
			attribute.addFlashAttribute(AppCostant.FORM_MSG, prop.getMessages().get(AppCostant.FORM_FAILURE_MSG));

		}
		selectCountries(map);
		return AppCostant.REDIRECT_METHOD_FORMREGISTER;
	}

	/**
	 * This method is use to go to home page throw valid data
	 * 
	 * @param user
	 * @param model
	 * @return String
	 */

	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String formLogin(@ModelAttribute("user") User user, Map<String,Object> map) {

		System.out.println(user.getEmail() + " " + user.getPassword());
		// logic to connect DB
		int checkValidation = repo.checkValidation(user.getEmail(), user.getPassword());

		if (checkValidation == 1) {
			map.put(AppCostant.FORM_MSG, prop.getMessages().get(AppCostant.LOGIN_SUCCESS_MSG));
			map.put("name",user.getEmail());
			return AppCostant.HOME_PAGE;
		} else {
			map.put(AppCostant.LOGIN_MSG, AppCostant.LOGIN_FAIL_MSG);
			selectCountries(map);
			return AppCostant.USER_FROM;
		}
	}

	public String getName() {
		return "";
	}

	/**
	 * redirect the req to another controller get methods this method used to
	 * display success msg post registration.
	 * 
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "/userAccCreationSuccess", method = RequestMethod.GET)
	public String userAccCreationSuccess(Map<String,Object> map) {
		System.out.println("******* FormController.userAccCreationSuccess() ******");
		User user = new User();
		map.put(AppCostant.MODEL_ATTRIBUTE_NAME, user);
		selectCountries(map);
		return AppCostant.USER_FROM;
	}

	@RequestMapping(value = "/updateRequest", method = RequestMethod.GET)
	public String requestUpdate(Map<String,Object> map, @RequestParam("userId") Integer userid) {
		Optional<UserEntity> findById = repo.findById(userid);

		UserEntity userEntity = findById.get();
		User user = new User();
		BeanUtils.copyProperties(userEntity, user);
		map.put(AppCostant.MODEL_ATTRIBUTE_NAME, user);
		selectCountries(map);
		return AppCostant.USER_UPDATE;
	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public String updateUserDetails(@ModelAttribute("user") User user, @RequestParam("userId") Integer userid,
			Map<String,Object> map) {
		UserEntity entity = new UserEntity();
		BeanUtils.copyProperties(user, entity);
		entity.setUserid(userid);
		repo.save(entity);
		map.put(AppCostant.FORM_MSG, "Update Successfully !");
		selectCountries(map);
		return AppCostant.USER_UPDATE;
	}

	/**
	 * this method is used to take countries list
	 * 
	 * @param model
	 */
	public void selectCountries(Map<String,Object> map) {
		List<String> list = new ArrayList<>();
		list.add("- select -");
		list.add("India");
		list.add("USA");
		list.add("Australia");
		list.add("Shri Lanka");
		map.put("cnt", list);
//		model.addAttribute("cnt", list);
	}
}
