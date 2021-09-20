package com.example.taxi.review;

public class ratings {
    public String userID;
    public String rating;
    public String comment;

    public ratings(String userID, String rating, String comment) {
        this.userID = userID;
        this.rating = rating;
        this.comment = comment;
    }



    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
