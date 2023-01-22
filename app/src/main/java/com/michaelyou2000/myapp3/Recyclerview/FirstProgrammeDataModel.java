package com.michaelyou2000.myapp3.Recyclerview;

public class FirstProgrammeDataModel {
    String link;
    String name;


    FirstProgrammeDataModel(){

    }

    public FirstProgrammeDataModel(String link ,String name) {
        this.link = link;
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
