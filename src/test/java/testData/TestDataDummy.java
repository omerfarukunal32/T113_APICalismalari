package testData;

import org.json.JSONObject;

import java.util.HashMap;

public class TestDataDummy {
    public int basariliStatusCode = 200;
    public String contentType = "application/json";
    /*
    {
    "status":"success",
    "data":{
            "id":3,
            "employee_name":"Ashton Cox",
            "employee_salary":86000,
            "employee_age":66,
            "profile_image":""
            },
    "message":"Successfully! Record has been fetched."
    }
     */
    public HashMap dataBodyOlusturMap(){

        HashMap<String,Object> data = new HashMap<>();

        data.put("id",3);
        data.put("employee_name","Ashton Cox");
        data.put("employee_salary",86000);
        data.put("employee_age",66);
        data.put("profile_image","");

        return data;
    }
    public HashMap expectedBodyOlusturMap(){
        HashMap<String,Object> expData = new HashMap<>();
        expData.put("status","success");
        expData.put("data",dataBodyOlusturMap());
        expData.put("message","Successfully! Record has been fetched.");

        return expData;
    }

    public JSONObject innerJSONBody(){
        JSONObject innerBody = new JSONObject();

        innerBody.put("id",3);
        innerBody.put("employee_name","Ashton Cox");
        innerBody.put("employee_salary",86000);
        innerBody.put("employee_age",66);
        innerBody.put("profile_image","");

        return innerBody;
    }
    public JSONObject expectedBodyOlusturJson(){
        JSONObject expBody = new JSONObject();

        expBody.put("status","success");
        expBody.put("data",innerJSONBody());
        expBody.put("message","Successfully! Record has been fetched.");

        return expBody;
    }


}
