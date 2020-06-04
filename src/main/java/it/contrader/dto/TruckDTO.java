package it.contrader.dto;

/**
 * 
 * @author Vittorio
 *
 *Il DTO è simile al Model ma può contenere meno attributi (ad esempio d dati sensibili
 *che non devono arrivare alla View). GLi oggetti vengono trasformati da oggetti del Model
 *a oggetti del DTO tramite i Converter (chiamati dai Service). 
 *Per la descrizione della classe far riferimento al Model "Truck".
 */
public class TruckDTO {
	
	/**
	 * Qui sotto definisco gli attributi di Truck. 
	 */
	private int id;

	private int howManyPeople;
	
	private String licensePlate;
	
	private int peopleBooking;

	public TruckDTO() {
		
	}

	public TruckDTO (int howManyPeople, String licensePlate, int peopleBooking) {
		this.howManyPeople = howManyPeople;
		this.licensePlate = licensePlate;
		this.peopleBooking = peopleBooking;
	}

	public TruckDTO (int id, int howManyPeople, String licensePlate, int peopleBooking) {
		this(howManyPeople, licensePlate, peopleBooking );
		this.id = id;
	}

	/**
	 * Metodi Getter e Setter
	 */
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getHowManyPeople() {
		return this.howManyPeople;
	}

	public void setHowManyPeople(int howManyPeople) {
		this.howManyPeople = howManyPeople;
	}


	public String getLicensePlate() { 
		return this.licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public void setPeopleBooking(int peopleBooking) {
		this.peopleBooking = peopleBooking;
	}

	public int getPeopleBooking() {
		return peopleBooking;
	}

	@Override
	public String toString() {
		return  id + "\t"  + howManyPeople +"\t\t" + licensePlate + "\t\t" + peopleBooking;
	}
}
