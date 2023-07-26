package com.example.operacionesterminales;

import com.example.operacionesintermedias.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ToList {

    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        products.add(new Product("product1", 9.99, 1));
        products.add(new Product("product2", 19.99, 6));
        products.add(new Product("product3", 29.99, 3));
        products.add(new Product("product4", 39.99, 4));
        products.add(new Product("product5", 49.99, 2));

        List<Double> prices = products.stream()
                .map(Product::getPrice)
                .filter(price -> price > 10.0)
                .collect(Collectors.toList());

        System.out.println(prices);

        List<Double> prices2 = products.stream()
                .map(Product::getPrice)
                .filter(price -> price > 10.0)
                .toList();

        System.out.println(prices);

    }
}
