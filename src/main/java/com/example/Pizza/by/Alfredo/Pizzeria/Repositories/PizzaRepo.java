package com.example.Pizza.by.Alfredo.Pizzeria.Repositories;

import com.example.Pizza.by.Alfredo.Pizzeria.Models.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepo extends JpaRepository<Pizza,Integer> {
}
