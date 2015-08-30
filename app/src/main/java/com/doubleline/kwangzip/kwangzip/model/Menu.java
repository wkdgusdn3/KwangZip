package com.doubleline.kwangzip.kwangzip.model;

/**
 * Created by HyunWoo on 2015-08-30.
 */
public class Menu {
    String number;
    String name;
    String price;

    public Menu(String number, String name, String price) {
        this.number = number;
        this.name = name;
        this.price = price;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
