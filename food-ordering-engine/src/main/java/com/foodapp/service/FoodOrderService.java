package com.foodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodapp.entity.FoodOrder;
import com.foodapp.repository.FoodOrderRepository;

@Service
public class FoodOrderService {

    @Autowired
    private FoodOrderRepository repository;

    public FoodOrder save(FoodOrder order) {

        order.setStatus("PLACED");

        return repository.save(order);
    }

    public List<FoodOrder> getAll() {

        return repository.findAll();
    }

    public FoodOrder update(Long id,
                            FoodOrder order) {

        FoodOrder existing =
                repository.findById(id)
                        .orElseThrow();

        existing.setRestaurantId(
                order.getRestaurantId());

        existing.setItemName(
                order.getItemName());

        existing.setQuantity(
                order.getQuantity());

        existing.setStatus(
                order.getStatus());

        return repository.save(existing);
    }

    public void delete(Long id) {

        repository.deleteById(id);
    }
}