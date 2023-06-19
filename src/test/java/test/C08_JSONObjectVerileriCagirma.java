package test;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C08_JSONObjectVerileriCagirma {
    /*
        {
        "firstName":"John",
        "lastName":"Doe",
        "age":26,
        "adress":{
            "streetAddress":"naist street",
            "city":"Nara",
            "postalCode":"630-0192"
            },

        "phoneNumbers":[
                       {
                            "type":"iPhone"
                            "number":"0123-4567-8888",
                       },
                       {
                            "type":"home"
                            "number":"0123-4567-8910",
                        }
                        ]
        }
     */
    @Test
    public void jsonObje01(){

        JSONObject cepTel = new JSONObject();
        cepTel.put("type","iPhone");
        cepTel.put("number","0123-4567-8888");

        JSONObject evTel = new JSONObject();
        evTel.put("type","home");
        evTel.put("number","0123-4567-8910");

        JSONArray phoneNumbers = new JSONArray();

        phoneNumbers.put(0,cepTel);
        phoneNumbers.put(1,evTel);

        JSONObject adress = new JSONObject();
        adress.put("streetAddress","naist street");
        adress.put("city","Nara");
        adress.put("postalCode","630-0192");

        JSONObject kisiBilgisi = new JSONObject();

        kisiBilgisi.put("firstName","John");
        kisiBilgisi.put("lastName","Doe");
        kisiBilgisi.put("age","26");
        kisiBilgisi.put("adress",adress);
        kisiBilgisi.put("phoneNumbers",phoneNumbers);

        System.out.println("Isim : "+kisiBilgisi.get("firstName"));
        System.out.println("Soyisim : "+kisiBilgisi.get("lastName"));
        System.out.println("Yas : "+kisiBilgisi.get("age"));

        System.out.println("Sokak adi : "+kisiBilgisi.getJSONObject("adress").get("streetAddress"));
        System.out.println("Sehir : "+kisiBilgisi.getJSONObject("adress").get("city"));
        System.out.println("Sehir : "+kisiBilgisi.getJSONObject("adress").get("postalCode"));

        System.out.println("Tel no : " +kisiBilgisi
                .getJSONArray("phoneNumbers")
                .getJSONObject(0)
                .get("number")
        );

        System.out.println("Tel Type : "+kisiBilgisi
                .getJSONArray("phoneNumbers")
                .getJSONObject(0)
                .get("type")
        );

        System.out.println("Tel Type : "+kisiBilgisi
                .getJSONArray("phoneNumbers")
                .getJSONObject(1)
                .get("number")
        );

        System.out.println("Tel Type : "+kisiBilgisi
                .getJSONArray("phoneNumbers")
                .getJSONObject(1)
                .get("type")
        );

    }

}
