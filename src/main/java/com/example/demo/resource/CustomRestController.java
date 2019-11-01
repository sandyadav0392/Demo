package com.example.demo.resource;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.UserEntity;
import com.example.demo.pojo.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;


@RestController
@Api("This is RestController Class")
public class CustomRestController {
	@Autowired
	private UserRepository repo;
     @ApiOperation("User Information based on Id")
	 @GetMapping(value = "/getId", produces = {"application/json","application/xml"})
	public @ApiResponse(code = 200, message = "Return User Information")User findById(@RequestParam("id") Integer userId) {
		     System.out.println("***** CustomRestController.findById() *****");
		 UserEntity fatchById = repo.fatchById(userId);
		User user = new User();
		BeanUtils.copyProperties(fatchById, user);
		return user;
	}
}
