package com.example.thuchanh2.models;

import java.io.Serializable;

public class Item implements Serializable {
    private int itemID;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Item(int itemID, String username, String itemName) {
        this.itemID = itemID;
        this.username = username;
        this.itemName = itemName;
    }

    public Item(String itemName, String username) {
        this.username = username;
        this.itemName = itemName;
    }

    public int getId() {
        return itemID;
    }

    public void setId(int id) {
        this.itemID = id;
    }

    private String itemName;




    public Item() {
    }


    public String getName() {
        return itemName;
    }

    public void setName(String name) {
        this.itemName = name;
    }


}
