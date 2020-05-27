package it.contrader.dto;

import java.util.Date;

public class HystorytravelDTO {
	private int id;
	private int idtravel;
	private int idcity;
	private Date hour;
	private int travelindex;
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getIdtravel() {
		return idtravel;
	}



	public void setIdtravel(int idtravel) {
		this.idtravel = idtravel;
	}



	public int getIdcity() {
		return idcity;
	}



	public void setIdcity(int idcity) {
		this.idcity = idcity;
	}



	public Date getHour() {
		return hour;
	}



	public void setHour(Date hour) {
		this.hour = hour;
	}



	public int getTravelindex() {
		return travelindex;
	}



	public void setTravelindex(int travelindex) {
		this.travelindex = travelindex;
	}



	@Override
	public String toString() {
		return id + "\t" + idtravel + "\t\t" + idcity + "\t\t" + hour + "\t\t" + travelindex ;
	}
}
