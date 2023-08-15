package test.practice;

public class OrtakOrnekHasNap {
    /*
    Scenario: [API_US35-->TC03] Confirm the API-made visitor record. Use the addId from response in POST to 'api/visitorsId' to verify successful creation and retrieve details. This validates the creation status.

    Given User sets "api/visitorsAdd" path param.
    When I want to create a new Visitor record through API connection
    Given User sets "api/visitorsId" path param.
    Then Postrequest sent with "id" must have status: 200 and message: "Success"




@When("I want to create a new Visitor record through API connection")
    public void ıWantToCreateANewVisitorRecordThroughAPIConnection() {

 //   {
 //       "purpose": "Principal Meeting",
 //       "name": "Kenan",
 //       "contact": "9808678686112",
 //       "id_proof": "312121",
 //       "no_of_people": "16",
 //       "date": "2023-03-16",
 //       "in_time": "06:00 PM",
 //       "out_time": "06:30 PM",
 //       "note": "PTM meeting"
 //       }


    JSONObject reqBody = new JSONObject();

        reqBody.put("purpose", "Principal Meeting");
        reqBody.put("name", "Kenan");
        reqBody.put("contact", "9808678686112");
        reqBody.put("id_proof", "312121");
        reqBody.put("no_of_people", "16");
        reqBody.put("date", "2023-03-16");
        reqBody.put("in_time", "06:00 PM");
        reqBody.put("out_time", "06:30 PM");
        reqBody.put("note", "PTM meeting");

    response =  given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .headers("Authorization","Bearer " + token)
                .when()
                .body(reqBody.toString())
            .post(CommonAPI.fullPath);

        response.prettyPrint();

    HashMap<String,Object> resHM = response.as(HashMap.class);
        System.out.println(resHM.toString());

    addId = resHM.get("addId").toString();
        System.out.println(addId);

}

        @Then("Postrequest sent with {string} must have status: {int} and message: {string}")
    public void postrequestSentWithMustHaveStatusAndMessage(String id, int status, String message) {

        JSONObject reqBody = new JSONObject();

        reqBody.put(id,addId);

        response =  given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .headers("Authorization","Bearer " + token)
                .when()
                .body(reqBody.toString())
                .post(CommonAPI.fullPath);

        response.prettyPrint();

        String[] expectedArray = {"id", "purpose","name", "contact", "id_proof", "no_of_people", "date", "in_time", "out_time", "note"};

        JsonPath resJP = response.jsonPath();

        String actualData = resJP.get("lists").toString();
        System.out.println(actualData);
        resJP.prettyPrint();

        for (int i = 0; i < expectedArray.length; i++) {
            assertTrue(actualData.contains(expectedArray[i]));
        }
    }

     */


}
