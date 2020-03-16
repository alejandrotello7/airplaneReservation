package airPlaneSImulator;
import java.time.LocalDate;
import java.time.Period;

public class Passenger {
	
	private String fName;
	private String lName;
	private LocalDate birthDate;
	private LocalDate currentDate = LocalDate.now();
	private String nationality; 
	
	public Passenger(String fName, String lName, int year, int month, int day, String nationality) {
		this.fName = fName;
		this.lName = lName;
		this.birthDate = getBirthDate(year, month, day);
		this.nationality = nationality; 
	}
	
	public String getName() {
		return this.fName+" "+this.lName;
	}
	
	public int getAge() {
		return Period.between(birthDate, currentDate).getYears();
	}
	
	public String getNationality() {
		return this.nationality;
	}
	
	private LocalDate getBirthDate(int year, int month, int day) {
		LocalDate birthDate = LocalDate.of(year, month, day);
		return birthDate;
	}

}
