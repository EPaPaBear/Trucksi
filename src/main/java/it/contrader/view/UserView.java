package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;


/**
 * 
 * @author Vittorio
 *
 * Si osservi che alla View arrivano solo oggetti di tipo DTO!
 */
public class UserView extends AbstractView {

	private Request request;
	private String choice;

	public UserView() {
		
	}

	/**
	 * Mostra la lista utenti
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n-------------------User Management ----------------\n");
			System.out.println("ID\tUsername\tPassword\tUserType");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<UserDTO> users = (List<UserDTO>) request.get("users");
			for (UserDTO u: users)
				System.out.println(u);
			System.out.println();
		}
	}

	/**
	 * Chiede all'utente un input (lettera da tastiera) per la choice (vedi UserController). 
	 * Mette la modalità GETCHOICE nella mode.
	 */
	@Override
	public void showOptions() {
		System.out.println("          What operation would you like to perform?:");
		System.out.println("[R]ead [I]nsert [U]pdate [D]elete list[A]ll [E]xit");

		this.choice = getInput();

		
	}
	
	/**
	 * Impacchetta la request e la manda allo UserController.
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("User", "doControl", this.request);
	}

}
