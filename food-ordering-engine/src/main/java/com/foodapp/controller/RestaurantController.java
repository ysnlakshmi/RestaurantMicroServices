package com.foodapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.foodapp.entity.Restaurant;
import com.foodapp.service.RestaurantService;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService service;

    @PostMapping
    public Restaurant save(@RequestBody Restaurant restaurant) {

        return service.save(restaurant);
    }

    @GetMapping
    public List<Restaurant> getAll() {

        return service.getAll();
    }

    @PutMapping("/{id}")
    public Restaurant update(
            @PathVariable Long id,
            @RequestBody Restaurant restaurant) {

        return service.update(id, restaurant);
    }

    @DeleteMapping("/{id}")
    public String delete(
            @PathVariable Long id) {

        service.delete(id);

        return "Restaurant Deleted";
    }
}