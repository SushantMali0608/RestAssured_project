package session25;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class IgnoreobjectsDemo {

	
	@Test
	public void createuser() throws JsonProcessingException {
	EmployeePOJODemo emp1 =new EmployeePOJODemo();
		
		emp1.setfirstname("Sushant");
		emp1.setlastName("Mali");
		emp1.setGender("male");
		emp1.setAge(27);
		emp1.setSalary(10000);
		emp1.setMarried(true);
		
		//converting this pojo object(emp1) into Json object() using jackson dependancy
		
		ObjectMapper objmapper = new ObjectMapper();
		String employeeJson = objmapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);
		
	System.out.println(employeeJson);
	
	//(Deserialization)converting this json object(emp1) into class object() using jackson dependancy
	
	EmployeePOJODemo emp2 = objmapper.readValue(employeeJson, EmployeePOJODemo.class);
	
	System.out.println("............................Deserializtion...................................");
	System.out.println("FirstName:" +emp2.getfirstname());
	System.out.println("lastnameName:" +emp2.getlastName());
	System.out.println("age:" +emp2.getAge());
	System.out.println("gender:" +emp2.getGender());
	System.out.println("salary :" +emp2.getSalary());
	System.out.println("Ismarried :"+ emp2.getisMarried());
}
}
