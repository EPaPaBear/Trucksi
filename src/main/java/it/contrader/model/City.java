package it.contrader.model;

public class City {
	private int id;
	private String cityname;
	
	public City() {
	}
	
	public City(String cityname) {
		this.cityname = cityname;
	}
	
	public City(int id, String cityname) {
		this.id = id;
		this.cityname = cityname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getcityname() {
		return cityname;
	}

	public void setcityname(String cityname) {
		this.cityname = cityname;
	}
	
	@Override
	public String toString() {
		return  id + "\t"  + cityname ;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		if (this.id != other.id)
			return false;
		if (this.cityname != other.cityname)
			return false;
		
		return true;
	}
}
