package airPlaneSImulator;

public class Route {
	private String origin;
	private String destination;
	private String routeName;
	private int id; 
	private static int idCounter = 1; 
	private int cost = 0; 
	private int seatSpace=0;
	
	public Route(String origin, String destination, int seatSpace) {
		this.origin = origin;
		this.destination = destination;
		routeName = this.origin + " - " + this.destination;
		id = idCounter++;
		setSeatSpace(seatSpace);
	}
	
	public Route(String origin, String destination,int seatSpace, int cost) {
		this.origin = origin;
		this.destination = destination;
		routeName = this.origin + " - " + this.destination;
		id = idCounter++;
		setCost(cost);
		setSeatSpace(seatSpace);
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
	
	public void setPassangers(int passangers) {
		int seatSpace = this.getSeatSpace();
		if(seatSpace >= passangers) {
			this.seatSpace = this.seatSpace-passangers;
			System.out.println("Added "+passangers+" passengers to the route "+this.getRouteName());
			System.out.println("Remaining seats: "+ this.seatSpace);
		}else {
			System.out.println("Sorry there are not available seats to cover your requests");
		}
	}

}
