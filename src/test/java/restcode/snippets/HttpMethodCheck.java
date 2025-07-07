package restcode.snippets;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
public class HttpMethodCheck {

 //  public static final String baseurl ="https://postman-rest-api-learner.glitch.me/";
   public static final String baseurl="https://datausa.io/api/data?drilldowns=Nation&measures=Population";

@Test
    public void testingApi() {
        RestAssured.baseURI= baseurl;
       // check get method
         getMethod(baseURI);
}

public void getMethod(String baseURI){
    try{
        /*method chaining in REST Assured*/
        Response response=given()
                .when()
                .get(baseURI)
                .then()
                .statusCode(200)
                .extract().response();
        System.out.println(response.getBody().asString());

        // Calling get method normal call
        Response countryresponse = RestAssured.given().request(Method.GET,"/all");
       System.out.println(countryresponse.getBody().asString());

        //Get country details with specific ID using Json Path to navigate to specific search
        List<String> county= response.jsonPath().getList("data.Nation");
        System.out.println(county);

    }catch (RuntimeException e){
        throw new RuntimeException(e);
    }
}

public void postMethod(String baseurl){

}
}
