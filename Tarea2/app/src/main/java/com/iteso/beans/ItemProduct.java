package com.iteso.beans;

/**
 * Created by carmenmartineznuno on 9/24/17.
 */

public class ItemProduct {
    private int image;
    private String title, store, location, phone, description;

    public ItemProduct() {
        setImage(0);
        setTitle("");
        setStore("");
        setLocation("");
        setPhone("");
        setDescription("");
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getStore() {
        return store;
    }

    public String getLocation() {
        return location;
    }

    public String getPhone() {
        return phone;
    }

    public String getDescription() {
        return description;
    }

    public int getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "item product{image=" + getImage() + ",title=" + getTitle() + ",store=" + getStore() + ",location=" + getLocation() + ",phone=" + getPhone()
                + ",description=" + getDescription() + "}";
    }
}
