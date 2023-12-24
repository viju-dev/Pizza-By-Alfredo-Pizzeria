package com.example.Pizza.by.Alfredo.Pizzeria.Services;

import com.example.Pizza.by.Alfredo.Pizzeria.Convertors.OrderPizzaConvertors;
import com.example.Pizza.by.Alfredo.Pizzeria.CustomExceptions.OrderNotFoundException;
import com.example.Pizza.by.Alfredo.Pizzeria.CustomExceptions.OrderSaveException;
import com.example.Pizza.by.Alfredo.Pizzeria.CustomExceptions.PizzaNotFoundException;
import com.example.Pizza.by.Alfredo.Pizzeria.CustomExceptions.PizzaSaveException;
import com.example.Pizza.by.Alfredo.Pizzeria.Dtos.RequestDtos.OrderPizzaReqDto;
import com.example.Pizza.by.Alfredo.Pizzeria.Enums.orderStatus;
import com.example.Pizza.by.Alfredo.Pizzeria.Models.Order;
import com.example.Pizza.by.Alfredo.Pizzeria.Models.OrderPizza;
import com.example.Pizza.by.Alfredo.Pizzeria.Models.Pizza;
import com.example.Pizza.by.Alfredo.Pizzeria.Repositories.OrderPizzaRepo;
import com.example.Pizza.by.Alfredo.Pizzeria.Repositories.OrderRepo;
import com.example.Pizza.by.Alfredo.Pizzeria.Repositories.PizzaRepo;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    PizzaRepo pizzaRepo;

    @Autowired
    OrderPizzaRepo orderPizzaRepo;

    public String order(int pizzaId, int quantity) {
        try {
            Pizza pizza = pizzaRepo.getReferenceById(pizzaId);
            OrderPizza orderPizza = OrderPizzaConvertors.PizzaToOrderPizza(pizza);
            orderPizza.setQuantity(quantity);

//            if(quantity > 1){
//                throw new RuntimeException("Error : you can't order pizza more than 1 quantity");
//            }

            List<OrderPizza> pizzaList = new ArrayList<>();
            pizzaList.add(orderPizza);
            Order order = Order.builder()
                    .status(orderStatus.PENDING)
                    .pizzaList(pizzaList)
                    .build();
            for (OrderPizza op : pizzaList){
                op.setOrder(order);
            }
            orderRepo.save(order);
            return "you're order been placed successfully :)...and the orderId is : "+order.getId();
        }
        catch (EntityNotFoundException e){
            throw new PizzaNotFoundException("Pizza with id : "+ pizzaId +" doesn't exist !, "+e);
        }
        catch (DataAccessException e){
            throw new OrderSaveException("Error occur while saving order !",e);
        }


    }

    public String multiOrder(List<OrderPizzaReqDto> pizzaList) {
        int pizzaId=-1;
        try{
            List<OrderPizza> pizzaList1 = new ArrayList<>();
            for (OrderPizzaReqDto pizza : pizzaList) {

//                if(pizza.getQuantity() > 1){
//                    throw new RuntimeException("Error : you can't order pizza more than 1 quantity");
//                }

                pizzaId = pizza.getId();
                OrderPizza op=OrderPizzaConvertors.PizzaToOrderPizza(pizzaRepo.getReferenceById(pizza.getId()));
                op.setQuantity(pizza.getQuantity());
                pizzaList1.add(op);
            }
            Order order = Order.builder()
                    .pizzaList(pizzaList1)
                    .status(orderStatus.PENDING)
                    .build();

            for (OrderPizza op : pizzaList1){
                op.setOrder(order);
            }

            orderRepo.save(order);

            return "you're order been placed successfully :)... and the orderId is : "+order.getId();
        }
        catch (EntityNotFoundException e){
            throw new PizzaNotFoundException("Pizza with id "+ pizzaId +" doesn't exist !, "+e);
        }
        catch (DataAccessException e){
            throw new OrderSaveException("Error occur while saving order !",e);
        }

    }

    public orderStatus track(int orderId){

       try {
           Order order = orderRepo.getReferenceById(orderId);
           return order.getStatus();
       }
       catch (EntityNotFoundException e){
           throw new OrderNotFoundException("Order with id "+orderId+" doesn't exist !"+e);
       }

    }

    public String updateOrderStatusById(int orderId, orderStatus status)  {

       try {
           Order order = orderRepo.getReferenceById(orderId);
           order.setStatus(orderStatus.DELIVERED);
           orderRepo.save(order);

           return "order status have been updated to "+orderStatus.DELIVERED.toString();
       }
       catch (EntityNotFoundException e){
           throw new OrderNotFoundException("Order with id "+ orderId +" doesn't exist !"+e);
       }
       catch (DataAccessException e){
           throw new OrderSaveException("Error occur while saving order !",e);
       }


    }
}
