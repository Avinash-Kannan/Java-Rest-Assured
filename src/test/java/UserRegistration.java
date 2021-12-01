import com.google.gson.Gson;
import io.restassured.RestAssured;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class UserRegistration {

   // ("{\"email\":\"abc@kavi\",\"password\":\"abc123\",\"passwordRepeat\":\"abc123\",\"securityQuestion\":{\"id\":2,\"question\":\"Mother's maiden name?\",\"createdAt\":\"2021-11-30T06:04:17.177Z\",\"updatedAt\":\"2021-11-30T06:04:17.177Z\"},\"securityAnswer\":\"def\"}")
    @Test
    public void register(){
        RestAssured.baseURI = "http://localhost:3000";
        Gson gson=new Gson();
        given().body(gson.toJson(userDetailsBuilder()))
                .header("Content-Type","application/json" ).when().post("/api/users")
                .then().log().all().statusCode(201);
    }

    private UserDetails userDetailsBuilder(){
        return UserDetails.builder()
                .email("abc@kaviii").password("abc123").passwordRepeat("abc123")
                .securityQuestion(SecurityQuestion.builder()
                        .id(2).question("Mother's maiden name?")
                        .createdAt("2021-11-30T06:04:17.177Z")
                        .updatedAt("2021-11-30T06:04:17.177Z").build())
                .securityAnswer("def").build();
    }
}
