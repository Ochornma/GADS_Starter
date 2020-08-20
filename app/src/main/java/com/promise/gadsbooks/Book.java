package com.promise.gadsbooks;

public class Book {
    private  String title;
    private String description;
    private String image;
    private String type;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public Book() {
    }

    public Book(String title, String description, String image, String type) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.type = type;
    }
}
