package it.contrader.view.hystorytravel;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class HystorytravelDeleteView extends AbstractView {
	private Request request;

	private int id;
	private final String mode = "DELETE";
	
	public HystorytravelDeleteView() {
		
	}
	@Override
	public void showResults(Request request) {
		if (request!=null) {
<<<<<<< HEAD
			System.out.println("Cancellazione andata a buon fine.\n");
=======
			System.out.println("Hystorytravel successfully deleted\r\n");
>>>>>>> f1c107cdfc46d1dc58359c7bbbae1079ae034aec
			MainDispatcher.getInstance().callView("Hystorytravel", null);
		}
		
	}

	@Override
	public void showOptions() {
		System.out.println("Insert idtravel:");
		id = Integer.parseInt(getInput());
		
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Hystorytravel", "doControl", request);
		
	}

}
