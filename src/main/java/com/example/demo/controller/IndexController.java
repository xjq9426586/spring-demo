package com.example.demo.controller;

import com.example.demo.interceptor.CurrentUser;
import com.example.demo.interceptor.LoginUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

@RequestMapping("/")
public class IndexController {
	@RequestMapping(path = "/", method =RequestMethod.GET)
	public String index(@LoginUser CurrentUser user){
		return "index";
	}
}
