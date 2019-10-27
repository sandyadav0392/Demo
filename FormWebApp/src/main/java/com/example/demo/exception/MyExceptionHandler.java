package com.example.demo.exception;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ControllerAdvice
public class MyExceptionHandler {

	
	@ExceptionHandler(Exception.class)
	public @ResponseBody String unknownException(Model model) {
	   return "Id Not found !";
	}
	
	@ExceptionHandler(IdNotFoundException.class)
	public String idNotFoundExceptioin(Model model) {
		model.addAttribute("errMsg", "id Not found !");
	   return "error";
	}
	
}
