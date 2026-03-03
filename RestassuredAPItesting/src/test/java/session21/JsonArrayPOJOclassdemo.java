package session21;

import java.util.ArrayList;
import java.util.List;

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
import session20.Employee;

public class JsonArrayPOJOclassdemo {

	@Test

	public void createEmpJSONArray() throws JsonProcessingException {

		//creating 1st emp details
		Employee emp1 = new Employee();

		emp1.setFirstName("Sushant");
		emp1.setLastName("Mali");
		emp1.setGender("Male");
		emp1.setSalary(10000);
		emp1.setAge(11);

		//creating 2nst emp details
		Employee emp2 = new Employee();

		emp2.setFirstName("Sourabh");
		emp2.setLastName("Mali");
		emp2.setGender("Male");
		emp2.setSalary(20000);
		emp2.setAge(21);

		//creating 2nst emp details
		Employee emp3 = new Employee();

		emp3.setFirstName("Sourabh");
		emp3.setLastName("patil");
		emp3.setGender("Male");
		emp3.setSalary(30000);
		emp3.setAge(31);

		//Creating list to steor all emp info 
		List <Object> listofemp = new ArrayList<Object>();
		listofemp.add(emp1);
		listofemp.add(emp2);
		listofemp.add(emp3);

		// Converting employee data into JSON Payload

		ObjectMapper objmapper = new ObjectMapper();

		String Empdata = objmapper.writerWithDefaultPrettyPrinter().writeValueAsString(listofemp);
		System.out.println(".................createdDtata...............");
		System.out.println(Empdata);

		//creating request Specification

		RequestSpecification reqspec = RestAssured.given();

		reqspec.baseUri("http://httpbin.org/post");
		reqspec.contentType(ContentType.JSON);
		reqspec.body(Empdata);
		Response response =reqspec.post();
		System.out.println(".................printingrespnse body...............");
		response.prettyPrint();

		//asserting status code

		Assert.assertEquals(response.statusCode(),200,"chek for statuscode");
		
		

		//Converting JSON Payload data into employee class object(Desrialization)
		
		ResponseBody responsebody =response.getBody();
		
		JsonPath jsonpathview =responsebody.jsonPath();
		
		List<Employee> allemployee = jsonpathview.getList("json",Employee.class);
		
		System.out.println("......................Printting firstname.............");
		
		for(Employee emp:allemployee) {
			
			System.out.println(emp.getFirstName());
		}
		
		


	}

}
