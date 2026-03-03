package session26;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ignoringunknownproperties {

	
	@Test
	public void DemoDeserialization() throws JsonMappingException, JsonProcessingException {
		String Payload ="{\r\n"
				+ "  \"lastName\" : \"Mali\",\r\n"
				+ "  \"gender\" : \"male\",\r\n"
				+ "  \"age\" : 27,\r\n"
				+ "  \"salary\" : 10000,\r\n"
				+ "  \"isMarried\" : true,\r\n"
				+ "  \"firstname\" : \"Sushant\",\r\n"
				+ "  \"FullName\" : \"Sushant Mali\"\r\n"
				+ "}";


		//converting this pojo object(emp1) into Json object() using jackson dependancy

		ObjectMapper objmapper = new ObjectMapper();
		//using configure to ignore unknown properties
		objmapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		EmployeePojo emp2 = objmapper.readValue(Payload, EmployeePojo.class);

		System.out.println("............................Deserializtion...................................");
		System.out.println("FirstName:" +emp2.getfirstname());
		System.out.println("lastnameName:" +emp2.getlastName());
		System.out.println("age:" +emp2.getAge());
		System.out.println("gender:" +emp2.getGender());
		System.out.println("salary :" +emp2.getSalary());
		System.out.println("Ismarried :"+ emp2.getisMarried());
	}
}

