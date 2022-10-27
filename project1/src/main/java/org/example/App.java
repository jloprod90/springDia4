package org.example;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        //ejercicio 1

        List<Integer> numbers = List.of(18, 6, 4, 15, 55, 78, 12, 9, 8);
            numbers.stream()
                        .filter(num -> num > 10)
                        .forEach(System.out::println);
    }
}

