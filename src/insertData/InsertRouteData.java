package insertData;

import java.sql.SQLException;

import beans.Route;
import tables.CityManager;
import tables.RouteManager;
import utils.InputHelper;

public class InsertRouteData {
	public static void insert() throws SQLException {
		
		String opt = null;
		do {
			Route bean = new Route();
			String origin = null;
			String destination = null;
			

			
			
			do {
				origin = InputHelper.getInput("Insert Origin: ");
				if(CityManager.isValid(origin)) {
					System.out.println("Valid origin");
					bean.setOrigin(origin);	
				}else {
					System.err.println("Invalid City");
				}
				
			}while(!CityManager.isValid(origin));
			
			do {
				destination = InputHelper.getInput("Insert Destination: ");
				if(CityManager.isValid(destination)) {
					System.out.println("Valid destination");
					bean.setDestination(destination);
					
				}else {
					System.err.println("Invalid City");
				}
				
			}while(!CityManager.isValid(destination));
			
			String routeName = CityManager.getAirportName(bean.getOrigin())+" - "+CityManager.getAirportName(bean.getDestination());
			bean.setName(routeName);	
		
			

			
			boolean result = RouteManager.addRoute(bean);
			if(result) {
				System.out.println("Route: "+bean.getName()+" was added succesfully");
			}else {
				System.err.println("No route was added");
			}
			
			opt = InputHelper.getInput("Do you want to continue adding routes? y/n ");
			while(!opt.equalsIgnoreCase("y") && !opt.equalsIgnoreCase("n")) {
				System.out.println("Please enter a valid input: y/n ");
				opt = InputHelper.getInput("Do you want to continue adding routes? y/n ");
			}
		}while(opt.equalsIgnoreCase("y"));
		
	}

}
