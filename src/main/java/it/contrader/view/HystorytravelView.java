package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.HystorytravelDTO;
import it.contrader.main.MainDispatcher;

public class HystorytravelView extends AbstractView {
	
	private Request request;
	private String choice;
	
	public HystorytravelView() {
		
	}

	@Override
	public void showResults(Request request) {
		if(request != null) {
			System.out.println("\n------------------- Management HystoryTravel ----------------\n");
			System.out.println("ID \t IDtravel \t IDcity \t hour \t TravelIndex");
			System.out.println("---------------------------------------------------------------\n");
		
			@SuppressWarnings("unchecked")
			List<HystorytravelDTO> htDTOList = (List<HystorytravelDTO>) request.get("hystorytravel");
			for ( HystorytravelDTO ht: htDTOList)
				System.out.println(ht);
			System.out.println();
		}
	}

	@Override
	public void showOptions() {
		System.out.println("          \r\n" + "Choose the operation to perform:");
		System.out.println("[R]ead [B]ack [E]xit");

		this.choice = getInput();
		
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Hystorytravel", "doControl", this.request);
		
	}

}
