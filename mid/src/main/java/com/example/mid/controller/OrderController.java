package com.example.mid.controller;

import com.example.mid.Service.OrderService;
import com.example.mid.exception.ApiRequestException;
import com.example.mid.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @PostMapping("/create")
    public void buyProduct(@RequestParam Long service_id, Long userId){
        if(userId == 0 || service_id == 0){
            throw new ApiRequestException("userId or productId cannot be null or equal to 0");
        }

        orderService.createOrder(service_id, userId);
    }

}
