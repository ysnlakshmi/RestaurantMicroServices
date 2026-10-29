package com.foodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodapp.entity.FoodOrder;

public interface FoodOrderRepository
        extends JpaRepository<FoodOrder, Long> {

}