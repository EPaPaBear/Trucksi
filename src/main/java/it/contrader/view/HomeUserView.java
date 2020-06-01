package it.contrader.view;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class HomeUserView extends AbstractView{

	String choice;
	private Request request;
	private String userType = MainDispatcher.getInstance().getUserType();

	@Override
	public void showResults(Request request) {
		System.out.println("\n Welcome in Trucksi "+request.get("username").toString() + "\n");
    	
	}

	@Override
	public void showOptions() {
		System.out.println("-------------MENU------------\n");
		
		System.out.println("[T]ruck [H]ystorytravel [C]ity T[R]avel  [E]xit");
		choice = this.getInput();

	}

	@Override
	public void submit() {
		request = new Request();
		
		String[] confronto_user = { "r", "i", "a", "b", "e" };
		//Confronto le possibilità dei vari users
		if(userType.equals("ADMIN")) {

		}
		else if (userType.equals("USER")){
			boolean trovato = false;
			//Confronto l'inserimento dell'utente con i possibili vari per quel utente
			for(String confronto : confronto_user) {
				if(this.choice.equals(confronto)) trovato= true;
			}
			//Se non ho trovato il valore inserito tra le possibilità di quel utenteritorno errore
			if(!trovato) this.choice = "ERROR";
			
		}
		switch (choice) {
			case "u":
	        	this.request.put("mode", "USERLIST");
	        	MainDispatcher.getInstance().callAction("User", "doControl", request);
	        	break;
			
			case "t":
	        	this.request.put("mode", "TRUCKLIST");
	        	MainDispatcher.getInstance().callAction("Truck", "doControl", request);
	        	break;
	        
			case "h":
	        	this.request.put("mode", "HYSTORYTRAVELLIST");
	        	MainDispatcher.getInstance().callAction("Hystorytravel", "doControl", request);
	        	break;
		// travel 
			case "r": 
				this.request.put("mode", "TRAVELLIST");
	        	MainDispatcher.getInstance().callAction("Travel", "doControl", request);
	        	break;
			case "e":
				MainDispatcher.getInstance().callAction("Login", "doControl", null);
				break;
				
			 case "c":
		        this.request.put("mode", "CITYLIST");
		        MainDispatcher.getInstance().callAction("City", "doControl", request);
		        break;
	
			default:
				MainDispatcher.getInstance().callAction("Login", "doControl", null);
		}
	}

}
