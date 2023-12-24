package com.example.Pizza.by.Alfredo.Pizzeria.Controllers;


import com.example.Pizza.by.Alfredo.Pizzeria.Dtos.RequestDtos.PizzaReqDto;
import com.example.Pizza.by.Alfredo.Pizzeria.Dtos.ResponseDtos.PizzaResDto;
import com.example.Pizza.by.Alfredo.Pizzeria.Enums.pizzaNames;
import com.example.Pizza.by.Alfredo.Pizzeria.Models.Pizza;
import com.example.Pizza.by.Alfredo.Pizzeria.Services.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/pizzas")
public class PizzaController {

    @Autowired
    PizzaService pizzaService;



    @PostMapping("/add")
    private ResponseEntity<String> add(@RequestBody PizzaReqDto pizza){
        Pizza pizza1 = Pizza.builder()
                .name(pizzaNames.valueOf(pizza.getName())).build();
      try {
          String str =  pizzaService.add(pizza1);

          return  new ResponseEntity<>(str,HttpStatus.OK);
      }
      catch (Exception e){
          return  new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
      }
    }


    @GetMapping("/getById")
    private ResponseEntity<?> get(@RequestParam int pizzaId){

        try {
            System.out.println(pizzaId);
            PizzaResDto pizza = pizzaService.get(pizzaId);
            System.out.println("ok");
            return  new ResponseEntity<>(pizza,HttpStatus.OK);
        }
        catch (Exception e){
            System.out.println("ooo");
            return  new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAll")
    private ResponseEntity<?> getAll(){
        try {

            List<PizzaResDto> pizzaList = pizzaService.getAll();
            return  new ResponseEntity<>(pizzaList,HttpStatus.OK);
        }
        catch (Exception e){
            return  new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);

        }
    }


}
