package beans;

import java.time.LocalDate;


public class Passenger {
	private String firstName;
	private String middleName;
	private String lastName;
	private String nationality;
	private String cellphone;
	private String email;
	private LocalDate birthDate;
	private int id;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(int year, int month, int day) {
		this.birthDate =  LocalDate.of(year, month, day);
		//ZoneId defaultZoneId = ZoneId.systemDefault();
		//this.birthDate =  (Date) Date.from(temp.atStartOfDay(defaultZoneId).toInstant());
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
