package it.contrader.model;

public class Travel {
	
	//private variables for db allocation
	int id;
	private int idusername;
	private int idtruck;
	private int idcity;
	private int idhistory;
	
	// declare 3 constructors to user for each ut
	public Travel(){
		
	}
	
	public Travel(int idusername, int idtruck, int idcity, int idhistory) {
		this.idusername = idusername;
		this.idtruck = idtruck;
		this.idcity = idcity;
		this.idhistory = idhistory;
	}
	
	public Travel(int id, int idusername, int idtruck, int idcity, int idhistory) {
		this.id = id;
		this.idusername = idusername;
		this.idtruck = idtruck;
		this.idcity = idcity;
		this.idhistory = idhistory;
	}
	//----------------
	public int getId(){
		return this.id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	//user name
	public int getIdusername() {
		return idusername;
	}
	public void setIdusername(int idusername) {
		this.idusername = idusername;
	}
	
	// truck id
	public int getIdtruck() {
		return idtruck;
	}
	public void setIdtruck(int idtruck) {
		this.idtruck = idtruck;
	}
	// idcity
	public int getIdcity() {
		return idcity;
	}
	
	public void setIdcity(int idcity) {
		this.idcity = idcity;
	}
	// id history
	public int getIdhistory() {
		return idcity;
	}
	public void setIdhistory(int idhistory) {
		this.idhistory = idhistory;
	}
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Travel other = (Travel) obj;
		if (id != other.id)
			return false;
		if (idusername != other.idusername)
			return false;
		if (this.idtruck != other.idtruck)
			return false;
		if (this.idcity != other.idcity)
			return false;
		if (this.idhistory != other.idhistory)
			return false;
		
		return true;
	}
	@Override 
	public String toString() {
			return id + "\t " + idusername + "\t" + idtruck + "\t" + idcity + "\t" + idhistory;
	}
	
}
