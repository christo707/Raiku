package com.raiku.curiosity.controllers;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.raiku.curiosity.entities.Test;

@RestController
@RequestMapping("/api/v1")
public class TestController {

	@RequestMapping(value = "/test",  method = RequestMethod.GET, produces = "application/json")
	public Test test(){
		Test t = new Test(1, "API IS UP", new Date());
		return t;
	}
	
}
