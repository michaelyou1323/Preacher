package com.preacher.app.Recyclerview;

public class EventsDataModel {

    String link ;
    String imageUrl;
    String title;
    String description;


    public EventsDataModel() {

    }

    public EventsDataModel(String link, String imageUrl ,String title ,String description) {
        this.link = link;
        this.imageUrl = imageUrl;
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


}
