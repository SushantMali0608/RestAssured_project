package session23;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import session22.EmployeePOJOClass;
import session22.addressPOJOClass;

public class DemoComplexNestedJsonObject {
	
	
	@Test
	public void createuser() throws JsonProcessingException {
		
		NestedJsonPOJOclass  nestedjson = new NestedJsonPOJOclass();
		
		nestedjson.setCompanyName("XYZ");
		nestedjson.setCity("abc");
		nestedjson.setState("pqrs");
		nestedjson.setPincode(12345);
		
		List <String> banks = new ArrayList<String>();
		banks.add("HDFC");
		banks.add("axis");
		banks.add("state");
		nestedjson.setBankacccount(banks);
		
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
		
		EmployeePOJOClass emp2 =new EmployeePOJOClass();
		
		emp2.setFirstName("Sourabh");
		emp2.setLastName("Mali");
		emp2.setGender("Male");
		emp2.setAge(21);
		emp2.setSalary(20000);

		address1.setStreet("str");
		address1.setState("pn");
		address1.setCity("bud");
		address1.setPincode(416306);
		
		emp2.setAddress(address1);
		
		EmployeePOJOClass emp3 =new EmployeePOJOClass();
		emp3.setFirstName("Sourabh");
		emp3.setLastName("patil");
		emp3.setGender("Male");
		emp3.setAge(21);
		emp3.setSalary(30000);

		address1.setStreet("ro");
		address1.setState("ga");
		address1.setCity("Sa");
		address1.setPincode(41622);
		
		List<EmployeePOJOClass> empinfo =new ArrayList<EmployeePOJOClass>();
		
		empinfo.add(emp1);
		empinfo.add(emp2);
		empinfo.add(emp3);
		nestedjson.setEmpinfo(empinfo);
		emp3.setAddress(address1);
		
		
		//convering class object into json payloadas string
		
		ObjectMapper objmapper = new ObjectMapper();
		
		String payload = objmapper.writerWithDefaultPrettyPrinter().writeValueAsString(nestedjson);
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>JSon PayLoad>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println(payload);
		
		
	//creating request
		RequestSpecification reqspec = RestAssured.given();
		reqspec.baseUri("http://httpbin.org/post");
		reqspec.contentType(ContentType.JSON);
		reqspec.body(nestedjson);

		//generating response
		Response response= reqspec.post();

		System.out.println("........Printing Response...........");
		response.prettyPrint();

		//validating response
		Assert.assertEquals(response.statusCode(),200,"Check for status code");
		
	}

}
