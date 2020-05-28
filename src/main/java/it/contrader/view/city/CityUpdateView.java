package it.contrader.view.city;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class CityUpdateView extends AbstractView{
	private Request request;

	private int id;
	private String cityname;
	private final String mode = "UPDATE";

	public CityUpdateView() {
	}

	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode UPDATE del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			listAll("City", "CITYLIST");
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi della città da modificare
	 */
	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id della città:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci il nome della città :");
			cityname = getInput();
		} catch (Exception e) {

		}
	}


	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("cityname", cityname);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("City", "doControl", request);
	}
}
