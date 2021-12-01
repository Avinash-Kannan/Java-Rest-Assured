import io.restassured.RestAssured;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserLogin {

    @Test
    public void register(){
        RestAssured.baseURI = "http://localhost:3000";
        given().body("{\"email\":\"abc@avi\",\"password\":\"abc123\"}")
                .header("Content-Type","application/json" ).when().post("/rest/user/login")
                .then().log().all().statusCode(200);
    }
}
