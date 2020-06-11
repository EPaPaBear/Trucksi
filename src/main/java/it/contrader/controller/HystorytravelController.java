package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.HystorytravelDTO;
import it.contrader.service.HystorytravelService;



@Controller 
@RequestMapping("/hystorytravel")
public class HystorytravelController {
		
	@Autowired
	private HystorytravelService service;
	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "hystorytravel/hystorytravels";
	}
	
	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("idt") Long idt ) {
		service.delete(idt);
		setAll(request);
		return "hystorytravel/hystorytravels";
	}
	/*
	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("idt") Long idt) {
		request.getSession().setAttribute("dto", service.read(idt));
		return "updateteam";
	}
	*/
	
	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("idt") Long idt, @RequestParam("nometeam") String nometeam,
		@RequestParam("descrizione") String descrizione , @RequestParam("numeroutenti") String numeroutenti	) {
		
		
		HystorytravelDTO dto = new HystorytravelDTO();
		dto.setIdt(idt);
		dto.setNometeam(nometeam);
		dto.setDescrizione(descrizione);
		dto.setNumeroutenti(numeroutenti);
		service.update(dto);
		setAll(request);
		return "hystorytravel/hystorytravels";
	}
	
	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("nometeam") String nometeam,
		@RequestParam("descrizione") String descrizione, @RequestParam("numeroutenti") String numeroutenti) {
		
		HystorytravelDTO dto = new HystorytravelDTO();
		
		dto.setNometeam(nometeam);
		dto.setDescrizione(descrizione);
		dto.setNumeroutenti(numeroutenti);
		service.insert(dto);
		setAll(request);
		return "hystorytravel/hystorytravels";
		
	}
	
	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("idt") Long idt) {
		request.getSession().setAttribute("dto", service.read(idt));
		return "hystorytravel/readhystorytravels";
	}
	
	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("listH", service.getAll());
	}
}


