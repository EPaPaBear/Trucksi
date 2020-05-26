package it.contrader.view.truck;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class TruckInsertView extends AbstractView{
	private Request request;

	private int howManyPeople;
	private String licensePlate;
	private int peopleBooking;
	private final String mode = "INSERT";

	public TruckInsertView() {
	}
	
	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode INSERT del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Truck", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi del truck da inserire
	 */
	@Override
	public void showOptions() {
			System.out.println("Inserisci il numero massimo di passeggeri:");
			howManyPeople = Integer.parseInt(getInput());
			System.out.println("Inserisci la targa del veicolo:");
			licensePlate = getInput();
			System.out.println("Inserisci il numero dei passeggeri già abbordo:");
			peopleBooking = Integer.parseInt(getInput());
	}

	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("howmanypeople", howManyPeople);
		request.put("licenseplate", licensePlate);
		request.put("peoplebooking", peopleBooking);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Truck", "doControl", request);
	}


}
