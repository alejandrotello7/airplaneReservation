package airPlaneSImulator;
import java.util.ArrayList;

public class Country {
	
	private String name;
	private ArrayList<String> citiesList = new ArrayList<String>();
	
	public Country(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void addCity(String city) {
		citiesList.add(city.toUpperCase());
	}
	
	public boolean cityExists(String city) {;
		return citiesList.contains(city.toUpperCase());
	}
	
	public boolean isEmpty() {
		return citiesList.isEmpty();
	}
	
	

}
