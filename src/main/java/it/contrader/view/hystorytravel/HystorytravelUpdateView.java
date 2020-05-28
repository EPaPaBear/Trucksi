package it.contrader.view.hystorytravel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class HystorytravelUpdateView extends AbstractView {
	private int id;
	private int idtravel;
	private int idcity;
	private Date hour;
	private int travelindex;
	private final String mode = "UPDATE";

	public HystorytravelUpdateView() {
		
	}
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Change successfull.\n");
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
	        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm");
	      
	        try {
				this.hour = dateFormat.parse(data);
			} catch (ParseException e) {
				e.printStackTrace();
			}
	        System.out.println("Insert travelindex:");
	        this.travelindex = Integer.parseInt(getInput());
		
	}

	@Override
	public void submit() {
		Request request = new Request();
		request.put("id", id);
		request.put("idtravel", idtravel);
		request.put("idcity", idcity);
		request.put("hour", hour);
		request.put("travelindex", travelindex);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Hystorytravel", "doControl", request);
		
	}

}
