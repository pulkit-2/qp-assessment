package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.GroceryItem;
import com.example.repository.GroceryItemRepository;

@Service
public class AdminService {
    @Autowired
    private GroceryItemRepository groceryItemRepository;

    public GroceryItem addGroceryItem(GroceryItem item) {
        // logic to add a new grocery item
        
        return groceryItemRepository.save(item);
    }

    public List<GroceryItem> viewGroceryItems() {
        // Implement logic to fetch and return all grocery items
        // For example:
        return groceryItemRepository.findAll();
    }

    public String removeGroceryItem(Long itemId) {
        // Implement logic to remove a grocery item
        // For example:
        groceryItemRepository.deleteById(itemId);
        return "Grocery item removed successfully";
    }

    public GroceryItem updateGroceryItem(Long itemId, GroceryItem updatedItem) {
        // Implement logic to update a grocery item
        // For example:
        GroceryItem itemToUpdate = groceryItemRepository.findById(itemId).orElse(null);
        if (itemToUpdate != null) {
            // Update properties of itemToUpdate with values from updatedItem
            itemToUpdate.setName(updatedItem.getName());
            itemToUpdate.setDescription(updatedItem.getDescription());
            itemToUpdate.setPrice(updatedItem.getPrice());
            itemToUpdate.setQuantity(updatedItem.getQuantity());
            itemToUpdate.setCategory(updatedItem.getCategory());

            return groceryItemRepository.save(itemToUpdate);
        }
        return null; // Handle not found scenario
    }
}


