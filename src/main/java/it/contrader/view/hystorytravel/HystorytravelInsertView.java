package it.contrader.view.hystorytravel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class HystorytravelInsertView extends AbstractView {
	private Request request;
	private int idtravel;
	private int idcity;
	private Date hour;
	private int travelindex;
	
	public HystorytravelInsertView() {
		
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
		System.out.println("Insert idtravel:");
		this.idtravel = Integer.parseInt(getInput());
		System.out.println("Insert idcity:");
		this.idcity =  Integer.parseInt(getInput());
		 System.out.println("Month (01-12):");
	        int h = Integer.parseInt(getInput());
	        System.out.println("Day (01-31):");
	        int m = Integer.parseInt(getInput());
	        System.out.println("Year (YYYY):");
	        int y = Integer.parseInt(getInput());
	        String data;
	        data = Integer.toString(h) + "-" + Integer.toString(m) + "-" + Integer.toString(y) ;  
	        System.out.println("Date : " + data); 
	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
	      
	        try {
				this.hour = dateFormat.parse(data);
			} catch (ParseException e) {
				e.printStackTrace();
			}
<<<<<<< HEAD
	        System.out.println("Inserisci travelindex:");
=======
	        System.out.println("Insert travelindex:");
>>>>>>> f1c107cdfc46d1dc58359c7bbbae1079ae034aec
	        this.travelindex = Integer.parseInt(getInput());
		
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("idtravel", idtravel);
		request.put("idcity", idcity);
<<<<<<< HEAD
		request.put("hour", hour);
=======
		request.put("hour", hour.toString());
>>>>>>> f1c107cdfc46d1dc58359c7bbbae1079ae034aec
		request.put("travelindex", travelindex);
	}
	

}
