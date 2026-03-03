package session17;

import java.util.Iterator;
import java.util.Map.Entry;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JSONObjectUsingJacksonAPI {

	@Test

	public void createuser() {

		//https://reqres.in/api/users
		/*{
		 * "FirstName":"Sushant",
		 * "LastName":"Mali",
		 * "age":27,
		 * "IsMarried":false,
		 * "Hobbies":["cricket","swimming","Games"],
		 * "Techskills":{
		 *             "Programmming language":"Java",
		 *             "Web Automation":"Selenium",
		 *             "API Testing":"RestAssured"
		 * }
		 * }*/
		//creating objectMapper
		ObjectMapper objectmaper = new ObjectMapper();
		//creating ObjectNode or Json Node

		ObjectNode userdetails = objectmaper.createObjectNode();

		userdetails.put("FirstName", "Sushant");
		userdetails.put("LastName", "Mali");
		userdetails.put("age", 27);
		userdetails.put("IsMarried", false);

		ObjectNode techskills = objectmaper.createObjectNode();
		techskills.put("Programmming language", "Sushant");
		techskills.put("Web Automation", "Web Automation");
		techskills.put("API Testing", "RestAssured");


		userdetails.set("Techskills", techskills);

		//Print UserdetailsJSON Object


		try {
			String Userdetailsasstring = objectmaper.writerWithDefaultPrettyPrinter().writeValueAsString(userdetails);

			System.out.println("Created JSON Node is :" +Userdetailsasstring);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		// retriving Field values 
		System.out.println("------------------------printing values-----------------------------------");
		String firstname = userdetails.get("FirstName").asText();
		System.out.println(firstname);
		String lastname = userdetails.get("LastName").asText();
		System.out.println(lastname);
		int age = userdetails.get("age").asInt();
		System.out.println(age);
		Boolean ismarried = userdetails.get("IsMarried").asBoolean();
		System.out.println(ismarried);
		String webautomation =userdetails.get("Techskills").get("Web Automation").asText();
		System.out.println(webautomation);

		//Printing all keys 

		System.out.println("------------------------printing keys -----------------------------------");

		Iterator<String> fieldnameIterator= userdetails.fieldNames();
		while(fieldnameIterator.hasNext()) {

			System.out.println(fieldnameIterator.next());
		}

		// Printing both value 	
		System.out.println("------------------------printing all values -----------------------------------");

		Iterator<JsonNode> fieldvalueIterator= userdetails.elements();
		while(fieldvalueIterator.hasNext()) {

			System.out.println(fieldvalueIterator.next());
		}
		//printing key value pairs
		System.out.println("------------------------printing key value pairs -----------------------------------");
		Iterator<Entry<String,JsonNode>> fieldentries= userdetails.fields();
		while(fieldentries.hasNext()) {

			Entry<String,JsonNode> node =fieldentries.next();
			System.out.println(node.getKey() +""+node.getValue());
		}

		//removing value from json object
		System.out.println("------------------------removing firstname -----------------------------------");

		String removedvalue =userdetails.remove("FirstName").asText();
		System.out.println(removedvalue);
		try {
			String Userdetailsasstring = objectmaper.writerWithDefaultPrettyPrinter().writeValueAsString(userdetails);

			System.out.println("Created JSON Node is :" +Userdetailsasstring);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//updating value from json object
		System.out.println("------------------------updating last name -----------------------------------");
				 userdetails.put("LastName", "patil");
				
				try {
					String Userdetailsasstring = objectmaper.writerWithDefaultPrettyPrinter().writeValueAsString(userdetails);

					System.out.println("Created JSON Node is :" +Userdetailsasstring);
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


	}
}
