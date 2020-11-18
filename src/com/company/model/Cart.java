package com.company.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    Map<String, CartItem> map = new HashMap<>();
    Map<String, Integer> totalVariantQtyMap = new HashMap<>();
    public int noOfItems, subTotal;


    public int addToCart(Product product, Variant variant){
        String key = product.name + " " + variant.name;

        if (map.containsKey(key)){
            map.get(key).qty++;
        }else {
            map.put(key, new CartItem(product.name, variant.price));
        }

        noOfItems++;
        subTotal += variant.price;

        return (int) map.get(key).qty;
    }

    public int removeFromCart(Product product, Variant variant){
        String key = product.name + " " + variant.name;

        map.get(key).qty--;

        if (map.get(key).qty == 0)
            map.remove(key);

        noOfItems--;
        subTotal -= variant.price;

        return (int) map.get(key).qty;
    }

    public void updateWBPQuantity(Product product, float qty){
        int newPrice = (int) (product.pricePerKg * qty);

        if (map.containsKey(product.name))
            subTotal -= map.get(product.name).price;
        else
            noOfItems = (int) (qty +  noOfItems) ;

        map.put(product.name, new CartItem(product.name, qty, newPrice));
        subTotal += newPrice;
    }

    @Override
    public String toString() {
        return "Cart{" + "\n" +
                "cartItems" + map + "\n " +
                " noOfItems=" + noOfItems + "\n " +
                " subTotal=" + subTotal + "\n " +
                '}';
    }
}
