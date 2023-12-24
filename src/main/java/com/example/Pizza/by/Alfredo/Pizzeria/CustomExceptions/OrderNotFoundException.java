package com.example.Pizza.by.Alfredo.Pizzeria.CustomExceptions;

public class OrderNotFoundException extends  RuntimeException{

    public OrderNotFoundException(String message) {
        super(message);
    }

    public OrderNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
