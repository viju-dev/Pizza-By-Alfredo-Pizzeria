package com.example.Pizza.by.Alfredo.Pizzeria.Models;

import com.example.Pizza.by.Alfredo.Pizzeria.Enums.orderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private orderStatus status ;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<OrderPizza> pizzaList = new ArrayList<>();

}
