package com.company;

import com.company.model.Cart;
import com.company.model.Product;
import com.company.model.Variant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public void show() {
        // Variant Based
        Product product = new Product("rice");
        product.variants = Arrays.asList(
                new Variant("1kg", 50)
                , new Variant("5kg", 250)
        );

      /*  List<Product> productList = new ArrayList<>(Arrays.asList(new Product("rice",Arrays.asList(
                                                                                           new Variant("1kg", 50)
                                                                                           , new Variant("5kg", 250) ))
                                                                  ,new Product("apple", 100, 1)
                                                     ));*/
        //WeightBased
        List<Product> WBProduct = new ArrayList<>(Arrays.asList(new Product("apple", 100, 1)
                                                                , new Product("oranges",150,2)));
        Cart cart = new Cart();

        inputData(product, product.variants, cart, WBProduct);
    }

    private static void inputData(Product products, List<Variant> variant, Cart cart, List<Product> WBProduct) {

        while (true) {
            int choice = showMenuAndGetChoice();
            Scanner scanner = new Scanner(System.in);

            switch (choice) {
                case 1:
                    Variant variant1 = variant.get(0);
                    int qty = cart.addToCart(products, variant1);

                    break;

                case 2:
                    Variant variant2 = variant.get(1);
                    int qty2 = cart.addToCart(products, variant2);
                    break;

                case 3:
                    Product product = WBProduct.get(0);
                    System.out.println("Enter the quantity");
                    float qty3 = scanner.nextInt();

                    cart.updateWBPQuantity(product, qty3);

                    break;

                case 4:
                    Product product1 = WBProduct.get(1);
                    System.out.println("Enter the quantity");
                    float qty4 = scanner.nextInt();

                    cart.updateWBPQuantity(product1, qty4);

                    break;

                default:
                    System.out.println("enter a valid choice: ");
                    break;

            }

            if (wantsToExit()) {
                showData(cart);
                break;
            }
        }
    }

    private static void showData(Cart cart) {
        System.out.println( cart.toString());
      //  System.out.println(cart.subTotal);
    }


    private static boolean wantsToExit() {
        System.out.println("Do you want to continue: Y/N");
        Scanner sc = new Scanner(System.in);
        String input = sc.next().toUpperCase();
        return input.equals("N");
    }


    private static int showMenuAndGetChoice() {
        System.out.println("\n\n----------------------Menu");
        System.out.println("Select The Product You Want To Buy");
        System.out.println("1.rice 1kg");
        System.out.println("2.rice 5kg");
        System.out.println("3.apple");
        System.out.println("4.orange");

        ;
        System.out.println("\nEnter your choice: ");

        return new Scanner(System.in).nextInt();
    }
}