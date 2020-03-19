package insertData;

import java.sql.SQLException;

import beans.City;
import tables.CityManager;
import utils.InputHelper;

public class InsertCityData {

	public static void insert() throws SQLException {

		String opt = null;
		do {
			City bean = new City();
			bean.setName(InputHelper.getInput("Enter city name: "));
			bean.setCountry(InputHelper.getInput("Enter country name: "));
			bean.setAirportName(InputHelper.getInput("Enter airport name: ").toUpperCase());
			boolean result = CityManager.addCity(bean);
			if(result) {
				System.out.println("City: "+bean.getName()+" has been added");
			}else {
				System.err.println("No city was added");
			}
			opt = InputHelper.getInput("Do you want to continue adding cities? y/n ");
			while(!opt.equalsIgnoreCase("y") && !opt.equalsIgnoreCase("n")) {
				System.out.println("Please enter a valid input: y/n ");
				opt = InputHelper.getInput("Do you want to continue adding cities? y/n ");
			}

		}while(opt.equalsIgnoreCase("y"));
	}

}
