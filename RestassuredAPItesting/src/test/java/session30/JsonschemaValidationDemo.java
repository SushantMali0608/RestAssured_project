package session30;

import java.io.File;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

public class JsonschemaValidationDemo {
	
	@Test
	public void TestMethod() {
		
		String payload = "{\r\n"
				+ "\"username\":\"admin\",\r\n"
				+ "\"password\":\"password123\"\r\n"
				+ "}";
		
		RestAssured.given()
		.baseUri("https://restful-booker.herokuapp.com/auth")
		.contentType(ContentType.JSON)
		.body(payload)
		.when()
		.post()
		.then()
		.assertThat()
		.statusCode(200)
		.body("token",Matchers.notNullValue())
		//.body(JsonSchemaValidator.matchesJsonSchema(new File("C:\\Users\\Admin\\Desktop\\JsonSchema.json")));
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("JsonSchema.json"));
	}

}

