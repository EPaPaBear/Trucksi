package it.contrader.controller;

import java.util.Date;
import java.util.List;

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
			if(htDTO.getId()==0) {
				System.out.println("ID not found");
				request.put("mode", "HYSTORYTRAVELLIST"); 
	        	MainDispatcher.getInstance().callAction("Hystorytravel", "doControl", request);
			}else {
			request.put("hystorytravel", htDTO);
			MainDispatcher.getInstance().callView(sub_package + "HystorytravelRead", request);
			}
			break;
		case "INSERT":
			 
			 idtravel = Integer.parseInt(request.get("idtravel").toString());
		     idcity =  Integer.parseInt(request.get("idcity").toString());
			 hour =  (Date)request.get(("hour").toString());
			 travelindex = Integer.parseInt(request.get("travelindex").toString());
			 HystorytravelDTO htDTOi = new HystorytravelDTO(idtravel, idcity,hour,travelindex);
			 hystorytravelService.insert(htDTOi);
			 request = new Request();
			 request.put("mode", "mode");
			 MainDispatcher.getInstance().callView(sub_package + "HystorytravelInsert", request);
			 break;
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			hystorytravelService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "HystorytravelDelete", request);
			break;
		case "HYSTORYTRAVELLIST":
			List<HystorytravelDTO> hystorytravelsDTO = hystorytravelService.getAll();
			request.put("hystorytravel", hystorytravelsDTO);
			MainDispatcher.getInstance().callView("Hystorytravel", request);
			break;
		case "GETCHOICE":
			switch (choice.toUpperCase()) {
			case "R":
				MainDispatcher.getInstance().callView(sub_package + "HystorytravelRead", null);
				break;
				
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;
			case "D":
				MainDispatcher.getInstance().callView(sub_package +"HystorytravelDelete", null);
				break;
	case "A":
				
				request.put("mode", "HYSTORYTRAVELLIST");
				MainDispatcher.getInstance().callAction("Hystorytravel", "doControl", request);
				break;
			case "B":
				MainDispatcher.getInstance().callView("HomeAdmin", null);
				break;
				
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
			
		default:
			MainDispatcher.getInstance().callView("Login", null);
		}
	}
	
}
