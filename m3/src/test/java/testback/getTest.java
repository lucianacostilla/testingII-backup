package testback;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class getTest {
    @Test
public void getTest1(){
        Response responseGet = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println(responseGet.getBody().asString());
        System.out.println(responseGet.statusCode());
        System.out.println(responseGet.getHeader("Date"));
        System.out.println(responseGet.getTime());
    }
    @Test
    public void getTest2(){
        Response responseGet1 = RestAssured.get("https://reqres.in/api/users?page=2");
        int statusCode = responseGet1.statusCode();
        JsonPath body = responseGet1.jsonPath();
        String nombre = body.getString("data.first_name[0]");
        String mail = body.getString("data.email[0]");
        Assert.assertEquals(statusCode, 200);
        Assert.assertEquals(nombre, "Michael");
        Assert.assertEquals(mail, "michael.lawson@reqres.in");
        System.out.println(statusCode);
    }
    @Test
    public void getTest3(){
        given().get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .log()
                .body();
    }
}
