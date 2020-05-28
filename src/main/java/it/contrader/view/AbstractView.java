package it.contrader.view;

import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public abstract class AbstractView implements View {

	private Scanner scanner;
	/**
	*Questo metodo è usato da tutti i controller che lo ereditano (non devono definirlo) estendendo questa classe
	*/
	public String getInput() {
		scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
	
	public void listAll(String view, String mode) {
		Request request = new Request();
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction(view, "doControl", request);
	}
}
