package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Travel;

public class TravelDao implements DAO<Travel>{
	private final String QUERY_ALL = "SELECT * FROM Travel;";
	private final String QUERY_CREATE = "INSERT INTO Travel (idusername, idtruck, idcity, idhistory	) values (?,?,?,?);";
	private final String QUERY_READ = "SELECT * FROM Travel WHERE id=?";
	private final String QUERY_UPDATE = "SELECT Travel SET idusername=? , idtruck=? , idcity=?, idhistory=? WHERE id=?;";
	private final String QUERY_DELETE = "DELETE FROM Travel WHERE id=?";
	private final String QUERY_HYSTORY = "SELECT * FROM Travel WHERE idusername=? ORDER BY travelindex ASC; "; // to check well
	
	public TravelDao(){
		
	}
	
	@Override
	public List<Travel> getAll() {
		// TODO Auto-generated method stub
		List<Travel> htList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Travel ht;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				int idusername = resultSet.getInt("idusername");
				int idtruck = resultSet.getInt("idtruck");
				int idcity = resultSet.getInt("idcity");
				int idhistory = resultSet.getInt("idhistory");
				ht = new Travel(id,idusername, idtruck, idcity, idhistory);
				htList.add(ht);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return htList;
	}
	
	
	@Override
	public Travel read(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int idusername = resultSet.getInt("idusername");
			int idtruck = resultSet.getInt("idtruck");
			int idcity = resultSet.getInt("idcity");
			int idhistory = resultSet.getInt("idhistory");
			Travel ht = new Travel(id, idusername, idtruck, idcity, idhistory);
			return ht;
		} catch (SQLException e) {
			return null;
		}
	}
	
	
	@Override
	public boolean insert(Travel travelToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setInt(1, travelToInsert.getId());
			preparedStatement.setInt(2, travelToInsert.getIdtruck());
			preparedStatement.setInt(3, travelToInsert.getIdcity());
			preparedStatement.setInt(4, travelToInsert.getIdhistory());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	
	
	@Override
	public boolean update(Travel htToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();
		// Check if id is present
				if (htToUpdate.getId() == 0)
					return false;
				
				Travel htRead = read(htToUpdate.getId());
				if(!htRead.equals(htToUpdate)) {
					try {
					// Fill the htToUpdate object
					if (htToUpdate.getIdusername() == 0 ) {
						htToUpdate.setIdusername(htRead.getIdusername());
					}
					if (htToUpdate.getIdtruck() == 0 ) {
						htToUpdate.setIdtruck(htRead.getIdtruck());
					}
					if (htToUpdate.getIdcity() == 0 ) {
						htToUpdate.setIdcity(htRead.getIdcity());
					}
					if(htToUpdate.getIdhistory() == 0) {
						htToUpdate.setIdhistory(htRead.getIdhistory());
					}
					PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
					preparedStatement.setInt(1, htToUpdate.getIdusername());
					preparedStatement.setInt(2, htToUpdate.getIdtruck());
             		preparedStatement.setInt(3,htToUpdate.getIdcity());
					preparedStatement.setInt(4,  htToUpdate.getIdhistory());
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
