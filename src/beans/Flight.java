package beans;

import java.time.LocalDate;

public class Flight {
	private int id;
	private String route;
	private int capacity;
	private int availableSeats;
	private LocalDate departureDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
		this.setAvailableSeats(capacity);
	}
	
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	
	public LocalDate getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(int year, int month, int day) {
		this.departureDate = LocalDate.of(year, month, day);
	}
	
	public void addPassenger() {
		this.availableSeats -= 1;
	}
	
	public void removePassenger() {
		this.availableSeats += 1;
	}
	
	public boolean hasAvailableSeats() {
		if(this.getAvailableSeats() >= 1) {
			return true;
		}
		return false;
	}
	
}
