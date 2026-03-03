package session22;

public class EmployeePOJOClass {

	
	private String firstName;
	private String lastName;
	private String gender;
	private int age;
	private int salary;
	private addressPOJOClass address;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public addressPOJOClass getAddress() {
		return address;
	}
	public void setAddress(addressPOJOClass address) {
		this.address = address;
	}
	
	 
}
