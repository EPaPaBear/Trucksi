package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Driver;
import it.contrader.model.Truck;

public class DriverDAO implements DAO<Driver>{

	private final String QUERY_ALL = "SELECT * FROM driver";
	private final String QUERY_CREATE = "INSERT INTO driver (drivername, drivermobile, idtruck) VALUES (?,?,?)";
	private final String QUERY_READ = "SELECT * FROM driver WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE driver SET drivername=?, drivermobile=?, idtruck=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM driver WHERE id=?";

	public DriverDAO() {

	}
	
	public List<Driver> getAll() { 
		List<Driver> driversList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Driver driver;
			while (resultSet.next()) {
				int id = resultSet.getInt("id"); 
				String drivername = resultSet.getString("drivername");
				String drivermobile = resultSet.getString("drivermobile");
				int idtruck = resultSet.getInt("idtruck");
				driver = new Driver(drivername, drivermobile , idtruck);
				driver.setId(id);
				driversList.add(driver);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return driversList;
	}
	
	public boolean insert(Driver driverToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, driverToInsert.getDrivername());
			preparedStatement.setString(2, driverToInsert.getDrivermobile());
			preparedStatement.setInt(3, driverToInsert.getId());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}
	
	public Driver read(int driverId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			
			preparedStatement.setInt(1, driverId);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			resultSet.next();
			String drivername, drivermobile;
			int idtruck;
			
			drivername = resultSet.getString("drivername");
			drivermobile = resultSet.getString("drivermobile");
			idtruck = resultSet.getInt("idtruck"); 
			
			Driver driver = new Driver(drivername, drivermobile, idtruck);
			driver.setId(resultSet.getInt("id"));
			
			return driver;
		} catch (SQLException e) {
			return null;
		}

	}
	
	public boolean update(Driver driverToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (driverToUpdate.getId() == 0)
			return false;

		Driver driverRead = read(driverToUpdate.getId());
		if (!driverRead.equals(driverToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (driverToUpdate.getDrivername() == null || driverToUpdate.getDrivername().equals("")) {
					driverToUpdate.setDrivername(driverRead.getDrivername());
				}

				if (driverToUpdate.getDrivermobile() == null || driverToUpdate.getDrivermobile().equals("")) {
					driverToUpdate.setDrivermobile(driverRead.getDrivermobile());
				}

				if (driverToUpdate.getIdtruck() == 0) {
					driverToUpdate.setIdtruck(driverRead.getIdtruck());
				}

				// Update the driver
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, driverToUpdate.getDrivername());
				preparedStatement.setString(2, driverToUpdate.getDrivermobile());
				preparedStatement.setInt(3, driverToUpdate.getIdtruck());
				preparedStatement.setInt(4, driverToUpdate.getId());
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
