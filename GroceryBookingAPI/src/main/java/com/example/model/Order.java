package com.example.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Order {       /*
						 
						 * @ManyToOne is used to establish a Many-to-One relationship between the Order
						 * and User entities, where each order is associated with a single user.
						 * 
						 * @OneToMany is used to create a One-to-Many relationship between Order and
						 * GroceryItem, indicating that each order can contain multiple grocery items.
						 * The @JoinTable annotation is used to specify the name of the join table for
						 * the relationship between orders and grocery items. LocalDateTime is used for
						 * the orderDate attribute to store the date and time of the order. OrderStatus
						 * is a custom enum type that can be used to represent the status of the order
						 * (e.g., "PLACED," "SHIPPED," "DELIVERED").
						 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "order_grocery_items",
               joinColumns = @JoinColumn(name = "order_id"),
               inverseJoinColumns = @JoinColumn(name = "grocery_item_id"))
    private List<GroceryItem> items;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    
    private List<OrderItemRequest> orderItems;

    public Order() {
        // Default constructor
    }

    public Order(User user, List<GroceryItem> items, List<OrderItemRequest> orderItems,LocalDateTime orderDate, OrderStatus status) {
        this.user = user;
        this.items = items;
        this.orderDate = orderDate;
        this.orderItems = orderItems;
        this.status = status;
    }

	public List<OrderItemRequest> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItemRequest> orderItems) {
		this.orderItems = orderItems;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<GroceryItem> getItems() {
		return items;
	}

	public void setItems(List<GroceryItem> items) {
		this.items = items;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

    
}

 

