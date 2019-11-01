package com.example.demo.constant;

import org.springframework.stereotype.Component;
/**\
 * this class is use to set values dynamically to other classes.
 * @author Lenovo
 *
 */
@Component
public interface AppCostant {
	 String REDIRECT_METHOD_VIEWUSERS= "redirect:viewUsers?page=1";
	String REDIRECT_METHOD_FORMREGISTER="redirect:/userAccCreationSuccess";
	/**
	 *  this property use to return view name to userForm page
	 */
	String USER_FROM = "userForm";
	/**
	 * this property use to return view name to home page
	 */
	String HOME_PAGE = "home";
	/**
	 * this property use to send data from controller to  view page by using  addAttributes() methods of Model class
	 */
	String FORM_MSG = "msg";
	/**
	 * this property use to send data from controller to  view page by using  addAttributes() methods of Model class
	 */
	String LOGIN_MSG = "msg1";
	/**
	 * this property use to view success message to form page
	 */
	String FORM_SUCCESS_MSG = "succ";
	String FORM_FAILURE_MSG = "fail";
	/**
	 * this propety use to view login success message on form page 
	 */
	String LOGIN_SUCCESS_MSG = "lsucc";
	/**
	 * this propery use to view login failure message on form page
	 */
	String LOGIN_FAIL_MSG = "User and password is invallied !";
	/**
	 * this property use to send modelAttrubute name to form page.
	 */
	String MODEL_ATTRIBUTE_NAME = "user";
	/**
	 * this propery use to check security 
	 */
	String SECURE_MAIL = "sandy@gmail.com";
	String USER_UPDATE="updateForm";
	String USER_VIEW="viewUser";
	String USERS="users";
}
