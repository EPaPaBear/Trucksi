package it.contrader.view.user;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class UserInsertView extends AbstractView{
	private Request request;

	private String username;
	private String password;
	private String usertype;
	private final String mode = "INSERT";

	public UserInsertView() {
	}
	
	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode INSERT del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Chages successfully.\n");
			MainDispatcher.getInstance().callView("User", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi dell'utente da inserire
	 */
	@Override
	public void showOptions() {
<<<<<<< HEAD
			System.out.println("Insert user ID:");
=======
			System.out.println("Insert username:");
>>>>>>> f1c107cdfc46d1dc58359c7bbbae1079ae034aec
			username = getInput();
			System.out.println("Insert user password:");
			password = getInput();
			System.out.println("Insert user type:");
			usertype = getInput();
	}

	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("username", username);
		request.put("password", password);
		request.put("usertype", usertype);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("User", "doControl", request);
	}


}
