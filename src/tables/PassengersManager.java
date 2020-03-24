package tables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import beans.Passenger;
import utils.DBType;
import utils.DBUtil;


public class PassengersManager {
	public static void displayAllRows() throws SQLException {
		
		String sql = "SELECT * FROM PASSENGERS";
		try (
				Connection conn = DBUtil.getConnection(DBType.MYSQL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				){

			System.out.println("Passengers Table:");
			System.out.println("------------------------");
			while (rs.next()) {

				System.out.println("ID: "+rs.getInt(1));
				System.out.println("First name: "+rs.getString(2));
				if(rs.getString(3)!=null) {
				System.out.println("Middle name: "+rs.getString(3));	
				}
				System.out.println("Last name: "+rs.getString(4));
				System.out.println("Birthdate: "+rs.getDate(5));
				System.out.println("Nationality: "+rs.getString(6));
				System.out.println("Cellphone: "+rs.getString(7));
				System.out.println("Email: "+rs.getString(8));
				System.out.println("------------------------");
				
			}
		}
	}
	public static boolean addPassenger(Passenger bean) throws SQLException {
		String sql = "INSERT into PASSENGERS (First_name, Middle_name, Last_name, Birthdate, Nationality, Cellphone, Email) VALUES (?, ?, ?, ?, ?, ?, ?)";
		ResultSet keys = null;
		try (
				Connection conn = DBUtil.getConnection(DBType.MYSQL);
				PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				) {
			
			stmt.setString(1,bean.getFirstName());
			stmt.setString(2, bean.getMiddleName());
			stmt.setString(3, bean.getLastName());
			stmt.setObject(4, bean.getBirthDate());
			stmt.setString(5, bean.getNationality());
			stmt.setString(6, bean.getCellphone());
			stmt.setString(7, bean.getEmail());
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
	
	public static boolean isValid(String firstName,String lastName,LocalDate birthDate) throws SQLException {
		
		String sql = "SELECT * FROM PASSENGERS";
		try (
				Connection conn = DBUtil.getConnection(DBType.MYSQL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				){

			while (rs.next()) {
				
				if(firstName.equalsIgnoreCase(rs.getString(2)) && lastName.equalsIgnoreCase(rs.getString(4)) && birthDate.toString().equals(rs.getString(5))) {
					return true;
				}	
			}
		}
		return false;
	}
	
	public static int getId(String firstName,String lastName,LocalDate birthDate) throws SQLException {
		
		String sql = "SELECT * FROM PASSENGERS";
		try (
				Connection conn = DBUtil.getConnection(DBType.MYSQL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				){

			while (rs.next()) {
				if(firstName.equalsIgnoreCase(rs.getString(2)) && lastName.equalsIgnoreCase(rs.getString(4)) && birthDate.toString().equals(rs.getString(5))){
					return rs.getInt(1);
				}	
			}
		}
		return 0;
	}
}
