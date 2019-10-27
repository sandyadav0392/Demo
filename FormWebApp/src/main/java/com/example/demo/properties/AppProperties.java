package com.example.demo.properties;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;


@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "formapp")
@Data
public class AppProperties {
	  private Map<String,String> messages=new HashMap<>();
}

