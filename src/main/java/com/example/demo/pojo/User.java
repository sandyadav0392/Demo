package com.example.demo.pojo;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;
@Data
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class User {
	private Integer userid;
     @NotNull(message = "username con't be null")
	 private String username;
     @Min(value = 8,message = "minimum 8 char use")
	 private String password;
     @Email(message = "Email shoud be valid")
	 private String email;
     @Max(value = 10,message = "maximum 10 digit use only")
	 private Long phone;
	// private Date dob;
	 private String countries;
	 private boolean active=true;
}

