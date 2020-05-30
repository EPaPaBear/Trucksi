package it.contrader.view;
import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.TravelDTO;
import it.contrader.main.MainDispatcher;

public class TravelView extends AbstractView{
	private Request request;
	private String choice;
	
	public TravelView(){
		
	}

	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n-------------------User Management ----------------\n");
			System.out.println("UsernameID \t Truck \t City Id \t History Id");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<TravelDTO> travels = (List<TravelDTO>) request.get("travels");
			for (TravelDTO u: travels)
				System.out.println(u);
			System.out.println();
		}
	}
	@Override
	public void showOptions() {
		System.out.println("What operation would you like to perform?:");
		System.out.println("[R]ead [I]nsert [U]pdate [D]elete list[A]ll [E]xit [B]ack");

		this.choice = getInput();

		
	}
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Travel", "doControl", this.request);
	}
	
}
