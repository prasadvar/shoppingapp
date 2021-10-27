package com.usingjwttokens.example.tokenbased.models;

public class Inventory {

    private String category;
    private int noofproducts;
    private int available;//instock in db
  //  private int sold;
    private String image;
    private String type;
    private int soldQty;

    public Inventory(String category, int noofproducts, int available,  String image, String type) {
        this.category = category;
        this.noofproducts = noofproducts;
        this.available = available;
    //    this.sold = sold;
        this.image = image;
        this.type = type;
       this.soldQty = soldQty;
    }
    public Inventory() {
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public int getNoofproducts() {
        return noofproducts;
    }
    public void setNoofproducts(int noofproducts) {
        this.noofproducts = noofproducts;
    }
    public int getAvailable() {
        return available;
    }
    public void setAvailable(int available) {
        this.available = available;
    }
//    public int getSold() {
//        return sold;
//    }
//
//    public void setSold(int sold) {
//        this.sold = sold;
//    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getSoldQty() {
        return soldQty;
    }
    public void setSoldQty(int soldQty) {
        this.soldQty = soldQty;
    }
}
