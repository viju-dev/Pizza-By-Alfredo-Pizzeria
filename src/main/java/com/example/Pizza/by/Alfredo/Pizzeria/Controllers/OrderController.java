package com.example.Pizza.by.Alfredo.Pizzeria.Controllers;

import com.example.Pizza.by.Alfredo.Pizzeria.Dtos.RequestDtos.OrderPizzaReqDto;
import com.example.Pizza.by.Alfredo.Pizzeria.Enums.orderStatus;
import com.example.Pizza.by.Alfredo.Pizzeria.Models.OrderPizza;
import com.example.Pizza.by.Alfredo.Pizzeria.Models.Pizza;
import com.example.Pizza.by.Alfredo.Pizzeria.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/orders")

public class OrderController {
    @Autowired
    OrderService orderService;


    @PostMapping("/placeOrder")
    public ResponseEntity<String> order(@RequestParam int pizzaId, @RequestParam int quantity){

     try {
         String str = orderService.order(pizzaId, quantity);
         return  new ResponseEntity<>(str, HttpStatus.OK);
     }
     catch (Exception e){
         return  new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
     }
    }

    @PostMapping("/placeMultiOrder")
    public ResponseEntity<String> multiOrder(@RequestBody List<OrderPizzaReqDto> pizzaList){

       try{
           String str =  orderService.multiOrder(pizzaList);
           return  new ResponseEntity<>(str , HttpStatus.OK);
       }
       catch (Exception e){
           return  new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
       }

    }

    @GetMapping("/trackById")
    public ResponseEntity<String> trackByIc(@RequestParam int orderId){
        orderStatus status = null;
        try {
            status = orderService.track(orderId);
            return new ResponseEntity<>(status.toString(),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/updateOrderStatusById")
    public ResponseEntity<String> updateOrderStatusById(@RequestParam Integer orderId,@RequestParam String  status){
        orderStatus status1 = orderStatus.valueOf(status);
        String str = null;
        try {
            str = orderService.updateOrderStatusById(orderId, status1);
            return new ResponseEntity<>(str,HttpStatus.OK);
        } catch (Exception e) {
            return  new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}
