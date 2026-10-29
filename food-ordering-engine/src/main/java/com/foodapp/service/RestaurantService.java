package com.foodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodapp.entity.Restaurant;
import com.foodapp.repository.RestaurantRepository;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository repository;

    public Restaurant save(Restaurant restaurant) {
        return repository.save(restaurant);
    }

    public List<Restaurant> getAll() {
        return repository.findAll();
    }

    public Restaurant update(Long id,
                             Restaurant restaurant) {

        Restaurant existing =
                repository.findById(id)
                        .orElseThrow();

        existing.setName(restaurant.getName());
        existing.setAddress(restaurant.getAddress());
        existing.setCuisine(restaurant.getCuisine());

        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
