package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C12_Odev2 {
    /*
        C14_Put_SoftAssertIleExpectedDataTesti
        http://dummy.restapiexample.com/api/v1/update/21 url’ine asagidaki body’ye sahip bir PUT
        request gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
        Request Body
        {
            "status": "success",
            "data": {
                "name": “Ahmet",
                "salary": "1230",
                "age": "44",
                "id": 40
            }
        }
        Response Body
        {
            "status": "success",
            "data": {
                "status": "success",
                "data": {
                    "name": “Ahmet",
                    "salary": "1230",
                    "age": "44",
                    "id": 40
                }
            },
            "message": "Successfully! Record has been updated."
        }
     */
    @Test
    public void put01(){
        // 1- Url ve Body hazirla
        String url = "https://dummy.restapiexample.com/api/v1/update/21";
        JSONObject data = new JSONObject();
        data.put("name","Ahmet");
        data.put("salary","1230");
        data.put("age","44");
        data.put("id",40);

        JSONObject reqBody = new JSONObject();
        reqBody.put("status","success");
        reqBody.put("data",data);

        // 2 - Expexted Data Hazirla
        JSONObject expData = new JSONObject();
        expData.put("status", "success");
        expData.put("message", "Successfully! Record has been updated.");
        expData.put("data",reqBody);

        // 3 - Response hazirla
        Response response = given()
                                .contentType(ContentType.JSON)
                            .when()
                                .body(reqBody.toString())
                                .put(url);
        response.prettyPrint();
        // 4 - Assertion
        JsonPath respJP = response.jsonPath();

        Assert.assertEquals(expData.get("status"),respJP.get("status"));
        Assert.assertEquals(expData.getJSONObject("data").get("status"),respJP.get("data.status"));
        Assert.assertEquals(expData.getJSONObject("data").getJSONObject("data").get("name"),respJP.get("data.data.name"));
        Assert.assertEquals(expData.getJSONObject("data").getJSONObject("data").get("salary"),respJP.get("data.data.salary"));
        Assert.assertEquals(expData.getJSONObject("data").getJSONObject("data").get("age"),respJP.get("data.data.age"));
        Assert.assertEquals(expData.getJSONObject("data").getJSONObject("data").get("id"),respJP.get("data.data.id"));
        Assert.assertEquals(expData.get("message"),respJP.get("message"));


    }
}
