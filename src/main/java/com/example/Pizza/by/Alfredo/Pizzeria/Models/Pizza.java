package com.example.Pizza.by.Alfredo.Pizzeria.Models;


import com.example.Pizza.by.Alfredo.Pizzeria.Enums.pizzaNames;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true,nullable = false)
    @Enumerated(EnumType.STRING)
    private pizzaNames name;

    @OneToMany(mappedBy = "pizza", cascade = CascadeType.ALL)
    private List<OrderPizza> pizzaList = new ArrayList<>();



}
