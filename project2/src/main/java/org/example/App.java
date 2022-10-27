package org.example;

import org.example.model.Product;
import org.example.model.Tax;
import org.w3c.dom.ls.LSOutput;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    static List<Product> shopping = List.of(
            new Product("Clothes", new BigDecimal("15.90"), Tax.NORMAL),
            new Product("Bread", new BigDecimal("1.5"), Tax.SUPERREDUCED),
            new Product("Meat", new BigDecimal("13.99"), Tax.REDUCED),
            new Product("Cheese", new BigDecimal("3.59"), Tax.SUPERREDUCED),
            new Product("Coke", new BigDecimal("1.89"), Tax.REDUCED),
            new Product("Whiskey", new BigDecimal("19.90"), Tax.NORMAL)
    );

    public static void main( String[] args )
    {





    Double price = shopping.stream()
                            .map(product -> product.price.doubleValue() + product.tax.getPercent() * product.price.doubleValue() / 100).
                            reduce(0D,(price1,price2) -> price1 + price2);
                            System.out.println(price);



   String lista = shopping.stream()
           .filter(product -> product.name.startsWith("C"))
           .map(product -> product.name)
           .collect(Collectors.joining(","));

        System.out.println(lista);
    }




}
