package session20;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SeriallizationandDeseialization {
	
	@Test
	
	public void Serialiaztion() throws JsonProcessingException {
		
		Employee emp1 =new Employee();
		
		emp1.setFirstName("Sushant");
		emp1.setLastName("Mali");
		emp1.setGender("male");
		emp1.setAge(27);
		emp1.setSalary(10000.00);
		
		//converting this pojo object(emp1) into Json object() using jackson dependancy
		
		ObjectMapper objmapper = new ObjectMapper();
		String employeeJson = objmapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);
		
	System.out.println(employeeJson);
	
	RequestSpecification reqspec = RestAssured.given();
	
	   reqspec.baseUri("http://httpbin.org/post");
	   reqspec.contentType(ContentType.JSON);
	   reqspec.body(employeeJson);
	  Response response = reqspec.post();
	  
	  response.prettyPrint();
	  
	  Assert .assertEquals(response.statusCode(), 200, "Check for status code");
	  
	  //convert Json String(employeeJson) into Pojo class object(Employee)
	  
	  Employee emp2 = objmapper.readValue(employeeJson, Employee.class);
	  System.out.println("firstName :" +emp2.getFirstName());
	  System.out.println("LastName :" +emp2.getLastName());
	  System.out.println("age :" +emp2.getAge());
	  System.out.println("gender :" +emp2.getGender());
	  System.out.println("salary :" +emp2.getSalary());
	}

}
