package session20;

public class Employee {
	
	/*
	 * FirstName - String
	 * LastName-String
	 * age -int
	 * gender -String
	 * salary -double*/
	
	private String FirstName;
	private String LastName;
	private int age;
	private String gender;
	private double salary;
	
	
	//creating getter and setter
	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public String getFirstName() {
		return FirstName;
		
	}
	
	public void setFirstName(String FirstName) {
		
		this.FirstName =FirstName;
	}
	
	

}
