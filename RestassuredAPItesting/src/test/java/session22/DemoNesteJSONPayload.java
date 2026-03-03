package session22;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class DemoNesteJSONPayload {

	@Test

	public void createuser() throws JsonProcessingException {

		EmployeePOJOClass emp1 =new EmployeePOJOClass();

		emp1.setFirstName("Sushant");
		emp1.setLastName("Mali");
		emp1.setGender("Male");
		emp1.setAge(27);
		emp1.setSalary(10000);

		addressPOJOClass address1 = new addressPOJOClass();
		address1.setStreet("street");
		address1.setState("MH");
		address1.setCity("Sangli");
		address1.setPincode(416416);


		emp1.setAddress(address1);

		//converting class objects into JSon Payload (Serialization)

		ObjectMapper objmapper = new ObjectMapper();

		String employeeinfo =objmapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);

		System.out.println("........Printing Payload...........");
		System.out.println(employeeinfo);

		//creating request specification

		RequestSpecification reqspec = RestAssured.given();
		reqspec.baseUri("http://httpbin.org/post");
		reqspec.contentType(ContentType.JSON);
		reqspec.body(employeeinfo);

		//generating response
		Response response= reqspec.post();

		System.out.println("........Printing Response...........");
		response.prettyPrint();

		//validating response
		Assert.assertEquals(response.statusCode(),200,"Check for status code");

		//converting JSON Payload into Class Object variable
		ResponseBody responsebody =response.getBody();

		JsonPath jsonpathview =responsebody.jsonPath();
		EmployeePOJOClass employeepojo = jsonpathview.getObject("json",EmployeePOJOClass.class);
		System.out.println(">>>>>>>>>>>>Getting Employee keys and values<<<<<<<<<<<<<<<<");
		System.out.println("FirstName:"+employeepojo.getFirstName());
		System.out.println("FlastName:"+employeepojo.getLastName());
		System.out.println("Gender:"+employeepojo.getGender());
		System.out.println("age:"+employeepojo.getAge());
		System.out.println("salary:"+employeepojo.getSalary());
		System.out.println("City:"+employeepojo.getAddress().getCity());
		System.out.println("pincode:"+employeepojo.getAddress().getPincode());
		System.out.println("state:"+employeepojo.getAddress().getState());
		System.out.println("street:"+employeepojo.getAddress().getStreet());
		
	
		
		
		








	}

}
