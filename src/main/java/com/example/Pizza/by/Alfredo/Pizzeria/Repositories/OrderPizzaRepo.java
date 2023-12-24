package com.example.Pizza.by.Alfredo.Pizzeria.Repositories;

import com.example.Pizza.by.Alfredo.Pizzeria.Models.OrderPizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderPizzaRepo extends JpaRepository<OrderPizza,Integer> {
}
