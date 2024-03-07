package com.misael.service.order.controllers;

import com.misael.service.order.entities.Person;
import com.misael.service.order.entities.dtos.PersonDto;
import com.misael.service.order.services.PersonService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@RestController
@RequestMapping("/persons")
public class PersonController {

    private PersonService personService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> registerNewPerson(@RequestBody @Valid PersonDto dto){
        var person = Person.builder().build();
        BeanUtils.copyProperties(dto,person);
        return ResponseEntity.ok().body(personService.registerNewPerson(person));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> listAllPersons(){
        return ResponseEntity.status(HttpStatus.FOUND).body(personService.listAllPersons());
    }

}
