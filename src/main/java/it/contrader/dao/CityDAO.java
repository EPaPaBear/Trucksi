package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.City;
import it.contrader.model.Truck;

public class CityDAO implements DAO<City>{
	
	private final String QUERY_ALL = "SELECT * FROM city";
	private final String QUERY_CREATE = "INSERT INTO city (cityname) VALUES (?)";
	private final String QUERY_READ = "SELECT * FROM city WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE city SET cityname=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM city WHERE id=?";
	
	public CityDAO() {

	}
	
	public List<City> getAll() { 
		List<City> cityList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			City city;
			while (resultSet.next()) {
				int id = resultSet.getInt("id"); 
				String cityname = resultSet.getString("cityname");
				city = new City(cityname);
				city.setId(id);
				cityList.add(city);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cityList;
	}
	
	public boolean insert(City cityToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, cityToInsert.getcityname());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	public City read(int cityId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			
			preparedStatement.setInt(1, cityId);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			resultSet.next();
			String cityname;
			
			cityname = resultSet.getString("cityname");
			
			City city = new City(cityname);
			city.setId(resultSet.getInt("id"));
			
			return city;
		} catch (SQLException e) {
			return null;
		}
	}
	
	public boolean update(City cityToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (cityToUpdate.getId() == 0)
			return false;

		City cityRead = read(cityToUpdate.getId());
		if (!cityRead.equals(cityToUpdate)) {
			try {
				// Fill the cityToUpdate object
				if (cityToUpdate.getcityname() == null || cityToUpdate.getcityname().equals("")) {
					cityToUpdate.setcityname(cityRead.getcityname());
				}

				// Update the city
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, cityToUpdate.getcityname());
				preparedStatement.setInt(2, cityToUpdate.getId());
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
