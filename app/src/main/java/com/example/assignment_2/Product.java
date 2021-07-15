package com.example.assignment_2;

public class Product {
    //it will consist all the information about the country
    String name;
    int price;
    int image;
    String description;
    int quantity;

    public Product(String name, int price, int image, String description) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.description = description;
        quantity = 0;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getImage() {
        return image;
    }

    public int getQuantity(){ return quantity;}


    public String getDescription() {
        return description;
    }
}
