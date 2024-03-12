package com.misael.service.order.controllers;

import com.misael.service.order.entities.Order;
import com.misael.service.order.entities.Person;
import com.misael.service.order.entities.dtos.OrderDto;
import com.misael.service.order.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> registerNewOrder(@RequestBody OrderDto orderDto){
        Optional<Person> personName = orderService.findByCompleteName(orderDto.searchPersonByName());
        if(personName.isPresent()){
            Person person = personName.get();
            Order order = Order.builder().title(orderDto.title())
                    .description(orderDto.description())
                    .person(person).build();
            return ResponseEntity.status(HttpStatus.OK).body(orderService.registerNewOrder(order));
        }

        return ResponseEntity.internalServerError().body("PERSON NOT FOUND");
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> listAllServiceOrders(){
        return ResponseEntity.ok().body(orderService.listAllServiceOrders());
    }
}
