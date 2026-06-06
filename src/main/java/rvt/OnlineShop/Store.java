package rvt.OnlineShop;

import java.util.Scanner;

public class Store {

    private Warehouse warehouse;
    private Scanner scanner;

    public Store(Warehouse warehouse, Scanner scanner) {
        this.warehouse = warehouse;
        this.scanner = scanner;
    }

    // the method that handles the customers visit to the store.
    public void shop(String customer) {
        shoppingCart cart = new shoppingCart();
        System.out.println("Welcome to the store " + customer);
        System.out.println("our selection:");

        for (String product : this.warehouse.products()) {
            System.out.println(product);
        }

        while (true) {
            System.out.print("What to put in the cart (press enter to go to the register): ");
            String product = scanner.nextLine();
            if (product.isEmpty()) {
                break;
            }

            // add the product to the cart if available in the warehouse
            if (this.warehouse.take(product)) {
                cart.add(product, this.warehouse.price(product));
            }
        }

        System.out.println("your shoppingcart contents:");
        cart.print();
        System.out.println("total: " + cart.price());
    }

    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
            warehouse.addProduct("coffee", 5, 10);
            warehouse.addProduct("milk", 3, 20);
            warehouse.addProduct("cream", 2, 55);
            warehouse.addProduct("bread", 7, 8);

            Scanner scanner = new Scanner(System.in);

            Store store = new Store(warehouse, scanner);
            store.shop("John");
    }
}