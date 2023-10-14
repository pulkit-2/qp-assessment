package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.model.GroceryItem;
import com.example.model.Order;
import com.example.model.OrderItemRequest;
import com.example.model.User;
import com.example.repository.GroceryItemRepository;
import com.example.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GroceryItemRepository groceryItemRepository; // Assuming you have a GroceryItemRepository

    public List<GroceryItem> viewAvailableItems() {
        // Implement logic to fetch and return available grocery items
        // For example:
        return groceryItemRepository.findAll();
    }

    public ResponseEntity<String> placeOrder(List<OrderItemRequest> orderItems, String username) {
        // Implement order placement logic, including user validation and database updates
        // For example:
        User user = userRepository.findByUsername(username);

        if (user != null) {
            // Create an Order instance and save it to the database
            Order order = new Order();
            order.setUser(user);
            // Set other order attributes based on the request
            // Save the order to the database

            return new ResponseEntity<>("Order placed successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }
}



