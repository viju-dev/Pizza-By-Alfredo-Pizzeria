package com.example.Pizza.by.Alfredo.Pizzeria.Dtos.ResponseDtos;

import com.example.Pizza.by.Alfredo.Pizzeria.Enums.pizzaNames;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PizzaResDto {

    private int id;

    @Enumerated(EnumType.STRING)
    private pizzaNames name;

}
