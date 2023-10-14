package com.example.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.GroceryItem;
import com.example.service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/grocery-items")
    public ResponseEntity<GroceryItem> addGroceryItem(@RequestBody GroceryItem item) {
        GroceryItem addedItem = adminService.addGroceryItem(item);
        if (addedItem != null) {
            return new ResponseEntity<>(addedItem, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/grocery-items")
    public List<GroceryItem> viewGroceryItems() {
        List<GroceryItem> groceryItems = adminService.viewGroceryItems();
        return groceryItems;
    }

    @DeleteMapping("/grocery-items/{itemId}")
    public ResponseEntity<String> removeGroceryItem(@PathVariable Long itemId) {
        String message = adminService.removeGroceryItem(itemId);
        if (message != null) {
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Item not found", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/grocery-items/{itemId}")
    public ResponseEntity<GroceryItem> updateGroceryItem(@PathVariable Long itemId, @RequestBody GroceryItem updatedItem) {
        GroceryItem updated = adminService.updateGroceryItem(itemId, updatedItem);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	/*
	 * @PutMapping("/grocery-items/{itemId}/inventory") public
	 * ResponseEntity<GroceryItem> updateInventory(@PathVariable Long
	 * itemId, @RequestBody int newQuantity) { GroceryItem updated =
	 * adminService.updateInventory(itemId, newQuantity); if (updated != null) {
	 * return new ResponseEntity<>(updated, HttpStatus.OK); } else { return new
	 * ResponseEntity<>(HttpStatus.NOT_FOUND); } }
	 */
}
