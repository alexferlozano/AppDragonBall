package com.example.userlist.Models;

public class Character {
    private int id;
    private String name;
    private String username;
    private String technique;
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTechnique() {
        return technique;
    }

    public void setTechnique(String technique) {
        this.technique = technique;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Character(int id, String name, String username, String technique, String image) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.technique = technique;
        this.image = image;
    }
}
