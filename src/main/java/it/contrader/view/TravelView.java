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
		System.out.println("\n-------------Gestione Travel---------------- \n");
		System.out.println("   ---------------------------------------");
		System.out.println("idusername " + "\t" + "idtruck \t idcity \t idhistory");
		
	}

	@Override
	public void showOptions() {
		System.out.println("Scegli l'operazione da effettuare ");
		@SuppressWarnings("unchecked")
		List<TravelDTO> htDTOList = (List<TravelDTO>) request.get("Travel");
		for(TravelDTO ht: htDTOList ) {
			System.out.println(ht);
		}
		System.out.println();
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Travel", "doControl", this.request);
	}
	
}
