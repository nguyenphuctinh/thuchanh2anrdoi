package com.example.thuchanh2.models;

import java.io.Serializable;

public class Item implements Serializable {
    private int itemID;

    public int getId() {
        return itemID;
    }

    public void setId(int id) {
        this.itemID = id;
    }

    private String itemName;

    public Item(int id, String name) {
        this.itemID = id;
        this.itemName = name;
    }

    public Item(String name) {
        this.itemName = name;
    }

    public Item() {
    }


    public String getName() {
        return itemName;
    }

    public void setName(String name) {
        this.itemName = name;
    }


}
