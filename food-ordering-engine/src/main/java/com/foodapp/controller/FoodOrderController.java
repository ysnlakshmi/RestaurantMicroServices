package com.foodapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.foodapp.entity.FoodOrder;
import com.foodapp.service.FoodOrderService;

@RestController
@RequestMapping("/orders")
public class FoodOrderController {

    @Autowired
    private FoodOrderService service;

    @PostMapping
    public FoodOrder save(@RequestBody FoodOrder order) {

        return service.save(order);
    }

    @GetMapping
    public List<FoodOrder> getAll() {

        return service.getAll();
    }

    @PutMapping("/{id}")
    public FoodOrder update(
            @PathVariable Long id,
            @RequestBody FoodOrder order) {

        return service.update(id, order);
    }

    @DeleteMapping("/{id}")
    public String delete(
            @PathVariable Long id) {

        service.delete(id);

        return "Order Deleted";
    }
}