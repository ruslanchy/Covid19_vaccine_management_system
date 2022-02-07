package com.example.covid19_vaccine_management_system;

public class ReviewModel {
    String fname,age,review1,review2;

    public String getName() {
        return fname;
    }

    public void setName(String name) {
        this.fname = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getReview1() {
        return review1;
    }

    public void setReview1(String review1) {
        this.review1 = review1;
    }

    public String getReview2() {
        return review2;
    }

    public void setReview2(String review2) {
        this.review2 = review2;
    }
}
