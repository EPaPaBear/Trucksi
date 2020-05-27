package it.contrader.view.city;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class CityInsertView extends AbstractView{

	private Request request;

	private String cityname;
	private final String mode = "INSERT";

	public CityInsertView() {
	}
	
	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode INSERT del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("City", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi del truck da inserire
	 */
	@Override
	public void showOptions() {
			System.out.println("Inserisci il nome della città:");
			cityname = getInput();
	}

	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("cityname", cityname);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("City", "doControl", request);
	}
}
