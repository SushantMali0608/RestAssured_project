package session18;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FileuploadDemo {


	@Test(enabled=false)
	public void fileupload() {


		//https://httpbin.org/post
		File testfileupload = new File("C:\\Users\\Admin\\Desktop\\Selenium.txt");
		File testfileupload2 = new File("C:\\Users\\Admin\\Desktop\\Addition.txt");

		RequestSpecification requestspec = RestAssured.given();
		requestspec.baseUri("https://httpbin.org/post").
		multiPart("Files",testfileupload).
		multiPart("Files",testfileupload2).
		contentType("multipart/form-data");

		Response response =requestspec.post();
		response.prettyPrint();

		Assert.assertEquals(response.statusCode(), 200,"Vaidating status code");

	}

	@Test
	public void Imageupload() {


		//https://petstore.swagger.io/v2/pet/1/uploadImage
		File testfileupload = new File("C:\\Users\\Admin\\Downloads\\Application-error.JPG");

		RequestSpecification requestspec = RestAssured.given();
		requestspec.baseUri("https://petstore.swagger.io/v2/pet/1/uploadImage").
		multiPart("File",testfileupload).
		contentType("multipart/form-data");

		Response response =requestspec.post();
		response.prettyPrint();

		Assert.assertEquals(response.statusCode(), 200,"Vaidating status code");

	}
}
