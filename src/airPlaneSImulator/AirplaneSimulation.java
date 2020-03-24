package airPlaneSImulator;

import java.sql.SQLException;


import insertData.InsertCityData;
import insertData.InsertFlightData;
import insertData.InsertFlightPassengerData;
import insertData.InsertPassangerData;
import insertData.InsertRouteData;
import tables.CityManager;
import tables.FlightManager;
import tables.FlightPassengerManager;
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
		//InsertRouteData.insert();
		//RouteManager.displayAllRows();
		//InsertCityData.insert();
		//RouteManager.displayAllRows();
		//InsertPassangerData.insert();
		//FlightManager.displayFlights();
		//InsertFlightData.insert();
		//FlightManager.displayFlights();
		InsertFlightPassengerData.insert();
		FlightPassengerManager.displayAllRows();


		
	}
}

