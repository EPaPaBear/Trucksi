package it.contrader.dto;

public class DriverDTO {

	private int id;

	private String drivername;
	
	private String drivermobile;
	
	private int idtruck;
	
	public DriverDTO() {
		
	}

	public DriverDTO (String drivername, String drivermobile, int idtruck) {
		this.drivername = drivername;
		this.drivermobile = drivermobile;
		this.idtruck = idtruck;
	}

	public DriverDTO (int id, String drivername, String drivermobile, int idtruck) {
		this(drivername, drivermobile, idtruck );
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDrivername() {
		return drivername;
	}

	public void setDrivername(String drivername) {
		this.drivername = drivername;
	}

	public String getDrivermobile() {
		return drivermobile;
	}

	public void setDrivermobile(String drivermobile) {
		this.drivermobile = drivermobile;
	}

	public int getIdtruck() {
		return idtruck;
	}

	public void setIdtruck(int idtruck) {
		this.idtruck = idtruck;
	}
	
	@Override
	public String toString() {
		return  id + "\t"  + drivername +"\t\t" + drivermobile + "\t\t" + idtruck;
	}
}
