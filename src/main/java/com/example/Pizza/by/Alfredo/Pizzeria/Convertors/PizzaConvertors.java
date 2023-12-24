package com.example.Pizza.by.Alfredo.Pizzeria.Convertors;

import com.example.Pizza.by.Alfredo.Pizzeria.Dtos.ResponseDtos.PizzaResDto;
import com.example.Pizza.by.Alfredo.Pizzeria.Enums.pizzaNames;
import com.example.Pizza.by.Alfredo.Pizzeria.Models.Pizza;


public class PizzaConvertors {

    public static PizzaResDto PizzaToPizzaResDto(Pizza pizza){
        PizzaResDto pizzaResDto = PizzaResDto.builder()
                .id(pizza.getId())
                .name(pizza.getName())
                .build();

        return pizzaResDto;
    }
}
