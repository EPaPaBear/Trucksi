package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.CityDTO;
import it.contrader.service.CityService;

@Controller
@RequestMapping("/city")
public class CityController {
	private String pathFolder = "city/";

	@Autowired
	private CityService service;

	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return pathFolder+"cities";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "cities";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updatecity";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, 
			@RequestParam("id") Long id,
			@RequestParam("cityname") String cityname) {

		CityDTO dto = new CityDTO();
		dto.setId(id);
		dto.setCityname(cityname);
		service.update(dto);
		setAll(request);
		return "trucks";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request,
			@RequestParam("cityname") String cityname
			) {
		CityDTO dto = new CityDTO();
		dto.setCityname(cityname);
		service.insert(dto);
		setAll(request);
		return "trucks";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readcity";
	}

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("listT", service.getAll());
	}
}
