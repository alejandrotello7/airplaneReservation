package tables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import beans.Route;
import utils.DBType;
import utils.DBUtil;

public class RouteManager {

	public static void displayAllRows() throws SQLException {
		String sql = "SELECT * FROM ROUTES";
		try (
				Connection conn = DBUtil.getConnection(DBType.MYSQL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				){

			System.out.println("Route Table:");
			System.out.println("------------------------");
			while (rs.next()) {

				System.out.println("Route name: "+rs.getString(1));
				System.out.println("Origin name: "+rs.getString(2));
				System.out.println("Destination: "+rs.getString(3));
				System.out.println("------------------------");

			}
		}
	}
	
	public static boolean addRoute(Route bean) throws SQLException {
		String sql = "INSERT into ROUTES (Name, Origin, Destination) VALUES (?, ?, ?)";
		ResultSet keys = null;
		try (
				Connection conn = DBUtil.getConnection(DBType.MYSQL);
				PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				) {
			
			stmt.setString(1,bean.getName());
			stmt.setString(2, bean.getOrigin());
			stmt.setString(3, bean.getDestination());

			stmt.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		} finally{
			if(keys!= null) keys.close();
		}
		return true;
		
	}
	
	public static boolean isValid(String origin, String destination) throws SQLException{
		String sql = "SELECT * FROM ROUTES";
		try (
				Connection conn = DBUtil.getConnection(DBType.MYSQL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				){

			while (rs.next()) {

				if(origin.equalsIgnoreCase(rs.getString(2)) && destination.equalsIgnoreCase(rs.getString(3))){
					return true;
				}

			}
			return false;

		}
	}
	
	public static String getRouteName(String origin, String destination) throws SQLException{
		String sql = "SELECT * FROM ROUTES";
		try (
				Connection conn = DBUtil.getConnection(DBType.MYSQL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				){

			while (rs.next()) {

				if(origin.equalsIgnoreCase(rs.getString(2)) && destination.equalsIgnoreCase(rs.getString(3))){
					return rs.getString(1);
				}

			}
			return null;
		

		}
	}
	


}
