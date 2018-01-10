package com.lifecircle.ui.model;

/**
 * Created by lenovo on 2017/12/28.
 */

public class ShopSearchBean {
    private String img;
    private String name;
    private String price;
    private int amount;
    private String id;
    
    public int getAmount(){
        return amount;
    }
    public void  setAmount(int amount){
        this.amount=amount;
    }
    public String getId(){
        return id;
    }
    public void  setId(String id){
        this.id=id;
    }
    
    public String getPrice(){
        return price;
    }
    public void setprice(String price){
        this.price=price;
    }
    
    
    public String getName(){
     return name;   
    }
    
    public void setName(String name){
        this.name=name;
    }
    
    public String getShopImg() {
        return img;
    }

    public void setShopImg(String img) {
        this.img = img;
    }
}
