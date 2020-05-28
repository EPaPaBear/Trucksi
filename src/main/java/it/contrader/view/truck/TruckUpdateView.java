package it.contrader.view.truck;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;


public class TruckUpdateView extends AbstractView {
	private Request request;

	private int id;
	private int howManyPeople;
	private String licensePlate;
	private int peopleBooking;
	private final String mode = "UPDATE";

	public TruckUpdateView() {
	}

	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode UPDATE del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Truck", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi del truck da modificare
	 */
	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id del truck:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci il numero massimo di passeggeri:");
			howManyPeople = Integer.parseInt(getInput());
			System.out.println("Inserisci la targa del veicolo:");
			licensePlate = getInput();
			System.out.println("Inserisci il numero dei passeggeri già a bordo:");
			peopleBooking = Integer.parseInt(getInput());
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
		request.put("howmanypeople", howManyPeople);
		request.put("licenseplate", licensePlate);
		request.put("peoplebooking", peopleBooking);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Truck", "doControl", request);
	}

}
