package com.ma.mafood.component;

public class Store {
    String img;
    String name;
    String describe;
    String price;

    public Store(String img, String name, String describe, String price) {
        this.img = img;
        this.name = name;
        this.describe = describe;
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public String getDescribe() {
        return describe;
    }

    public String getPrice() {
        return price;
    }
}
