package tables;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import beans.City;
import utils.DBType;
import utils.DBUtil;



public class CityManager {
	public static void displayAllRows() throws SQLException {
		String sql = "SELECT * FROM CITIES";
		try (
				Connection conn = DBUtil.getConnection(DBType.MYSQL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				){

			System.out.println("Cities Table:");
			System.out.println("------------------------");
			while (rs.next()) {

				System.out.println("ID: "+rs.getInt(1));
				System.out.println("City name: "+rs.getString(2));
				System.out.println("Country name: "+rs.getString(3));
				System.out.println("Airport name: "+rs.getString(4));
				System.out.println("------------------------");

			}
		}

	}

	public static boolean addCity(City bean) throws SQLException {
		String sql = "INSERT into CITIES (Name, Country, Airport_name) VALUES (?,?,?)";
		ResultSet keys = null;
		try (
				Connection conn = DBUtil.getConnection(DBType.MYSQL);
				PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				) {

			stmt.setString(1,bean.getName());
			stmt.setString(2, bean.getCountry());
			stmt.setString(3, bean.getAirport_name());

			int affected = stmt.executeUpdate();

			if(affected > 0) {
				keys =stmt.getGeneratedKeys();
				keys.next();
				int newKey = keys.getInt(1);
				bean.setId(newKey);
			} else {
				System.err.println("No rows affected");
				return false;
			}

		} catch (SQLException e) {
			System.err.println(e);
			return false;
		} finally{
			if(keys!= null) keys.close();
		}
		return true;

	}//addCity

	public static boolean isValid(String city) throws SQLException{
		String sql = "SELECT * FROM CITIES";
		try (
				Connection conn = DBUtil.getConnection(DBType.MYSQL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				){

			while (rs.next()) {

				if(city.equalsIgnoreCase(rs.getString(2))){
					return true;
				}

			}
			return false;

		}
	}
	
	public static String getAirportName(String city) throws SQLException{
		String sql = "SELECT * FROM CITIES";
		try (
				Connection conn = DBUtil.getConnection(DBType.MYSQL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				){

			while (rs.next()) {

				if(city.equalsIgnoreCase(rs.getString(2))){
					return rs.getString(4);
				}

			}
			return null;

		}
	}

}//CItyManager Class
