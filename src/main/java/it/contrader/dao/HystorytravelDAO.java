package it.contrader.dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import it.contrader.model.Hystorytravel;
import it.contrader.utils.ConnectionSingleton;

public class HystorytravelDAO implements DAO<Hystorytravel>{
	
	private final String QUERY_ALL = "SELECT * FROM hystorytravel;";
	private final String QUERY_CREATE = "INSERT INTO hystorytravel (idtravel, idcity, date, travelindex) values (?,?,?,?);";
	private final String QUERY_READ = "SELECT * FROM hystorytravel WHERE id=?";
	private final String QUERY_UPDATE = "SELECT hystorytravel SET idtravel=? , idcity=? , date=?, travelindex=? WHERE id=?;";
	private final String QUERY_DELETE = "DELETE FROM hystorytravel WHERE id=?";
	private final String QUERY_HYSTORY = "SELECT * FROM hystorytravel WHERE idtravel=? ORDER BY travelindex ASC; ";
	public HystorytravelDAO() {}
	private Date d ;
	
	@Override
	public List<Hystorytravel> getAll() {
		// TODO Auto-generated method stub
		List<Hystorytravel> htList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Hystorytravel ht;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				int idtravel = resultSet.getInt("idtravel");
				int idcity = resultSet.getInt("idcity");
				String date = resultSet.getString("date");
				int travelindex = resultSet.getInt("travelindex");
				ht = new Hystorytravel(id,idtravel, idcity, date, travelindex);
				htList.add(ht);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return htList;
	}
	
//	public List<Hystorytravel> getHystory(int idtravel) {
//		
//		List<Hystorytravel> htList = new ArrayList<>();
//		Connection connection = ConnectionSingleton.getInstance();
//		try {
//			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_HYSTORY);
//			preparedStatement.setInt(1, idtravel);
//			ResultSet resultSet = preparedStatement.executeQuery();
//			Hystorytravel ht;
//			while (resultSet.next()) {
//				int id = resultSet.getInt("id");
//				int travelindex = resultSet.getInt("travelindex");
//				int idcity = resultSet.getInt("idcity");
//				Date hour = resultSet.getDate("hour");
//				ht = new Hystorytravel(id, idtravel, idcity, hour, travelindex);
//				htList.add(ht);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return htList;
//	}
	@Override
	public Hystorytravel read(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement.toString());
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int idtravel = resultSet.getInt("idtravel");
			int idcity = resultSet.getInt("idcity");
			String date = resultSet.getString("date");
			//TODO add hour
			int travelindex = resultSet.getInt("travelindex");
			Hystorytravel ht = new Hystorytravel(id, idtravel, idcity, date, travelindex);
			return ht;
		} catch (SQLException e) {
			System.out.println("sql excelption"+e.toString());
			return null;
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean insert(Hystorytravel hystorytravelToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setInt(1, hystorytravelToInsert.getIdtravel());
			preparedStatement.setInt(2, hystorytravelToInsert.getIdcity());
			System.out.println(hystorytravelToInsert.toString());
		//	preparedStatement.setDate(3, Date.valueOf(hystorytravelToInsert.getDate()));
			System.out.println(hystorytravelToInsert.getDate());
		//	preparedStatement.setDate(parameterIndex, x, cal);(3, Date.parse(hystorytravelToInsert.getDate()));
			preparedStatement.setInt(4, hystorytravelToInsert.getTravelindex());
		//	System.out.println("++++++++++++++++++++++++++++++++++++");
		//	System.out.println(preparedStatement.toString() + "\n");
		//	System.out.println("+++++++++++++++++++++++++++++++++++++");
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			System.out.println("sql excelption"+e.toString());
			return false;
		}
	}

	@Override
	public boolean update(Hystorytravel htToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();
		// Check if id is present
				if (htToUpdate.getId() == 0)
					return false;
				Hystorytravel htRead = read(htToUpdate.getId());
				if(!htRead.equals(htToUpdate)) {
					try {
					// Fill the htToUpdate object
					if (htToUpdate.getIdcity() == 0 ) {
						htToUpdate.setIdcity(htRead.getIdcity());
					}
					if (htToUpdate.getIdtravel() == 0 ) {
						htToUpdate.setIdtravel(htRead.getIdtravel());
					}
					if (htToUpdate.getTravelindex() == 0 ) {
						htToUpdate.setTravelindex(htRead.getTravelindex());
					}
					if(htToUpdate.getHour() == null) {
						htToUpdate.setHour(htRead.getHour());
					}
					PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
					preparedStatement.setInt(1, htToUpdate.getIdtravel());
					preparedStatement.setInt(2, htToUpdate.getIdcity());
				//	preparedStatement.setDate(3, Date.valueOf(htToUpdate.getDate()));
					preparedStatement.setInt(4,  htToUpdate.getTravelindex());
					System.out.println(preparedStatement.toString());
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

	@Override
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
