package airPlaneSImulator;



public class AirplaneSimulation {
	
	public static void main(String[] args) {
		Route route1 = new Route("Mexicali","Tijuana",1,500);
		Country Mexico = new Country("Mexico");
		Passenger alejandro = new Passenger("Alejandro", "Tello", 1994, 7, 17, "Mexican");
		Passenger andrea = new Passenger("Andrea", "Tello", 1993, 2, 13, "Mexican");

		Mexico.addCity("Mexicali");
		route1.addPassenger(alejandro);
		route1.addPassenger(andrea);
		route1.removePassenger(alejandro);
		route1.removePassenger(andrea);
		System.out.println(route1.getSeatSpace());

		 


		
	}//main
}
