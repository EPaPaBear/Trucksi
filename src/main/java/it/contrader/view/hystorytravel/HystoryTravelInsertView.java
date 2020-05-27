package it.contrader.view.hystorytravel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class HystoryTravelInsertView extends AbstractView {
	private Request request;
	private int idtravel;
	private int idcity;
	private Date hour;
	private int travelindex;
	
	public HystoryTravelInsertView() {
		
	}
	
	

	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Hystorytravel", null);
		}
		
	}

	@Override
	public void showOptions() {
		System.out.println("Inserisci idtravel:");
		this.idtravel = Integer.parseInt(getInput());
		System.out.println("Inserisci idcity:");
		this.idcity =  Integer.parseInt(getInput());
		 System.out.println("ore (01-24):");
	        int h = Integer.parseInt(getInput());
	        System.out.println("minuti (00-59):");
	        int m = Integer.parseInt(getInput());
	        String data;
	        data = Integer.toString(h) + ":" + Integer.toString(m);  
	        System.out.println("Orario : " + data); 
	        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm");
	      
	        try {
				this.hour = dateFormat.parse(data);
			} catch (ParseException e) {
				e.printStackTrace();
			}
	        System.out.println("Inserisci travelindex:");
	        this.travelindex = Integer.parseInt(getInput());
		
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("idtravel", idtravel);
		request.put("idcity", idcity);
		request.put("hour", hour);
		request.put("travelindex", travelindex);
	}
	

}
