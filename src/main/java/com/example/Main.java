// src/main/java/com/example/Main.java
package com.example;

public class Main {

    public static void main(String[] args) {
        System.out.println(greet("World"));
        Calculator calculator = new Calculator();
        System.out.println("10 + 5 = " + calculator.add(10, 5));
        System.out.println("10 - 5 = " + calculator.subtract(10, 5));
        System.out.println("10 * 5 = " + calculator.multiply(10, 5));
        System.out.println("10 / 5 = " + calculator.divide(10, 5));
        System.out.println("Factorial of 5 =" + calculator.factorial(5));

    }

    public static String greet(String name) {
        if (name == null || name.isEmpty()) {
            return "Hello, Guest!";
        }
        return "Hello, " + name + "!";
    }
}
