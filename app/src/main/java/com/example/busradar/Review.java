package com.example.busradar;

public class Review  {
    String comment, customer;

    public Review(String comment, String customer) {
        this.comment = comment;
        this.customer = customer;
    }

    public String getComment() {
        return comment;
    }

    public String getCustomer() {
        return customer;
    }
}
