package com.example.addproductwithcategorie.orders.orderRepo;

import com.example.addproductwithcategorie.orders.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
}
