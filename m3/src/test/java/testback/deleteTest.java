package testback;

import io.restassured.response.Response;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class deleteTest {
    @Test
    public void deletetest(){
            Response response = given()
                   .delete("https://reqres.in/api/users/15");
            Assert.assertEquals(response.statusCode(), 204);
    }
}
