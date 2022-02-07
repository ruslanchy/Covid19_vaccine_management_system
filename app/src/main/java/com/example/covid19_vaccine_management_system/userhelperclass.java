package com.example.covid19_vaccine_management_system;

public class userhelperclass {
    String name,email,password,number,adress,age,vaccinecenter,firstdose,seconddose;

    public userhelperclass() {

    }

    public userhelperclass(String name, String email, String password,  String number, String adress, String age,String vaccinecenter, String firstdose, String seconddose) {
        this.name = name;
        this.email = email;
        this.password = password;

        //this.gender = gender;
        this.number = number;
        this.adress = adress;
        this.age = age;
        this.vaccinecenter=vaccinecenter;
        this.firstdose=firstdose;
        this.seconddose = seconddose;

        //this.loginname = loginname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

  /*  public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }*/

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getVaccinecenter() {
        return vaccinecenter;
    }

    public void setVaccinecenter(String vaccinecenter) {
        this.vaccinecenter = vaccinecenter;
    }

    public String getFirstdose() {
        return firstdose;
    }

    public void setFirstdose(String firstdose) {
        this.firstdose = firstdose;
    }

    public String getSeconddose() {
        return seconddose;
    }

    public void setSeconddose(String seconddose) {
        this.seconddose = seconddose;
    }
}
