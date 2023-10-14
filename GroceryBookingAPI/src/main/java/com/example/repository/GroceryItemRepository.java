package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.GroceryItem;

public interface GroceryItemRepository extends JpaRepository<GroceryItem, Long> {
    
}



