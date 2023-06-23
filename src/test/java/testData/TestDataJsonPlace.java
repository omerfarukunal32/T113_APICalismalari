package testData;

import org.json.JSONObject;

public class TestDataJsonPlace {

    public int basariliStatusCode = 200;
    public String contentType = "application/json; charset=utf-8";
    public String conectionHeaderDegeri = "keep-alive";


    public JSONObject expectedBodyOlusturJSON(){
        JSONObject expData = new JSONObject();

        expData.put("userId", 3);
        expData.put("id", 22);
        expData.put("title", "dolor sint quo a velit explicabo quia nam");
        expData.put("body", "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        return expData;
    }

    public JSONObject requestBodyOlusturJSON(){
        JSONObject reqBody = new JSONObject();
        reqBody.put("title","Ahmet");
        reqBody.put("body","Merhaba");
        reqBody.put("userId",10);
        reqBody.put("id",70);

        return reqBody;
    }


}
