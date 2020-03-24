package insertData;

import java.sql.SQLException;

import beans.Flight;
import tables.FlightManager;
import tables.RouteManager;
import utils.InputHelper;

public class InsertFlightData {
public static void insert() throws SQLException {
		
		String opt = null;
		boolean isValid = false;
		do {
			Flight bean = new Flight();
			String origin = null;
			String destination = null;
			

			
			
			do {
				origin = InputHelper.getInput("Insert Origin: ");
				destination = InputHelper.getInput("Insert Destination: ");
				isValid = RouteManager.isValid(origin,destination);
				
				if(isValid) {
					String temp = RouteManager.getRouteName(origin, destination);
					bean.setRoute(temp);
				}else {
					System.err.println("Invalid Route");
				}
				
			}while(!isValid);
			bean.setCapacity(InputHelper.getIntegerInput("Insert capacity  of the flight: "));
			bean.setDepartureDate(InputHelper.getIntegerInput("Enter year of departure: "), InputHelper.getIntegerInput("Enter Month of departure: "), InputHelper.getIntegerInput("Enter day of departure: "));
			
			boolean result = FlightManager.addFlight(bean);
			if(result) {
				System.out.println("Flight  ID: "+bean.getId());
				System.out.println("Route : "+bean.getRoute());
				System.out.println("Capacity "+bean.getCapacity());
				System.out.println("Available seats: "+bean.getAvailableSeats());
				System.out.println("Departure date: "+bean.getDepartureDate());
				System.out.println("Has been added succesfully");
				
			}else {
				System.err.println("No route was added");
			}
			
			
			
			opt = InputHelper.getInput("Do you want to continue adding flights? y/n ");
			while(!opt.equalsIgnoreCase("y") && !opt.equalsIgnoreCase("n")) {
				System.out.println("Please enter a valid input: y/n ");
				opt = InputHelper.getInput("Do you want to continue adding flights? y/n ");
			}
		}while(opt.equalsIgnoreCase("y"));
		
	}
}
