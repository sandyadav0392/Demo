package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name = "USER_TABLE_NEW")
public class UserEntity {
	 @Id
	 @GeneratedValue
	 @Column(name = "USER_ID")
	 private Integer userid;
	 @Column(name = "USER_NAME")
	 private String username;
	 @Column(name = "USER_PASSWORD")
	 private String password;
	 @Column(name = "USER_EMAIL")
	 private String email;
	 @Column(name = "USER_PHNO")
	 private Long phone;
	 @Column(name = "USER_COUNTRIES")
	 private String countries;
	 @Column(name="is_active")
		private Boolean active;
	 
}
