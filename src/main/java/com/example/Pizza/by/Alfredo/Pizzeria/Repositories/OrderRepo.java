package com.example.Pizza.by.Alfredo.Pizzeria.Repositories;

import com.example.Pizza.by.Alfredo.Pizzeria.Models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Integer> {
}
