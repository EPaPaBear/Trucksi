package it.contrader.dto;



public class HystorytravelDTO {
	private int id;
	private int idtravel;
	private int idcity;
	private String date;
	private int travelindex;
	
	public HystorytravelDTO() {
		
	}
	
	public HystorytravelDTO(int id, int idtravel, int idcity, String date, int travelindex) {
		this.id = id;
		this.idtravel = idtravel;
		this.idcity = idcity;
		this.date = date;
		this.travelindex = travelindex;
	}
	
	public HystorytravelDTO( int idtravel, int idcity, String date, int travelindex) {
		
		this.idtravel = idtravel;
		this.idcity = idcity;
		this.date = date;
		this.travelindex = travelindex;
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
	
	//TODO ADD HOUR



	public int getTravelindex() {
		return travelindex;
	}



	public void setTravelindex(int travelindex) {
		this.travelindex = travelindex;
	}



	@Override
	public String toString() {
		return id + "\t" + idtravel + "\t\t" + idcity + "\t\t" + date + "\t\t" + travelindex ;
	}
}
