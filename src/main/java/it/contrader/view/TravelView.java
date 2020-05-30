package it.contrader.view;
import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.TravelDTO;
<<<<<<< HEAD
=======
import it.contrader.dto.UserDTO;
>>>>>>> f1c107cdfc46d1dc58359c7bbbae1079ae034aec
import it.contrader.main.MainDispatcher;

public class TravelView extends AbstractView{
	private Request request;
	private String choice;
	
	public TravelView(){
		
	}

	@Override
	public void showResults(Request request) {
		if (request != null) {
<<<<<<< HEAD
			System.out.println("\n-------------------User Management ----------------\n");
			System.out.println("UsernameID \t Truck \t City Id \t History Id");
			System.out.println("----------------------------------------------------\n");
=======
			System.out.println("\n------------Travel Management---------------- \n");
			
			System.out.println("idusername " + "\t" + "idtruck \t idcity \t idhistory");
			System.out.println("   ---------------------------------------");
>>>>>>> f1c107cdfc46d1dc58359c7bbbae1079ae034aec
			
			@SuppressWarnings("unchecked")
			List<TravelDTO> travels = (List<TravelDTO>) request.get("travels");
			for (TravelDTO u: travels)
				System.out.println(u);
			System.out.println();
		}
	}
<<<<<<< HEAD
	@Override
	public void showOptions() {
		System.out.println("What operation would you like to perform?:");
		System.out.println("[R]ead [I]nsert [U]pdate [D]elete list[A]ll [E]xit [B]ack");

		this.choice = getInput();

		
	}
=======

	@Override
	public void showOptions() {
		System.out.println("          What operation would you like to perform?:");
		System.out.println("[R]ead [I]nsert [U]pdate [D]elete list[A]ll [E]xit");

		this.choice = getInput();
	}

>>>>>>> f1c107cdfc46d1dc58359c7bbbae1079ae034aec
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Travel", "doControl", this.request);
	}
	
}
