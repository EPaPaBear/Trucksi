package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Truck;

/**
 * 
 * @author Vittorio
 *
 *Per i dettagli della classe vedi Guida sez 6: DAO
 */
public class TruckDAO implements DAO<Truck> {
	private final String QUERY_ALL = "SELECT * FROM truck";
	private final String QUERY_CREATE = "INSERT INTO truck (howmanypeople, licenseplate, peoplebooking) VALUES (?,?,?)";
	private final String QUERY_READ = "SELECT * FROM truck WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE truck SET howmanypeople=?, licenseplate=?, peoplebooking=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM truck WHERE id=?";

	public TruckDAO() {

	}

	public List<Truck> getAll() { 
		List<Truck> trucksList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Truck truck;
			while (resultSet.next()) {
				int id = resultSet.getInt("id"); 
				int howManyPeople = resultSet.getInt("howmanypeople");
				String licensePlate = resultSet.getString("licenseplate");
				int peopleBooking = resultSet.getInt("peoplebooking");
				truck = new Truck(howManyPeople, licensePlate , peopleBooking);
				truck.setId(id);
				trucksList.add(truck);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trucksList;
	}

	public boolean insert(Truck truckToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setInt(1, truckToInsert.getHowManyPeople());
			preparedStatement.setString(2, truckToInsert.getLicensePlate());
			preparedStatement.setInt(3, truckToInsert.getPeopleBooking());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Truck read(int truckId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			
			preparedStatement.setInt(1, truckId);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			resultSet.next();
			int howManyPeople, peopleBooking;
			String licensePlate;
			
			howManyPeople = resultSet.getInt("howmanypeople");
			licensePlate = resultSet.getString("licenseplate");
			peopleBooking = resultSet.getInt("peoplebooking"); 
			
			Truck truck = new Truck(howManyPeople, licensePlate, peopleBooking);
			truck.setId(resultSet.getInt("id"));
			
			return truck;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Truck truckToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (truckToUpdate.getId() == 0)
			return false;

		Truck truckRead = read(truckToUpdate.getId());
		if (!truckRead.equals(truckToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (truckToUpdate.getHowManyPeople() == 0) {
					truckToUpdate.setHowManyPeople(truckRead.getHowManyPeople());
				}

				if (truckToUpdate.getLicensePlate() == null || truckToUpdate.getLicensePlate().equals("")) {
					truckToUpdate.setLicensePlate(truckRead.getLicensePlate());
				}

				if (truckToUpdate.getPeopleBooking() == 0) {
					truckToUpdate.setPeopleBooking(truckRead.getPeopleBooking());
				}

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setInt(1, truckToUpdate.getHowManyPeople());
				preparedStatement.setString(2, truckToUpdate.getLicensePlate());
				preparedStatement.setInt(3, truckToUpdate.getPeopleBooking());
				preparedStatement.setInt(4, truckToUpdate.getId());
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				return false;
			}
		}

		return false;

	}

	public boolean delete(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}


}
