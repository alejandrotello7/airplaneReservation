package insertData;

import java.sql.SQLException;
import java.time.LocalDate;

import beans.FlightPassenger;
import tables.FlightManager;
import tables.FlightPassengerManager;
import tables.PassengersManager;
import utils.InputHelper;

public class InsertFlightPassengerData {

	public static void insert() throws SQLException {
		String firstName;
		String lastName;
		int year;
		int month;
		int day;
		LocalDate birthDate;
		int flightId;
		boolean nameIsValid;
		boolean routeIsValid;
		
		String opt = null;
		do {
			FlightPassenger bean = new FlightPassenger();
			
			do {
				firstName = InputHelper.getInput("Enter first name: ");
				lastName= InputHelper.getInput("Enter last name: ");
				year = InputHelper.getIntegerInput("Enter year of birth: ");
				month = InputHelper.getIntegerInput("Enter month of birth: ");
				day = InputHelper.getIntegerInput("Enter day of birth: ");
				birthDate =  LocalDate.of(year, month, day);
				
				nameIsValid = PassengersManager.isValid(firstName, lastName, birthDate);
				if(nameIsValid) {
					bean.setPassengerId(PassengersManager.getId(firstName, lastName, birthDate));
				}else {
					System.out.println("Name wasn't found in the database, please try again");
				}
				
				
			}while(!nameIsValid);

			do {
				flightId = InputHelper.getIntegerInput("Enter flight ID: ");
				routeIsValid = FlightManager.isValid(flightId);
				if(routeIsValid) {
					bean.setFlightId(flightId);
				}else {
					System.out.println("Flight ID wasn't found in the database, please try again");
				}
			}while(!routeIsValid);

			
			

			
			boolean result = FlightPassengerManager.addPassenger(bean);
			
			if(result) {
				System.out.println("Passenger with ID: "+bean.getPassengerId()+" has been added to the flight: "+bean.getFlightId());
			}else {
				System.err.println("No passenger was added");
			}
			opt = InputHelper.getInput("Do you want to continue adding passengers to flights? y/n ");
			while(!opt.equalsIgnoreCase("y") && !opt.equalsIgnoreCase("n")) {
				System.out.println("Please enter a valid input: y/n ");
				opt = InputHelper.getInput("Do you want to continue adding passengers flights? y/n ");
			}

		}while(opt.equalsIgnoreCase("y"));
	}
}
