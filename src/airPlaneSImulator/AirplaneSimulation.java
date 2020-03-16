package airPlaneSImulator;

public class AirplaneSimulation {
	
	public static void main(String[] args) {
		Route route1 = new Route("Mexicali","Tijuana",10,500);
		Country Mexico = new Country("Mexico");
		
		/*Route route2 = new Route("Mexicali","Ensenada");
		Route route3 = new Route("Mexicali","Tecate");
		System.out.println(route1.getId());
		System.out.println(route1.getRouteName());
		System.out.println(route1.getCost());*/
		
		Mexico.addCity("Mexicali");
		System.out.println(Mexico.cityExists("mexicali"));

		
	}//main
}
