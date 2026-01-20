package requests;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Test_PostMethod {
    
	@SuppressWarnings("unchecked")
	@Test
    public void Test03() {

        JSONObject data = new JSONObject();
        data.put("year", 2019);
        data.put("price", 1849.99);
        data.put("CPU model", "Intel Core i9");
        data.put("Hard disk size", "1 TB");

        JSONObject product = new JSONObject();
        product.put("name", "Apple MacBook Pro 16");
        product.put("data", data);

        RestAssured.baseURI = "https://api.restful-api.dev/objects";

        RestAssured
            .given()
                .contentType(ContentType.JSON)
                .body(product.toJSONString())
            .when()
                .post()
            .then()
                .statusCode(200)   // API returns 200 OK
                .log().all();
    }
}