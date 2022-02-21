package com.example.busradar;

import java.io.Serializable;

public class Review  {
    int companyID, reviewID, busNo, rating;
    String comment;

    public Review(int companyID, int reviewID, int busNo, int rating, String comment) {
        this.companyID = companyID;
        this.reviewID = reviewID;
        this.busNo = busNo;
        this.rating = rating;
        this.comment = comment;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public int getReviewID() {
        return reviewID;
    }

    public void setReviewID(int reviewID) {
        this.reviewID = reviewID;
    }

    public int getBusNo() {
        return busNo;
    }

    public void setBusNo(int busNo) {
        this.busNo = busNo;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
