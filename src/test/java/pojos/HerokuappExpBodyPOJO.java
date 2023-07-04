package pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  // Getter-Setter  ve toString() olusturur
@NoArgsConstructor  // Parametresiz Constructor olusturur
@AllArgsConstructor // Parametreli Constructor olusturur
public class HerokuappExpBodyPOJO {
    /*
    Response Body = Expected Data
    	            	{
                    "bookingid":24,
                    "booking":{
                        "firstname":"Ali",
                        "lastname":"Bak",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                                        }
                        ,
                        "additionalneeds":"wi-fi"
                              }
                    }
     */
    private int bookingid;
    private BookingPOJO booking;

}
