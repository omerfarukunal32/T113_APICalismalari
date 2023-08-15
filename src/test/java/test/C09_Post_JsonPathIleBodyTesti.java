package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class C09_Post_JsonPathIleBodyTesti {
    /*
        https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip bir POST
        request gonderdigimizde
                    {
                    "firstname" : "Ali",
                    "lastname" : “Bak",
                    "totalprice" : 500,
                    "depositpaid" : false,
                    "bookingdates" : {
                                    "checkin" : "2021-06-01",
                                    "checkout" : "2021-06-10"
                                    },
                     "additionalneeds" : "wi-fi"
                     }
          donen Response’un,
                    status code’unun 200,
                    ve content type’inin application/json; charset=utf-8,
                    ve response body’sindeki
                        "firstname“in,"Ahmet",
                        ve "lastname“in, "Bulut",
                        ve "totalprice“in,500,
                        ve "depositpaid“in,true,
                        ve "checkin" tarihinin 2021-06-01
                        ve "checkout" tarihinin 2021-06-10
                        ve "additionalneeds“in,"wi-fi"
        oldugunu test edin
     */

    @Test
    public void post01(){
        // 1 - Url ve Request body hayirla
        String url = "https://restful-booker.herokuapp.com/booking";

        JSONObject bookingDates = new JSONObject();
        bookingDates.put("checkin" , "2021-06-01");
        bookingDates.put("checkout" , "2021-06-10");

        JSONObject reqBody = new JSONObject();
        reqBody.put("firstname" , "Ali");
        reqBody.put("lastname" , "Bak");
        reqBody.put("totalprice" , "500");
        reqBody.put("depositpaid" , "false");
        reqBody.put("additionalneeds" , "wi-fi");
        reqBody.put("bookingdates" , bookingDates);

        // 2 - Expected Data hazirla

        // 3 - Response'i kaydet

        Response response = given().contentType(ContentType.JSON)
                            .when()
                                    .body(reqBody.toString())
                                    .post(url);
        response.prettyPrint();
        // 4 - Assertion
        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .body("booking.firstname", equalTo("Ali"),
                        "booking.lastname", equalTo("Bak"),
                        "booking.totalprice", equalTo(500),
                        "booking.depositpaid", equalTo(true),
                        "booking.additionalneeds", equalTo("wi-fi"),
                        "booking.bookingdates.checkin",equalTo("2021-06-01"),
                        "booking.bookingdates.checkout",equalTo("2021-06-10")
                );

    }
}

/*
.body("lists.id",Matchers.equalTo("1"),
                        "lists.book_title",Matchers.equalTo("Multiplication and Division Grades 3-4 23456"),
                        "lists.book_no",Matchers.equalTo("788789"),
                        "lists.isbn_no",Matchers.equalTo(""),
                        "lists.subject",Matchers.equalTo(""),
                        "lists.rack_no",Matchers.equalTo("110"),
                        "lists.publish",Matchers.equalTo("Barbara Bando"),
                        "lists.author",Matchers.equalTo("Barbara Bando"),
                        "lists.qty",Matchers.equalTo("100"),
                        "lists.perunitcost",Matchers.equalTo("12.00"),
                        "lists.postdate",Matchers.equalTo("2022-05-04"),
                        "lists.description",Matchers.equalTo(" The duo dump her in a nearby river after a failed attempt to hang her. Tonya survives, and the two men are arrested by Sheriff Ozzie Walls."),
                        "lists.available",Matchers.equalTo("yes"),
                        "lists.is_active",Matchers.equalTo("no"),
                        "lists.created_at",Matchers.equalTo("2023-08-10 06:52:41"),
                        "lists.updated_at",Matchers.equalTo("null")
                );
 */
