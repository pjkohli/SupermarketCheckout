package com.prabhjot;

/**
 * Created by prabhjotkaur on 21/05/2017.
 */

public class Product {

    int productId;
    String productName;
    float price;
    String promotionType;
    float specialPrice;
    Product freeProduct;
    int quantitiesToBuy;
    int quantitiesFree;


    public Product(int productId, String productName, float price, String promotionType) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.promotionType = promotionType;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(String promotionType) {
        this.promotionType = promotionType;
    }

    public float getSpecialPrice() {
        return specialPrice;
    }

    public void setSpecialPrice(float specialPrice) {
        this.specialPrice = specialPrice;
    }

    public Product getFreeProduct() {
        return freeProduct;
    }

    public void setFreeProduct(Product freeProduct) {
        this.freeProduct = freeProduct;
    }

    public int getQuantitiesToBuy() {
        return quantitiesToBuy;
    }

    public void setQuantitiesToBuy(int quantitiesToBuy) {
        this.quantitiesToBuy = quantitiesToBuy;
    }

    public int getQuantitiesFree() {
        return quantitiesFree;
    }

    public void setQuantitiesFree(int quantitiesFree) {
        this.quantitiesFree = quantitiesFree;
    }
}
