package com.example.operacionesintermedias;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Map {

    public static void main(String[] args) {

        List<String> texts = new ArrayList<>();
        texts.add("ddd2");
        texts.add("aaa2");
        texts.add("bbb1");
        texts.add("aaa1");
        texts.add("bbb3");
        texts.add("ccc");
        texts.add("bbb2");

//        texts.stream()
//                .map(text -> text.length())
//                .forEach(System.out::println);

        texts.stream()
                .map(String::length)
                .forEach(System.out::println);

        List<Product> products = new ArrayList<>();
        products.add(new Product("product1", 9.99, 1));
        products.add(new Product("product2", 19.99, 6));
        products.add(new Product("product3", 29.99, 3));
        products.add(new Product("product4", 39.99, 4));
        products.add(new Product("product5", 49.99, 2));

        products.stream()
                //.map(Product::getPrice)
                .map(product -> product.getPrice())
                .filter(price -> price > 10.0)
                .forEach(System.out::println);

        System.out.println("de menos a mayor");
        products.stream()
                .sorted((p1, p2) -> (p1.getEdad()-p2.getEdad()))
                .forEach(System.out::println);

        System.out.println("de mayor a menor");
        products.stream()
                .sorted((p1, p2) -> (p2.getEdad()-p1.getEdad()))
                .forEach(System.out::println);

        System.out.println("ordenar por precio");
        products.stream()
                //.sorted((p1, p2) -> (p2.getPrice()-p1.getPrice()))
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
                .forEach(System.out::println);

        System.out.println("juntar cadena");
        String cadenaJoining = products.stream()
                .filter(p -> p.getEdad()>2)
                .map(p ->p.getName())
                //.forEach(System.out::println);
                .collect(Collectors.joining(",", "Adultos", ""));
        System.out.println(cadenaJoining);

        System.out.println("calcular media");
        double media = products.stream()
                .filter(p -> p.getEdad()>2)

                        .mapToInt(p -> p.getEdad()).average().getAsDouble();

        System.out.println(media);
    }
}
