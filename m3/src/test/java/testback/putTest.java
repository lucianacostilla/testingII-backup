package testback;

import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class putTest {
    @Test
    public void puttest1(){
        JsonObject bodyrequest = new JsonObject();
        bodyrequest.addProperty("name","Jongin");
        bodyrequest.addProperty("job", "modificado por RA");

        given()
                .contentType("application/json")
                .body(bodyrequest)
                .post("https://reqres.in/api/users/55")
                .then().statusCode(201)
                .log().status()
                .log().body();
    }
    public void sadpathput(){
        JsonObject request = new JsonObject();
        request.addProperty("name", "Junmyeon");

    }
}
