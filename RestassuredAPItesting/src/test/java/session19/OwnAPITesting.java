package session19;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class OwnAPITesting {


	@BeforeClass
	public void setpdefaultdata() {

		RequestSpecification reqspec = RestAssured.given();

		reqspec.baseUri("http://localhost:3000");
		reqspec.basePath("/users");

		RestAssured.requestSpecification= reqspec ;
	}
	@Test
	public void readUserdata() {

		Response response = RestAssured.get();

		response.prettyPrint();

		Assert.assertEquals(response.statusCode(), 200,"check for status code");
	}

	@Test(enabled=false)
	public void Createuserdata(){


		JSONObject jsonobject = new JSONObject();
		jsonobject.put("firstName", "sunita");
		jsonobject.put("age",42);

		Response response = RestAssured.given().header("ContentType","application/json").contentType(ContentType.JSON).body(jsonobject.toJSONString()).post();
		response.prettyPrint();

		Assert.assertEquals(response.statusCode(), 201,"check for status code");
	}

	@Test
	public void Updateuserdata() {


		JSONObject jsonobject = new JSONObject();
		jsonobject.put("firstName", "sunita");
		jsonobject.put("age",57);

		Response response = RestAssured.given().header("ContentType","application/json").contentType(ContentType.JSON).body(jsonobject.toJSONString()).put("/cdaa");
		response.prettyPrint();

		Assert.assertEquals(response.statusCode(), 200,"check for status code");
	}

	@Test(dependsOnMethods="Updateuserdata")
	public void Deleteuserdata() {

        Response response = RestAssured.given().delete("/cdaa");
		response.prettyPrint();

		Assert.assertEquals(response.statusCode(), 200,"check for status code");
	}
}

