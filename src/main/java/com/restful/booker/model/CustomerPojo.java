package com.restful.booker.model;

import java.util.HashMap;

public class CustomerPojo {
    private String firstName;
    private String lastName;
    private int totalPrice;
    private boolean depositPaid;
    private String additionalNeeds;
    private HashMap<Object, Object> bookingDates;
    private String usrername;
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public HashMap<Object, Object> getBookingDates() {
        return bookingDates;
    }

    public void setBookingDates(HashMap<Object, Object> bookingDates) {
        this.bookingDates = bookingDates;
    }

    public String getUsrername() {
        return usrername;
    }

    public void setUsrername(String usrername) {
        this.usrername = usrername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isDepositPaid() {
        return depositPaid;
    }

    public void setDepositPaid(boolean depositPaid) {
        this.depositPaid = depositPaid;
    }

    public String getAdditionalNeeds() {
        return additionalNeeds;
    }

    public void setAdditionalNeeds(String additionalNeeds) {
        this.additionalNeeds = additionalNeeds;
    }
}
