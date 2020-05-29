package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.DriverDTO;
import it.contrader.dto.TruckDTO;
import it.contrader.main.MainDispatcher;

public class DriverView extends AbstractView {

	private Request request;
	private String choice;

	public DriverView() {
	}
	
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Gestione driver ----------------\n");
			System.out.println("ID\tDriver name\tDriver mobile\tTruck ID");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<DriverDTO> drivers = (List<DriverDTO>) request.get("drivers");
			for (DriverDTO u: drivers)
				System.out.println(u);
			System.out.println();
		}
	}
	
	@Override
	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica mostra[T]utti [C]ancella [B]ack [E]sci");

		this.choice = getInput();

		
	}
	
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Driver", "doControl", this.request);
	}
}
