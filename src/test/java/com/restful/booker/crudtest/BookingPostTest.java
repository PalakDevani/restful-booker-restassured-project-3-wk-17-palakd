package com.restful.booker.crudtest;

import com.restful.booker.model.CustomerPojo;
import com.restful.booker.model.LoginPojo;
import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class BookingPostTest extends TestBase {

    @Test
    public void createToken() {
        LoginPojo loginPojo = new LoginPojo();
        loginPojo.setUsername("admin");
        loginPojo.setPassword("password123");
        Response response = given()
                .header("Content-Type", "application/json")
                .body(loginPojo)
                .when()
                .post("/auth");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void createBooking() {
        CustomerPojo customerPojo = new CustomerPojo();
        HashMap<Object, Object> bookingDatesData = new HashMap<>();
        bookingDatesData.put("checkin", 2024 - 01 - 01);
        bookingDatesData.put("checkout", 2025 - 01 - 01);
        customerPojo.setFirstName("Malav");
        customerPojo.setLastName("Patel");
        customerPojo.setTotalPrice(111);
        customerPojo.setDepositPaid(true);
        customerPojo.setBookingDates(bookingDatesData);
        customerPojo.setAdditionalNeeds("Veg Breakfast");
        Response response = given()
                .header("Content-Type", "application/json")
                .header("cookie", "token=ab6bcd40bef3eb4")
                .body(customerPojo)
                .when()
                .post("/booking");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void updateBooking() {
        CustomerPojo customerPojo = new CustomerPojo();
        HashMap<Object, Object> bookingDatesData = new HashMap<>();
        bookingDatesData.put("checkin", 2024 - 01 - 01);
        bookingDatesData.put("checkout", 2025 - 01 - 01);
        customerPojo.setFirstName("Mala");
        customerPojo.setLastName("Devani");
        customerPojo.setTotalPrice(111);
        customerPojo.setDepositPaid(true);
        customerPojo.setBookingDates(bookingDatesData);
        customerPojo.setAdditionalNeeds("Breakfast");
        Response response = given()
                .header("Content-Type", "application/json")
                .auth().preemptive().basic("admin", "password123")
                .header("Accept", "application/json")
                .body(customerPojo)
                .when()
                .put("/booking/5838");
        response.prettyPrint();

    }
}
