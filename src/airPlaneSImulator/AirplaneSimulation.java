package airPlaneSImulator;

import java.sql.SQLException;


import insertData.InsertCityData;
import insertData.InsertPassangerData;
import insertData.InsertRouteData;
import tables.CityManager;
import tables.PassengersManager;
import tables.RouteManager;



public class AirplaneSimulation {
	
	/*private static final String USERNAME = "dbuser";
	private static final String PASSWORD = "dbpassword";
	private static final String CONN_STRING =
				"jdbc:mysql://localhost/airplanesim";*/
	
	public static void main(String[] args) throws SQLException {
		

		//Country Mexico = new Country("Mexico");
		//PassengersManager.displayAllRows();
		//InsertCityData.insert();
		//CityManager.displayAllRows();
		InsertRouteData.insert();
		//InsertCityData.insert();
		RouteManager.displayAllRows();
		//InsertPassangerData.insert();


		
	}
}
