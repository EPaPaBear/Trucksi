package it.contrader.dto;
/**
 * 
 * @author Vittorio
 *
 *Il DTO è simile al Model ma può contenere meno attributi (ad esempio d dati sensibili
 *che non devono arrivare alla View). GLi oggetti vengono trasformati da oggetti del Model
 *a oggetti del DTO tramite i Converter (chiamati dai Service). 
 *Per la descrizione della classe far riferimento al Model "City".
 */

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
