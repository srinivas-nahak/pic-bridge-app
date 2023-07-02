package com.example.materialviewpractice;

public class Contacts {

    private String name,age,imageUrl;

    public Contacts(String name, String age, String imageUrl) {
        this.name = name;
        this.age = age;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
