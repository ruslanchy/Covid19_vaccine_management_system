package com.example.covid19_vaccine_management_system;

public class surveyhelperclass {
    String name,age,servfirst,servsecond;
    public surveyhelperclass(){

    }
    public surveyhelperclass(String name , String age , String servfirst, String servsecond){
      this.name=name;
      this.age = age;
      this.servfirst = servfirst;
      this.servsecond = servsecond;
    }
    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name= name;
    }

    public String getAge() {

        return age;
    }

    public void setAge(String age) {

        this.age = age;
    }

    public String getServfirst() {

        return servfirst;
    }

    public void setServfirst(String servfirst) {

        this.servfirst = servfirst;
    }

    public String getServsecond() {
        return servsecond;
    }

    public void setServsecond(String servsecond) {
        this.servsecond = servsecond;
    }
}
