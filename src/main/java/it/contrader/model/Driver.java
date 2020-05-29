package it.contrader.model;

public class Driver {
	private int id;

	private String drivername;
	
	private String drivermobile;
	
	private int idtruck;
	
	public Driver() {
		
	}

	public Driver (String drivername, String drivermobile, int idtruck) {
		this.drivername = drivername;
		this.drivermobile = drivermobile;
		this.idtruck = idtruck;
	}

	public Driver (int id, String drivername, String drivermobile, int idtruck) {
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
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Driver other = (Driver) obj;
		if (id != other.id)
			return false;
		
		if (drivername != other.drivername)
			return false;
		
		if (drivermobile == null) {
			if (other.drivermobile != null)
				return false; 
		} else if (!drivermobile.equals(other.drivermobile))
			return false;
		
		if (idtruck != other.idtruck)
			return false;
		
		return true;
	}
}
