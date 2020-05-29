package it.contrader.dto;

public class TravelDTO {
	int id;
	private int idusername;
	private int idtruck;
	private int idcity;
	private int idhistory;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setIdusername(int idusername) {
		this.idusername = idusername;
	}
	public int getIdusername() {
		return idusername;
	}
	public int getIdtruck() {
		return idtruck;
	}
	public void setIdtruck(int idtruck) {
		this.idtruck = idtruck;
	}
	public int getIdcity() {
		return idcity;
	}
	public void setIdcity(int idcity) {
		this.idcity = idcity;
	}
	public int getIdhistory()
	{
		return idhistory;
	}
	public void setIdhistory(int idhistory) {
		this.idhistory = idhistory;
	}
	
	public String toString() {
		return id + "\t" + idtruck + "\t" + idcity + "\t" + idhistory;
	}
}
