package requests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Test_PutMethod {

	@SuppressWarnings("unchecked")
	@Test
	public void Test04() {

        JSONObject data = new JSONObject();
        data.put("year", 2000);
        data.put("price", 1849.99);
        data.put("CPU model", "Intel Core");
        data.put("Hard disk size", "1 GB");

        JSONObject product = new JSONObject();
        product.put("name", "Apple MacBook Pro 17");
        product.put("data", data);

        RestAssured.baseURI = "https://api.restful-api.dev/objects/ff8081819782e69e019ba4086474033e";

        RestAssured
            .given()
                .contentType(ContentType.JSON)
                .body(product.toJSONString())
            .when()
                .put()
            .then()
                .statusCode(200)   // API returns 200 OK
                .log().all();
    }
}

