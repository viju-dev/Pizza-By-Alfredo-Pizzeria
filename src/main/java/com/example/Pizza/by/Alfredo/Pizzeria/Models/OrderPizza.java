package com.example.Pizza.by.Alfredo.Pizzeria.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

@Entity
@Table
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderPizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Min(value = 1,message = "minimum quantity should be 1")
    private int quantity;

//    private Double price;

    @ManyToOne
    @JoinColumn
    Order order;

    @ManyToOne
    @JoinColumn
    Pizza pizza;

}
