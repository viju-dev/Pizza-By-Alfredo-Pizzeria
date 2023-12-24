package com.example.Pizza.by.Alfredo.Pizzeria.Convertors;

import com.example.Pizza.by.Alfredo.Pizzeria.Dtos.RequestDtos.OrderPizzaReqDto;
import com.example.Pizza.by.Alfredo.Pizzeria.Models.OrderPizza;
import com.example.Pizza.by.Alfredo.Pizzeria.Models.Pizza;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Builder
public class OrderPizzaConvertors {

     public static OrderPizza OrderPizzaReqDtoToOrderPizza(@RequestBody OrderPizzaReqDto orderPizzaReqDto){
         OrderPizza orderPizza = OrderPizza.builder().quantity(orderPizzaReqDto.getQuantity())
                                                     .build();

         return orderPizza;
     }

    public static OrderPizza PizzaToOrderPizza(@RequestBody Pizza pizza){
                OrderPizza orderPizza = OrderPizza.builder()
                        .pizza(pizza)
                        .build();

        return orderPizza;
    }


}
