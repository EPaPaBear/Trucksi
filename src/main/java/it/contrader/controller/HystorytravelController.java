package it.contrader.controller;

import java.sql.Time;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.converter.CityConverter;
import it.contrader.dto.CityDTO;
import it.contrader.dto.HystorytravelDTO;
import it.contrader.service.CityService;
import it.contrader.service.HystorytravelService;



@Controller 
@RequestMapping("/hystorytravel")
public class HystorytravelController {
		
	@Autowired
	private HystorytravelService service;
	@Autowired
	private CityService serviceC;
	
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
	
	//@RequestParam("nometeam") String nometeam,
	//@RequestParam("descrizione") String descrizione, 
	//@RequestParam("numeroutenti") String numeroutenti
	@PostMapping("/insert")
	public String insert(HttpServletRequest request, 
			@RequestParam("citydeparture") long cd,
			@RequestParam("cityarrive") long ca,
			@RequestParam("timedeparture") String tm
			) {
		
		HystorytravelDTO dto = new HystorytravelDTO();
		
	//	dto.setTimedeparture(tm);
		CityDTO dtoCd = new CityDTO();
		
		dtoCd.setId(cd);
		CityConverter cc = new CityConverter();
		cc.toEntity(dtoCd);
		dto.setCitydeparture(cc.toEntity(dtoCd));
		
		CityDTO dtoCa = new CityDTO();
		
		dtoCa.setId(ca);
		CityConverter cca = new CityConverter();
		cca.toEntity(dtoCa);
		dto.setCityarrive(cca.toEntity(dtoCa));
		
	//	dto.setNometeam(nometeam);
	//	dto.setDescrizione(descrizione);
	//	dto.setNumeroutenti(numeroutenti);
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
		/*get all hystorytravel */
		request.getSession().setAttribute("listH", service.getAll());
		/*get all city */
		request.getSession().setAttribute("listC", serviceC.getAll());
	}
}


