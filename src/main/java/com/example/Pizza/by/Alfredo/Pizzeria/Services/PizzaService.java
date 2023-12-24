package com.example.Pizza.by.Alfredo.Pizzeria.Services;

import com.example.Pizza.by.Alfredo.Pizzeria.Convertors.PizzaConvertors;
import com.example.Pizza.by.Alfredo.Pizzeria.CustomExceptions.OrderValidationException;
import com.example.Pizza.by.Alfredo.Pizzeria.CustomExceptions.PizzaNotFoundException;
import com.example.Pizza.by.Alfredo.Pizzeria.CustomExceptions.PizzaSaveException;
import com.example.Pizza.by.Alfredo.Pizzeria.Dtos.ResponseDtos.PizzaResDto;
import com.example.Pizza.by.Alfredo.Pizzeria.Models.Pizza;
import com.example.Pizza.by.Alfredo.Pizzeria.Repositories.PizzaRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PizzaService {

    @Autowired
    PizzaRepo pizzaRepo;

    public String add(Pizza pizza)   {
        try {
            pizzaRepo.save(pizza);
            return "Pizza been added Successfully";
        }
        catch (DataAccessException e){
            throw new PizzaSaveException("Error occur while saving pizza !",e);
        }
    }

    public PizzaResDto get(int pizzaId) {
        try {
            Pizza p = pizzaRepo.getReferenceById(pizzaId);
            PizzaResDto pizza = PizzaConvertors.PizzaToPizzaResDto(p);
            return pizza;
        }
        catch (EntityNotFoundException e){
            throw new PizzaNotFoundException("Pizza with id "+ pizzaId +" doesn't exist !",e);
        }
    }


    public List<PizzaResDto> getAll() {

        List<PizzaResDto> pizzaList = new ArrayList<>();

        try {
            for (Pizza pizza : pizzaRepo.findAll()){
                pizzaList.add(PizzaConvertors.PizzaToPizzaResDto(pizza));
            }

            return pizzaList;
        }
        catch (DataAccessException e){
            throw new PizzaNotFoundException("Error occur while getting pizzas !",e);
        }
    }
}
