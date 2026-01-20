package Session4;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class ValidateResponseBody {
	
	
	@Test
	
	public void getuserbodyresponse() 
	{
		
       RequestSpecification requestspecification = RestAssured.given();
       
       requestspecification.baseUri("https://api.restful-api.dev");
       requestspecification.basePath("/objects/7");
       
       Response response = requestspecification.get();
       
       ResponseBody responsebody =response.getBody();
       
       String responseString = responsebody.asString();
       
       System.out.println(responseString);
       
       //validation year fromwhose response
       
       //Assert.assertEquals("year Missmatch",responseString.contains("2017"),true);
       
       //Finding jsonpath view ofresponse body
       
       JsonPath jsonview =responsebody.jsonPath();
       
       int year= jsonview.get("data.year");	
       
       Assert.assertEquals("Mismatch year", 2019, year);
       
       System.out.println("json path" + jsonview.get("data[\"Hard disk size\"]"));
       
	}

}
