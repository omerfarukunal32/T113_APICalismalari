package test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C12_Odev1 {
    /*
    C13_Get_SoftAssertIleExpectedDataTesti
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
    gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.

    Response Body
    {
        "status": "success",
        "data": {
                "id": 3,
                "employee_name": "Ashton Cox",
                "employee_salary": 86000,
                "employee_age": 66,
                "profile_image": ""
    },
        "message": "Successfully! Record has been fetched."
    }
     */
    @Test
    public void get01(){
        // 1 - Url Hazirla
        String url = "http://dummy.restapiexample.com/api/v1/employee/3";

        // 2 - Expected Data hazirla
        JSONObject idData = new JSONObject();
        idData.put("id", 3);
        idData.put("employee_name", "Ashton Cox");
        idData.put("employee_salary", 86000);
        idData.put("employee_age", 66);
        idData.put("profile_image", "");

        JSONObject expData = new JSONObject();
        expData.put("message", "Successfully! Record has been fetched.");
        expData.put("status", "success");
        expData.put("data",idData);

        // 3 - Response'i hazirla
        Response response = given().when().get(url);
        response.prettyPrint();

        // 4 - Assertion

        JsonPath resJP = response.jsonPath();

        Assert.assertEquals(expData.get("status"),resJP.get("status"));
        Assert.assertEquals(expData.getJSONObject("data").get("id"),resJP.get("data.id"));
        Assert.assertEquals(expData.getJSONObject("data").get("employee_name"),resJP.get("data.employee_name"));
        Assert.assertEquals(expData.getJSONObject("data").get("employee_salary"),resJP.get("data.employee_salary"));
        Assert.assertEquals(expData.getJSONObject("data").get("employee_age"),resJP.get("data.employee_age"));
        Assert.assertEquals(expData.getJSONObject("data").get("profile_image"),resJP.get("data.profile_image"));
        Assert.assertEquals(expData.get("message"),resJP.get("message"));



    }
}
