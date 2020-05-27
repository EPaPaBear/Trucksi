package it.contrader.controller;

import java.util.Date;

import it.contrader.dto.HystorytravelDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.HystorytravelService;

public class HystorytravelController implements Controller {
	private static String sub_package = "hystorytravel.";
	private HystorytravelService hystorytravelService;
	public HystorytravelController() {
		this.hystorytravelService = new HystorytravelService();
	}
	@Override
	public void doControl(Request request) {
		
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");
		int id;
		int idtravel;
		int idcity;
		Date hour;
		int travelindex;
		
		switch (mode) {
			
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			HystorytravelDTO htDTO = hystorytravelService.read(id);
			request.put("hystorytravel", htDTO);
			MainDispatcher.getInstance().callView(sub_package + "HystorytravelRead", request);
			break;
		
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			//Qui chiama il service
			hystorytravelService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "UserDelete", request);
			break;
			
		}
	}
	
}
