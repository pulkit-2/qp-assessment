package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.GroceryItem;
import com.example.model.OrderItemRequest;
import com.example.service.UserService;



	    @RestController
	    @RequestMapping("/api/user")
	    public class UserController {
	        @Autowired
	        private UserService userService;

	        @GetMapping("/grocery-items")
	        public List<GroceryItem> viewAvailableItems() {
	            List<GroceryItem> availableItems = userService.viewAvailableItems();
	            return availableItems;
	        }

	        @PostMapping("/orders")
	        public ResponseEntity<String> placeOrder(@RequestBody List<OrderItemRequest> orderItems) {
	            // Assume you have a user authentication mechanism that provides the username
	            String username = "exampleUser"; // Replace with actual user authentication logic

	            ResponseEntity<String> response = userService.placeOrder(orderItems, username);

	            return response;
	        }
	    }

	



