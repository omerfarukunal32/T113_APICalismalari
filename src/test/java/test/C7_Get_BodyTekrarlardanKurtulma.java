package test;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C7_Get_BodyTekrarlardanKurtulma {
    /*
        https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request gonderdigimizde
        donen Response’un,
            status code’unun 200,
            ve content type’inin application-json,
            ve response body’sindeki
            "firstname“in, "Mark",
            ve "lastname“in, "Wilson",
            ve "totalprice“in, 432,
            ve "depositpaid“in, true,
            ve "additionalneeds“in, "Breakfast"
        oldugunu test edin
     */
    @Test
    public void get01(){
        // 1 - Url ve Request body hazirla
        String url = "https://restful-booker.herokuapp.com/booking/10";

        // 2- Expected Daa hazirla

        // 3 - Response'i hazirla

        Response response = given().when().get(url);

        response.prettyPrint();

        /*
        response.then().assertThat()
                .statusCode(200)
                .contentType("application-json")
                .body("firstname", Matchers.equalTo("Mark"),
                        "lastname",Matchers.equalTo("Wilson"),
                        "totalprice",Matchers.equalTo(432),
                        "depositpaid", Matchers.equalTo(true),
                        "additionalneeds",Matchers.equalTo("Breakfast"));
         */
        response.then().assertThat()
                .statusCode(200)
                .contentType("application-json")
                .body("firstname", equalTo("Mark"),
                        "lastname",equalTo("Wilson"),
                        "totalprice",equalTo(432),
                        "depositpaid", equalTo(true),
                        "additionalneeds",equalTo("Breakfast"));
    }
}
