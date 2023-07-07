package com.example.addproductwithcategorie.orders.orderService;

import com.example.addproductwithcategorie.orders.order.Order;
import com.example.addproductwithcategorie.orders.orderRepo.OrderRepo;
import com.example.addproductwithcategorie.products.product.Product;
import com.example.addproductwithcategorie.products.productRepo.ProductRepo;
import com.example.addproductwithcategorie.user.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepo orderRepo;
    private final ProductRepo productRepo;

    public List<Order> getAllOrder(){
        return orderRepo.findAll();
    }

    public Optional<Order> getOrderId(Long id){
        return orderRepo.findById(id);
    }

    public void orderDesactived(Long id){
        Order order = orderRepo.findById(id)
                .orElseThrow();
        order.setConfirme(false);
        orderRepo.save(order);
    }
    public void orderActived(Long id){
        Order order = orderRepo.findById(id)
                .orElseThrow();
        order.setConfirme(true);
        orderRepo.save(order);
    }

    public String deleteOrders(Long id){
        Optional<Order> orderId = orderRepo.findById(id);
        if (orderId.isPresent()){
            Order order = orderId.get();
            orderRepo.delete(order);
            return ("The order with ID " + id + " has been deleted.");
        }else{
            return ("The order with ID " + id + " was not found.");
        }
    }
    public Long countOrder(){

        return orderRepo.count();
    }

    public Order saveOrder(Order order, Long productId){
        Optional<Product> id = productRepo.findById(productId);
        if (id.isPresent()){
            Product product = id.get();
            order.setProduct(product);
            return orderRepo.save(order);
        }
        else {
            throw new IllegalArgumentException("Invalid Product ID");
        }




    }
}
