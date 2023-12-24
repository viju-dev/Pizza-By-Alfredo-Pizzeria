package com.example.Pizza.by.Alfredo.Pizzeria.CustomExceptions;

public class OrderSaveException extends RuntimeException{

    public OrderSaveException(String message) {
        super(message);
    }

    public OrderSaveException(String message, Throwable cause) {
        super(message, cause);
    }
}
