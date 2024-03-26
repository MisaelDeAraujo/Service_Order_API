package com.misael.service.order.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.misael.service.order.entities.Order;
import com.misael.service.order.entities.dtos.AlterServiceOrderDto;
import com.misael.service.order.entities.dtos.SearchPersonAndRegisterOrderDto;
import com.misael.service.order.services.OrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> registerNewOrder(@RequestBody @Valid SearchPersonAndRegisterOrderDto searchPersonAndRegisterOrderDto){
    	Order order = orderService.registerNewOrder(searchPersonAndRegisterOrderDto);   
    	return ResponseEntity.status(HttpStatus.CREATED).body(order);
        }

    @GetMapping
    public ResponseEntity<List<Order>> listAllServiceOrders(){
    	List<Order> orders = orderService.listAllServiceOrders();
        return ResponseEntity.status(HttpStatus.OK).body(orders);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> alterExistingOrderById(@RequestBody @Valid AlterServiceOrderDto orderDto,
                                                        @PathVariable(value = "id") Integer id){
    	Order order = orderService.alterExistingOrder(orderDto,id);
        return ResponseEntity.status(HttpStatus.OK).body(order);
    }
}
