package com.restful.booker.crudtest;

import com.restful.booker.model.CustomerPojo;
import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class BookingPatchTest extends TestBase {

    @Test
    public void partialUpdateBooking() {
        CustomerPojo customerPojo = new CustomerPojo();
        HashMap<Object, Object> bookingDatesData = new HashMap<>();
        bookingDatesData.put("checkin", 2018 - 01 - 01);
        bookingDatesData.put("checkout", 2019 - 01 - 01);

        customerPojo.setFirstName("James");
        customerPojo.setLastName("Brown");
        customerPojo.setTotalPrice(111);
        customerPojo.setDepositPaid(true);

        customerPojo.setBookingDates(bookingDatesData);

        customerPojo.setAdditionalNeeds("Breakfast");
        Response response = given()
                .header("Content-Type", "application/json")
                .header("Cookie", "token=ab6bcd40bef3eb4")
                .auth().preemptive().basic("admin", "password123")
                .header("Accept", "application/json")
                .body(customerPojo)
                .when()
                .patch("/booking/20");
        response.then().statusCode(200);
        response.prettyPrint();

    }
}
