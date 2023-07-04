package pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor  // bu class'a 3 tane notasyon ilk basta eklenmeli

public class BookingdatesPOJO {
    /*
    {
    	                         "checkin" : "2021-06-01",
    	                         "checkout" : "2021-06-10"
    	                                  }
     */

    private String checkin;
    private String checkout;

}
