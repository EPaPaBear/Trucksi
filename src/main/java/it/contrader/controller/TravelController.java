package it.contrader.controller;
import java.util.List;

import it.contrader.dto.TravelDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.TravelService;

public class TravelController implements Controller {
	
	private static String sub_package = "travel.";
	private TravelService travelService;
	public TravelController() {
		this.travelService = new TravelService();
	}

	private int id;
	private int idusername;
	private int idtruck;
	private int idcity;
	private int idhistory;
	
	
	@Override
	public void doControl(Request request) {
		
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");


		
		switch (mode) {
		
		case "INSERT":
			idusername =  Integer.parseInt(request.get("idusername").toString());
			idtruck =  Integer.parseInt(request.get("idtruck").toString());
			idcity =  Integer.parseInt(request.get("idcity").toString());
			idhistory =  Integer.parseInt(request.get("idhistory").toString());
			TravelDTO tvDTO = new TravelDTO(idusername, idtruck,idcity,idhistory);
			travelService.insert(tvDTO);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "TravelInsert", request);
			break;
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			idusername = Integer.parseInt(request.get("idusername").toString());
			idtruck = Integer.parseInt(request.get("idtruck").toString());
			idcity = Integer.parseInt(request.get("idcity").toString());
			idhistory = Integer.parseInt(request.get("idhistory").toString());
			TravelDTO traveltoupdate = new TravelDTO(idusername,idtruck,idcity,idhistory);
			traveltoupdate.setId(id);
			travelService.update(traveltoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "TravelUpdate", request);
			break;
			
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			TravelDTO tvDTO1 = travelService.read(id);
			request.put("travel", tvDTO1);
			MainDispatcher.getInstance().callView(sub_package + "TravelRead", request);
			break;
		
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			travelService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "TravelDelete", request);
			break;
		case "TRAVELLIST":
			List<TravelDTO> travelDTO = travelService.getAll();
			request.put("travels", travelDTO);
			MainDispatcher.getInstance().callView("Travel", request);
			break;
		case "GETCHOICE":
			switch (choice.toUpperCase()) {
			case "R":
				MainDispatcher.getInstance().callView(sub_package + "TravelRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "TravelInsert", null);
				break;
				
			case "U":
				MainDispatcher.getInstance().callView(sub_package + "TravelUpdate", null);
				break;
				
			case "D":
				MainDispatcher.getInstance().callView(sub_package + "TravelDelete", null);
				break;
				
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;

			case "B":
				MainDispatcher.getInstance().callView("HomeAdmin", null);
				break;
			case "A":
				request.put("mode", "TRAVELLIST");
				MainDispatcher.getInstance().callAction("Travel", "doControl", request);
				break;
				
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
			
		default:
			MainDispatcher.getInstance().callView("Login", null);
		}
	}
	
}
