package com.example.addproductwithcategorie.orders.orderWebService;


import com.example.addproductwithcategorie.orders.order.Order;
import com.example.addproductwithcategorie.orders.orderService.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/order")
@CrossOrigin
@RequiredArgsConstructor
public class OrderWebService {
    private final OrderService orderService;

    @PostMapping("/save/{productid}")
    public Order saveOrder(@RequestBody Order order,@PathVariable("productid") Long id){
        return orderService.saveOrder(order,id);
    }

    @GetMapping("getid/{id}")
    public Optional<Order> getOrderId(@PathVariable("id") Long id){
        return orderService.getOrderId(id);
    }

    @DeleteMapping("deleteid/{id}")
    public String deleteOrdersId(@PathVariable("id") Long id){
        return orderService.deleteOrders(id);
    }

    @GetMapping("/getall")
    public List<Order> getAllOrders(){
        return orderService.getAllOrder();
    }

    @PutMapping("/confirm/{id}")
    public String orderConfirmed(@PathVariable("id") Long id){
        orderService.orderActived(id);
        return ("is Done");
    }
    @PutMapping("/noconfirm/{id}")
    public String orderNoConfirmed(@PathVariable("id") Long id){
        orderService.orderDesactived(id);
        return ("is Done");
    }

    @GetMapping("/countreservation")
    public Long countOrders(){
        return orderService.countOrder();
    }
}
