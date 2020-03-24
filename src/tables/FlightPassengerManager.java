package tables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import beans.FlightPassenger;
import utils.DBType;
import utils.DBUtil;

public class FlightPassengerManager {
	
	public static void displayAllRows() throws SQLException {
		
		String sql = "SELECT * FROM `FLIGHTS.PASSENGERS`";
		try (
				Connection conn = DBUtil.getConnection(DBType.MYSQL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				){

			System.out.println("Schedules flights for passengers:");
			System.out.println("------------------------");
			while (rs.next()) {

				System.out.println("ID: "+rs.getInt(1));
				System.out.println("Flight ID: "+rs.getString(2));
				System.out.println("Passenger ID: "+rs.getInt(3));
				System.out.println("------------------------");
				
			}
		}
	}
	
	public static boolean addPassenger(FlightPassenger bean) throws SQLException {
		String sql = "INSERT INTO `FLIGHTS.PASSENGERS` (`Flight_id`, `Passenger_id`) VALUES (?,?)";
		ResultSet keys = null;
		try (
				Connection conn = DBUtil.getConnection(DBType.MYSQL);
				PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				) {

			stmt.setInt(1, bean.getFlightId());
			stmt.setInt(2, bean.getPassengerId());

			int affected = stmt.executeUpdate();

			if(affected > 0) {
				FlightManager.reduceAvailableSeats(bean.getFlightId());
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

	}//addPassenger
}
