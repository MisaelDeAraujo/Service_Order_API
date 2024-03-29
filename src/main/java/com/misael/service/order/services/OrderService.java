package com.misael.service.order.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misael.service.order.entities.Order;
import com.misael.service.order.entities.Person;
import com.misael.service.order.entities.dtos.AlterServiceOrderDto;
import com.misael.service.order.entities.dtos.SearchPersonAndRegisterOrderDto;
import com.misael.service.order.exceptions.PersonNotFoundException;
import com.misael.service.order.exceptions.ServiceOrderNotFoundException;
import com.misael.service.order.repositories.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PersonService personService;

    public Order registerNewOrder(SearchPersonAndRegisterOrderDto searchPersonAndRegisterOrderDto){
        Optional<Person> personName = personService.findByCompleteName(
        		searchPersonAndRegisterOrderDto.searchPersonByName().toUpperCase());
        if(personName.isPresent()) {
            Person person = personName.get();
            Order order = Order.builder().title(searchPersonAndRegisterOrderDto.title())
                    .description(searchPersonAndRegisterOrderDto.description())
                    .person(person)
                    .orderCreatedDate(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))
                    .build();
            return orderRepository.save(order);
        }else{
            throw new PersonNotFoundException();
        }
    }

    public Order alterExistingOrder(AlterServiceOrderDto orderDto, Integer id){
        Optional<Order> findId= orderRepository.findById(id);
        if(findId.isPresent()){
            var order = findId.get();
            if(orderDto.title() != null && !orderDto.title().isBlank() && orderDto.title().length() < 50) {
                order.setTitle(orderDto.title());
            }
            if(orderDto.description() != null && !orderDto.description().isBlank()) {
            	order.setDescription(orderDto.description());
            }
            return orderRepository.save(order);
        }
        else{
            throw new ServiceOrderNotFoundException();
        }
    }

    public List<Order> listAllServiceOrders(){
        return orderRepository.findAll();
    }

}
