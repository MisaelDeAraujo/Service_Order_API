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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/orders")
@Tag(name = "service-order-api")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Operation(summary = "Realiza registro de nova ordem de serviço", description = "Insira nome completo da pessoa (física ou jurídica)"
    		+ "já cadastrada e coloque um titulo e descrição para a ordem de serviço.")
    @PostMapping
    public ResponseEntity<SearchPersonAndRegisterOrderDto> registerNewOrder(@RequestBody @Valid SearchPersonAndRegisterOrderDto searchPersonAndRegisterOrderDto){
    	orderService.registerNewOrder(searchPersonAndRegisterOrderDto);   
    	return ResponseEntity.status(HttpStatus.CREATED).body(searchPersonAndRegisterOrderDto);
        }

    @Operation(summary = "Realiza listagem de todas as ordem de serviço, seja de pessoa física ou jurídica")
    @GetMapping
    public ResponseEntity<List<Order>> listAllServiceOrders(){
    	List<Order> orders = orderService.listAllServiceOrders();
        return ResponseEntity.status(HttpStatus.OK).body(orders);
    }

    @Operation(summary = "Realiza alteração da ordem de serviço", description = "Insira o ID da ordem de serviço"
    		+ "e preencha os campos titulo e descrição para alteração") 
    @PutMapping("/{id}")
    public ResponseEntity<Order> alterExistingOrderById(@RequestBody @Valid AlterServiceOrderDto orderDto,
                                                        @PathVariable(value = "id") Integer id){
    	Order order = orderService.alterExistingOrder(orderDto,id);
        return ResponseEntity.status(HttpStatus.OK).body(order);
    }
}
