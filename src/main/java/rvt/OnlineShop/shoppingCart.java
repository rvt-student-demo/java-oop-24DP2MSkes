package rvt.OnlineShop;

import java.util.*;

public class shoppingCart {

    Map<String, Item> items;

    public shoppingCart() {
        this.items = new HashMap<>();
    }

    public void add(String product, int price) {
        if(this.items.containsKey(product)){
            this.items.get(product).increaseQuantity();
        } else {
            this.items.put(product, new Item(product, 1, price));
        }
    }

    public int price(){
        int total = 0;
        for (Item item: this.items.values()) {
            total += item.price();
        }
        return total;
    }

    public void print() {
        for (Item item : this.items.values()) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
       shoppingCart cart = new shoppingCart();
        cart.add("milk", 3);
        cart.print();
        System.out.println("cart price: " + cart.price() + "\n");

        cart.add("buttermilk", 2);
        cart.print();
        System.out.println("cart price: " + cart.price() + "\n");

        cart.add("milk", 3);
        cart.print();
        System.out.println("cart price: " + cart.price() + "\n");

        cart.add("milk", 3);
        cart.print();
        System.out.println("cart price: " + cart.price() + "\n");
            }

}