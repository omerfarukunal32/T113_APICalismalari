package test;

import io.restassured.internal.RestAssuredResponseImpl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C11_Get_ExpectedDataOlusturma {

    /*
            https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET request
            yolladigimizda donen response body’sinin asagida verilen ile ayni oldugunu test
            ediniz
                        Response body :
                        {
                        "userId": 3,
                        "id": 22,
                        "title": "dolor sint quo a velit explicabo quia nam",
                        "body": "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
                        }
     */

    @Test
    public void get01(){
        // 1 -Url hazirla
        String url = "https://jsonplaceholder.typicode.com/posts/22";

        // 2 - Expected Data hazirla
        JSONObject expData = new JSONObject();

        expData.put("userId", 3);
        expData.put("id", 22);
        expData.put("title", "dolor sint quo a velit explicabo quia nam");
        expData.put("body", "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        System.out.println("expData : "+expData); // Java ile burada olusturdugum bir obje

        // 3 - Response'i hazirla
        Response response = given().when().get(url);
        response.prettyPrint(); // response ise API ile alakali olan kisimdir. prettyPrint response da kullanilir
        response.prettyPeek(); //  pretttyPrint'den farkli olarak size response ile ilgili tum degerleri dondurur

        // 4 - Assertion

        // Donen Response'i yorumlayabilmek icin JsonPath 'e dondurmem gerekiyor.
        JsonPath resJP = response.jsonPath();
        Assert.assertEquals(expData.get("userId"),resJP.get("userId"));
        Assert.assertEquals(expData.get("id"),resJP.get("id"));
        Assert.assertEquals(expData.get("title"),resJP.get("title"));
        Assert.assertEquals(expData.get("body"),resJP.get("body"));


    }

}
