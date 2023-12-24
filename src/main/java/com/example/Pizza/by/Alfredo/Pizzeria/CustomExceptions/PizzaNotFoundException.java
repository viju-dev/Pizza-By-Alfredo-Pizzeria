package com.example.Pizza.by.Alfredo.Pizzeria.CustomExceptions;

public class PizzaNotFoundException extends RuntimeException{

    public PizzaNotFoundException(String message) {
        super(message);
    }

    public PizzaNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
