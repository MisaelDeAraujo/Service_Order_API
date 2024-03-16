package com.misael.service.order.services;

import com.misael.service.order.entities.Order;
import com.misael.service.order.entities.Person;
import com.misael.service.order.entities.dtos.AlterServiceOrderDto;
import com.misael.service.order.entities.dtos.SearchPersonAndRegisterOrderDto;
import com.misael.service.order.exceptions.PersonNotFoundException;
import com.misael.service.order.exceptions.ServiceOrderNotFoundException;
import com.misael.service.order.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

@AllArgsConstructor
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PersonService personService;

    public Object registerNewOrder(SearchPersonAndRegisterOrderDto searchPersonAndRegisterOrderDto){
        Optional<Person> personName = personService.findByCompleteName(searchPersonAndRegisterOrderDto.searchPersonByName());
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

    public Object alterExistingOrder(AlterServiceOrderDto orderDto, Integer id){
        Optional<Order> findId= orderRepository.findById(id);
        if(findId.isPresent()){
            var order = findId.get();
            order.setTitle(orderDto.title());
            order.setDescription(orderDto.description());
            return orderRepository.save(order);
        }
        else{
            throw new ServiceOrderNotFoundException();
        }
    }

    public Object listAllServiceOrders(){
        return orderRepository.findAll();
    }

}
