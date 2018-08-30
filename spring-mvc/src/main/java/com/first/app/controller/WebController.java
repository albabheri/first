package com.first.app.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", "Helloo");
		return "index";
	}
}
