package com.misael.service.order.services;

import com.misael.service.order.entities.Order;
import com.misael.service.order.entities.Person;
import com.misael.service.order.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PersonService personService;
    public Optional<Person> findByCompleteName(String completeName){
        return personService.findByCompleteName(completeName);
    }

    public Order registerNewOrder(Order order){
        return orderRepository.save(order);

    }
    public List<Order> listAllServiceOrders(){
        return orderRepository.findAll();
    }

}
