package airPlaneSImulator;

import java.util.ArrayList;

public class Route {
	private String origin;
	private String destination;
	private String routeName;
	private int id; 
	private static int idCounter = 1; 
	private int cost = 0; 
	private int seatSpace=0;
	private ArrayList<Passenger> passengerList = new ArrayList<Passenger>();
	
	public Route(Country originCountry, Country destinationCountry, String originCity, String destinationCity, int seatSpace, int cost) {
		if(originCountry.cityExists(originCity) && originCountry.cityExists(destinationCity)){
			this.origin = originCity;
			this.destination =  destinationCity;
			routeName = this.origin + " - " + this.destination;
			id = idCounter++;
			setSeatSpace(seatSpace);
			setCost(cost);
		}else {
			throw new IllegalArgumentException("City doesn't exists");
		}
	}
	
	public String getRouteName(){
		return routeName;
	}
	
	public String getAllRoutes(){
		String foo = null;
		return foo;
	}

	public void setCost(int cost) {
		this.cost = cost; 
	}
	
	public int getCost() {
		return cost; 
	}
	public int getId() {
		return id;
	}
	
	public void setSeatSpace(int seatSpace) {
		this.seatSpace = seatSpace; 
	}
	
	public int getSeatSpace() {
		return this.seatSpace; 
	}
	
	public void addPassenger(Passenger passenger) {
		if(getSeatSpace() > 0) {
			passengerList.add(passenger);
			reduceSeat(1);
			System.out.println("Added passenger: "+passenger.getName()+" to the route "+this.getRouteName());
			System.out.println("Remaining available seats: "+this.getSeatSpace());
		}else {
			System.out.println("There are no seats available");
		}
	}
	
	public void removePassenger(Passenger passenger) {
		if(passengerList.contains(passenger)) {
			passengerList.remove(passenger);
			System.out.println("Passenger: "+passenger.getName()+" was removed succesfully");
			increaseSeat(1);
		}else {
			System.out.println("Passenger is not in this route");
		}
	}
	
	private void increaseSeat(int numberSeats) {
		seatSpace += numberSeats;
	}
	
	private void reduceSeat(int numberSeats) {
		seatSpace -= numberSeats;
	}

}
