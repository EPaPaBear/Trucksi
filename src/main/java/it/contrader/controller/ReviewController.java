package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/review")
public class ReviewController {
	private String pathFolder = "review/";
	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		//setAll(request);
		return pathFolder+"reviews";
	}
}
