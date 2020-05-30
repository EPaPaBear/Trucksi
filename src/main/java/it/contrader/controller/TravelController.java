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
	
	@Override
	public void doControl(Request request) {
		
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");
		int id;

		
		switch (mode) {
			
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			TravelDTO tvDTO = travelService.read(id);
			request.put("travel", tvDTO);
			MainDispatcher.getInstance().callView(sub_package + "travelREAD", request);
			break;
		
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			travelService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "UserDelete", request);
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
				
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
			
		default:
			MainDispatcher.getInstance().callView("Login", null);
		}
	}
	
}
