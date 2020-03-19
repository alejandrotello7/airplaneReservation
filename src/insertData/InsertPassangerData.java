package insertData;

import java.sql.SQLException;

import beans.Passenger;
import tables.PassengersManager;
import utils.InputHelper;

public class InsertPassangerData {

	public static void insert() throws SQLException {
		
		String opt = null;
		do {
			Passenger bean = new Passenger();
			bean.setFirstName(InputHelper.getInput("FIrst name: "));
			bean.setMiddleName(InputHelper.getInput("Middle Name: "));
			bean.setLastName(InputHelper.getInput("Last name: "));
			bean.setBirthDate(InputHelper.getIntegerInput("Enter Year of Birth: "), InputHelper.getIntegerInput("Enter Month of Birth: "), InputHelper.getIntegerInput("Enter Day of Birth: "));
			bean.setNationality(InputHelper.getInput("Nationality: "));
			bean.setCellphone(InputHelper.getInput("Cellphone: "));
			bean.setEmail(InputHelper.getInput("Email: "));
			
			boolean result = PassengersManager.addPassenger(bean);
			if(result) {
				System.out.println("Passenger: "+bean.getFirstName()+" with ID "+bean.getId()+" was added succesfully");
			}else {
				System.err.println("No passenger was added");
			}
			
			opt = InputHelper.getInput("Do you want to continue adding passengers? y/n ");
			while(!opt.equalsIgnoreCase("y") && !opt.equalsIgnoreCase("n")) {
				System.out.println("Please enter a valid input: y/n ");
				opt = InputHelper.getInput("Do you want to continue adding passengers? y/n ");
			}
		}while(opt.equalsIgnoreCase("y"));
		

	}
	
}
