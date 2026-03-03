package session24;

import com.fasterxml.jackson.annotation.JsonInclude;
// to ignore default values
//@JsonInclude(JsonInclude.Include.NON_DEFAULT)

//to ignore null values values
//@JsonInclude(JsonInclude.Include.NON_NULL)

//to ignore empty and null values
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class employeePOJO {

	
	private String firstName;
	private String lastName;
	private String gender;
	private int age;
	private int salary;
	private boolean isMarried;
	
	//creating getter and setters
	
	public String getfirstname() {
		return firstName;
	}
	
	public void setfirstname(String firstName ) {
		this.firstName =firstName;
	}
	
	public String getlastName() {
		return lastName;
		
	}
	
	public void setlastName(String lastName) {
		this.lastName =lastName;
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

	public void setSalary(int d) {
		this.salary = d;
	}

	public boolean isMarried() {
		return isMarried;
	}

	public void setMarried(boolean isMarried) {
		this.isMarried = isMarried;
	}
	
}
