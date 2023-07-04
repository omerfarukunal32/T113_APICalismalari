package test;

import baseUrl.JsonPlaceHolderBaseUrl;
import org.junit.Test;
import testData.TestDataJsonPlace;

public class C25_Put_PojoClass extends JsonPlaceHolderBaseUrl {
    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki
     body’e sahip bir PUT request yolladigimizda donen response’in
     response body’sinin asagida verilen ile ayni oldugunu test ediniz

     Request Body

    {
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":10,
    "id":70
    }

    Expected Body

    {
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":10,
    "id":70
    }
     */

    @Test
    public void put01(){
        // 1 - Url ve Request Body hazirla
        specJsonPlace.pathParams("pp1","posts","pp2",70);



    }

}
