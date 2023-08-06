package test.practice;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;



public class Test01Tekrar {
    String token;
    // api/opdList endpoint'ine gecerli authorization bilgileri ile bir GET request gönderildiginde
    // dönen status code'un 200 oldugu ve response message bilgisinin "Success" oldugu dogrulanmali

    @Test
    public void test01(){

        // ilk is spec ile base url olusturulur

        RequestSpecification spec = new RequestSpecBuilder().setBaseUri("https://www.heallifehospital.com/").build();

        // taze token aldik (postman swagger dokumai) manual
        //String token = "FkPqyIBi7QCwu9vBlOGmdgFy8CDklv";
        String token = tokenCreate();

        spec.pathParams("pp1","api","pp2","opdList");

        String fullPath = "/{pp1}/{pp2}";

        // simdi send tusuna basmak islemi kaldi

        Response response = given()
                .contentType(ContentType.JSON)      // sana gönderdigim bilgiler Json formatinda demek
                .spec(spec)                         // ana Url budur
                .headers(                           // su yetki ile su dilde vs gonderiyoruz
                        "Authorization",            // bunlari yazmayinca bazen calismimayabiliyor
                        "Bearer "+token,            // Bearer   den sonra bosluk var
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON
                )
                .when()                             // yukarida ki pp1 ve pp2 yi ekledigim zaman gelen cevabi response'e kaydet
                .get(fullPath);

        response.prettyPrint();  // gozumuzle gorduk ki hersey calisiyor

        // dönen status code'un 200 oldugu ve response message bilgisinin "Success" oldugu dogrulanmali

        response.then()
                .assertThat()
                .statusCode(200)
                .body("message", Matchers.equalTo("Success"));

    }

    @Test
    public void test02(){
        // api/opdList endpoint'ine gecersiz authorization bilgileri ile bir GET Request gönderildiginde
        // dönen status code'un 403 oldugu ve response message bilgisinin "failed" oldugu dogrulanmali
        RequestSpecification spec = new RequestSpecBuilder().setBaseUri("https://www.heallifehospital.com/").build();

        String token = "asdaskfjaköldfalkdf";
        spec.pathParams("pp1","api","pp2","opdList");

        String fullPath = "/{pp1}/{pp2}";

        String exeptionMsj="";
        Response response = given()
                    .contentType(ContentType.JSON)
                    .spec(spec)
                    .headers(
                            "Authorization",
                            "Bearer " + token,
                            "Content-Type",
                            ContentType.JSON,
                            "Accept",
                            ContentType.JSON
                            )
                    .when()
                    .get(fullPath);
        response.prettyPrint();

        response.then()
                .assertThat()
                .statusCode(403)
                .body("message",Matchers.equalTo("failed"));


    }


    public String tokenCreate(){

        String url = "https://www.heallifehospital.com/api/getToken";

        JSONObject reqBody = new JSONObject();
        /*
        {
    "email": "hatice.kubra.ceylan.admin@heallifehospital.com",
    "password": "heallife123"
}
         */
        reqBody.put("email","hatice.kubra.ceylan.admin@heallifehospital.com");
        reqBody.put("password","heallife123");

        Response response = given()
                .contentType(ContentType.JSON)
                .headers(
                        "Accept",
                        ContentType.JSON
                )
                .when()
                .body(reqBody.toString())
                .post(url);
        response.prettyPrint();
        // response icinden token'i alabimek icin oncelikle respons'u JsonPath objesine cevirmeliyiz

        JsonPath jsonResponse = response.jsonPath();

        token = jsonResponse.getString("token");
        System.out.println(token);

        return token;
    }
}
