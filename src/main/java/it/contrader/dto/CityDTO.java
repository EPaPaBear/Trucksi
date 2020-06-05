package it.contrader.dto;

public class CityDTO {
	private int id;
	private String cityname;
	
	public CityDTO() {
		
	}

	public CityDTO (String cityname) {
		this.cityname = cityname;
	}

	public CityDTO (int id,String cityname) {
		this(cityname);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	
	@Override
	public String toString() {
		return  id + "\t"  + cityname;
	}
}
