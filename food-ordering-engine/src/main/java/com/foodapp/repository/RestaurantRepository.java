package com.foodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.foodapp.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

}