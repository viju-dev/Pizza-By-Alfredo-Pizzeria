package com.example.Pizza.by.Alfredo.Pizzeria.CustomExceptions;

public class PizzaSaveException extends RuntimeException{

    public PizzaSaveException(String message) {
        super(message);
    }

    public PizzaSaveException(String message, Throwable cause) {
        super(message, cause);
    }
}
