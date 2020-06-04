package it.contrader.model;

import java.util.Date;

public class Hystorytravel {

	private int id;
	private int idtravel;
	private int idcity;
	private String date;
	private String hour;
	private int travelindex;
	
	/**
	 * @return 
	 * 
	 */
	public Hystorytravel() {
		
	}
	public Hystorytravel(int idtravel, int idcity, String date, int travelindex) {
		this.idtravel = idtravel;
		this.idcity = idcity;
		this.date = date;
		this.travelindex = travelindex;
	}
	public Hystorytravel(int id, int idtravel, int idcity, String date, int travelindex) {
		this( idtravel, idcity, date, travelindex);
		this.id = id;
	/*	this.idtravel = idtravel;
		this.idcity = idcity;
		this.hour = hour;
		this.travelindex = travelindex;
	*/
	}
	
	
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
	public int getTravelindex() {
		return travelindex;
	}
	public void setTravelindex(int travelindex) {
		this.travelindex = travelindex;
	}
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hystorytravel other = (Hystorytravel) obj;
		if (id != other.id)
			return false;
		if (idtravel != other.idtravel)
			return false;
		if (this.idcity != other.idcity)
			return false;
		if (this.idtravel != other.idtravel)
			return false;
		if (this.travelindex != other.idtravel)
			return false;
		if (this.date != other.date)
			return false;
		if (this.idtravel == 0 && other.idtravel != 0) 
			return false;
		
		return true;
	}
	@Override
	public String toString() {
		return id + "\t" + idtravel + "\t\t" + idcity + "\t\t"+ date + "\t\t" + hour + "\t\t" + travelindex ;
	}
	
	// To String
	
}
