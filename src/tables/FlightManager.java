package tables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import beans.Flight;
import utils.DBType;
import utils.DBUtil;

public class FlightManager {
	
	public static void displayFlights() throws SQLException {
		String sql = "SELECT * FROM FLIGHTS";
		try (
				Connection conn = DBUtil.getConnection(DBType.MYSQL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				){

			System.out.println("Flights Table:");
			System.out.println("------------------------");
			while (rs.next()) {
				
				System.out.println("Flight ID: "+rs.getInt(1));
				System.out.println("Route name: "+rs.getString(2));
				System.out.println("Capacity: "+rs.getInt(3));
				System.out.println("Available seats: : "+rs.getInt(4));
				System.out.println("Departure date: : "+rs.getString(5));
				System.out.println("------------------------");

			}
		}
	}
	
	public static boolean addFlight(Flight bean) throws SQLException {
		String sql = "INSERT into FLIGHTS (Route, Capacity, Available_seats, Departure_date) VALUES (?, ?, ?, ?)";
		ResultSet keys = null;
		try (
				Connection conn = DBUtil.getConnection(DBType.MYSQL);
				PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				) {
			
			stmt.setString(1,bean.getRoute());
			stmt.setInt(2, bean.getCapacity());
			stmt.setInt(3, bean.getAvailableSeats());
			stmt.setObject(4, bean.getDepartureDate());
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
		
	}
	
	public static boolean isValid(int flightId) throws SQLException {
		String sql = "SELECT * FROM FLIGHTS";
		try (
				Connection conn = DBUtil.getConnection(DBType.MYSQL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				){

			while (rs.next()) {
				
				if(flightId == rs.getInt(1)) {
					return true;
				}

			}
		}
		return false;
	}
	
	public static boolean reduceAvailableSeats(int flightId) throws SQLException {
		String sql = "SELECT * FROM FLIGHTS";

		try (
				Connection conn = DBUtil.getConnection(DBType.MYSQL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				){

			while (rs.next()) {
				
				if(flightId == rs.getInt(1)) {
					int availableSeats = rs.getInt(4);
					availableSeats -= 1;
					String sqlReduce = "UPDATE `FLIGHTS` SET `Available_seats` = ? WHERE `FLIGHTS`.`Id` = ?";
					PreparedStatement stmt2 = conn.prepareStatement(sqlReduce, Statement.RETURN_GENERATED_KEYS);
					stmt2.setInt(1, availableSeats);
					stmt2.setInt(2, flightId);
					stmt2.executeUpdate();
					return true;
				}

			}
		}
		return false;
	}

	

}
