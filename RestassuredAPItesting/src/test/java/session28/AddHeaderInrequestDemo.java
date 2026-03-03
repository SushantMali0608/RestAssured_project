package session28;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AddHeaderInrequestDemo {


	@Test(enabled=false)
	public void test1() {


		RequestSpecification reqspec = RestAssured.given();
		//add Header
		reqspec.header("header1","Value1");
		reqspec.log().headers();

		//specify url 
		reqspec.baseUri("https://httpbin.org/get");
		reqspec.get();

	}

	@Test(enabled =false)
	public void test2() {


		Map <String,String> headers = new HashMap<String,String>();
		headers.put("header1", "value1");
		headers.put("header2", "value2");

		RequestSpecification reqspec = RestAssured.given();
		//add Header
		reqspec.headers(headers);
		reqspec.log().headers();



		//specify url 
		reqspec.baseUri("https://httpbin.org/get");
		reqspec.get();

	}
	@Test(enabled =false)
	public void test3() {


		Header headerobj =new Header("header1","Value1");

		RequestSpecification reqspec = RestAssured.given();
		//add Header
		reqspec.header(headerobj);
		reqspec.log().headers();

		//specify url 
		reqspec.baseUri("https://httpbin.org/get");
		reqspec.get();

	}
	@Test
	public void test4() {
		Header headerobj1 =new Header("header1","Value1");
		Header headerobj2 =new Header("header2","Value2");
		Header headerobj3 =new Header("header3","Value3");

		List<Header> headerlist =new ArrayList<>();
		headerlist.add(headerobj1);
		headerlist.add(headerobj2);
		headerlist.add(headerobj3);

		Headers headerobj =new Headers (headerlist);
		RequestSpecification reqspec = RestAssured.given();
		//add Header
		reqspec.headers(headerobj);
		reqspec.log().headers();

		//specify url 
		reqspec.baseUri("https://httpbin.org/get");
		Response response =reqspec.get();
		
		response.prettyPrint();
		
		Assert.assertEquals(response.statusCode(),200,"Check for status code");

		
		
	}

}
