package it.contrader.model;
/**
 * Per dettagli vedi guida sez 4 Model
 */
public class Truck {

	/**
	 * Qui sotto definisco gli attributi di Truck. 
	 */
	private int id;

	private int howManyPeople;
	
	private String licensePlate;
	
	private int peopleBooking;

	/**
	 * Definisco i due costruttori, uno vuoto e uno con tre parametri per costrire oggetti di tipo User
	 */
	public Truck() {
		
	}

	public Truck (int howManyPeople, String licensePlate, int peopleBooking) {
		this.howManyPeople = howManyPeople;
		this.licensePlate = licensePlate;
		this.peopleBooking = peopleBooking;
	}

	public Truck (int id, int howManyPeople, String licensePlate, int peopleBooking) {
		this(howManyPeople, licensePlate, peopleBooking );
		this.id = id;
	}

	/**
	 * Getter e Setter: servono alle altre classi a recuperare e modificare gli attributi di User
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

	//Trasforma un oggetto in una stringa
	@Override
	public String toString() {
		return  id + "\t"  + howManyPeople +"\t\t" + licensePlate + "\t\t" + peopleBooking;
	}

	//Metodo per il confronto degli oggetti
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Truck other = (Truck) obj;
		if (id != other.id)
			return false;
		
		if (howManyPeople != other.howManyPeople)
			return false;
		
		if (licensePlate == null) {
			if (other.licensePlate != null)
				return false; 
		} else if (!licensePlate.equals(other.licensePlate))
			return false;
		
		if (peopleBooking != other.peopleBooking)
			return false;
		
		return true;
	}
}
