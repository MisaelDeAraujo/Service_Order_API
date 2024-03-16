package com.misael.service.order.controllers;

import com.misael.service.order.entities.dtos.AlterServiceOrderDto;
import com.misael.service.order.entities.dtos.SearchPersonAndRegisterOrderDto;
import com.misael.service.order.services.OrderService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private final OrderService orderService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> registerNewOrder(@RequestBody @Valid SearchPersonAndRegisterOrderDto searchPersonAndRegisterOrderDto){
            return ResponseEntity.accepted().body(orderService.registerNewOrder(searchPersonAndRegisterOrderDto));
        }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> listAllServiceOrders(){
        return ResponseEntity.accepted().body(orderService.listAllServiceOrders());
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Object> alterExistingOrderById(@RequestBody @Valid AlterServiceOrderDto orderDto,
                                                        @PathVariable(value = "id") Integer id){
        return ResponseEntity.accepted().body(orderService.alterExistingOrder(orderDto,id));
    }
}
