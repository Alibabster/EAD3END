package com.example.mid.Service;

import com.example.mid.model.Order;
import com.example.mid.model.Service;
import com.example.mid.model.User;
import com.example.mid.repository.OrderRepository;
import com.example.mid.repository.ServiceRepository;
import com.example.mid.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ServiceRepository productRepository;

    @Autowired
    private UserRepository userRepository;


    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public void createOrder(Long productId, Long userId){
        Service product = productRepository.findById(productId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);


        if (product != null && user != null) {
            Order order = new Order();
            order.setServiceId(productId);
            order.setUserId(userId);
            orderRepository.saveAndFlush(order);
        }
    }
}

















