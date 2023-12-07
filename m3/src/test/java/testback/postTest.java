package testback;
import com.google.gson.JsonObject;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class postTest {
    @Test
    public void posthappypathtest(){
        JsonObject request = new JsonObject();
        request.addProperty("name","space");
        request.addProperty("job", "leader");
        given()
                .contentType("application/json")
                .body(request)
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201)
                .log()
                .body();
    }
    @Test
    public void postsadpathtest(){
        JsonObject request1 = new JsonObject();
        request1.addProperty("email", "space@space");
        //ES SUPER IMPORTANTE EL CONTENT TYPE! SINO SE ESPECIFICA QUE ES DE FORMATO JSON ENTONCES NADA FUNCIONA.
        Response responsepost = given()
                .contentType("application/json")
                .body(request1)
                .post("https://reqres.in/api/login");

        String error = responsepost.jsonPath().getString("error");
        Assert.assertEquals(400, responsepost.getStatusCode());
        Assert.assertEquals(error, "Missing password");
        System.out.println(responsepost.getBody().asString());
        System.out.println("El mensaje de error es: " + error);
        System.out.println("El número de error es: " + responsepost.statusCode());
        System.out.println("Se tardó en ejecutarse la prueba: " + responsepost.time() + " milisegundos.");

    }
}
