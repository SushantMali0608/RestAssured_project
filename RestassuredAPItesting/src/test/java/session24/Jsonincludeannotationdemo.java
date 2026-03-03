package session24;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Jsonincludeannotationdemo {
	
	@Test
	public void createuser() throws JsonProcessingException {
		
	employeePOJO emp1 =new employeePOJO();
	
	emp1.setfirstname("Sushant");
	emp1.setlastName("Mali");
	emp1.setGender("male");
	//emp1.setAge(27);
	emp1.setSalary(10000);
	
	//converting this pojo object(emp1) into Json object() using jackson dependancy
	
	ObjectMapper objmapper = new ObjectMapper();
	String employeeJson = objmapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);
	
System.out.println(employeeJson);
	}

}
