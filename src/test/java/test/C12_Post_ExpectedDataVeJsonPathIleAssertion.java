package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C12_Post_ExpectedDataVeJsonPathIleAssertion {
    /*
    https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip bir POST
         request gonderdigimizde donen response’un id haric asagidaki gibi oldugunu test edin.
         POST REQUEST, RESPONSE BODY BILGILERINI
         ASSERT YAPARKEN JSONPATH KULLANMA

         Request body
         {
         "firstname" : "Ahmet",
         "lastname" : “Bulut",
         "totalprice" : 500,
         "depositpaid" : false,
         "bookingdates" : {
                "checkin" : "2021-06-01",
                "checkout" : "2021-06-10"
         },
         "additionalneeds" : "wi-fi"
         }

         Response Body
         {
         "bookingid": 24,
         "booking": {
                "firstname": "Ahmet",
                "lastname": "Bulut",
                "totalprice": 500,
                "depositpaid": false,
                "bookingdates": {
                        "checkin": "2021-06-01",
                        "checkout": "2021-06-10"
                            },
                "additionalneeds": "wi-fi"
                }
         }
     */
    @Test
    public void post01(){
        // 1 - Url ve body hazirla
        String url = "https://restful-booker.herokuapp.com/booking";

        JSONObject boogingdates = new JSONObject();
        boogingdates.put("checkin" , "2021-06-01");
        boogingdates.put("checkout" , "2021-06-10");

        JSONObject reqBody = new JSONObject();

        reqBody.put("firstname" , "Ahmet");
        reqBody.put("lastname" , "Bulut");
        reqBody.put("totalprice" , 500);
        reqBody.put("depositpaid" , false);
        reqBody.put("additionalneeds" , "wi-fi");
        reqBody.put("bookingdates" , boogingdates);

        // 2 - Expected Data hazirla

        JSONObject expData = new JSONObject();

        expData.put("bookingid",24);
        expData.put("booking",reqBody);

        // 3 - Response'u kaydet
        Response response = given()
                                .contentType(ContentType.JSON)
                            .when()
                                .body(reqBody.toString())
                                .post(url);
        response.prettyPrint();

        // 4 - Assertion

        JsonPath respJp = response.jsonPath();

        // JsonPath'te .(noktalar) ile ilerliyoruz, JSONObject te tek tek her bir katman icin cagiriyoruz(or. array)
        // Response bize sadece JsonPath donduruyor.
        Assert.assertEquals(expData.getJSONObject("booking").get("firstname"),respJp.get("booking.firstname"));
        Assert.assertEquals(expData.getJSONObject("booking").get("lastname"),respJp.get("booking.lastname"));
        Assert.assertEquals(expData.getJSONObject("booking").get("totalprice"),respJp.get("booking.totalprice"));
        Assert.assertEquals(expData.getJSONObject("booking").get("depositpaid"),respJp.get("booking.depositpaid"));
        Assert.assertEquals(expData.getJSONObject("booking").get("additionalneeds"),respJp.get("booking.additionalneeds"));
        Assert.assertEquals(expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),respJp.get("booking.bookingdates.checkin"));
        Assert.assertEquals(expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),respJp.get("booking.bookingdates.checkout"));








    }


}
