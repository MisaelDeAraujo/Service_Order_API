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
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/persons")
public class PersonController {

    private PersonService personService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> registerNewPerson(@RequestBody @Valid PersonDto dto){
        var person = Person.builder()
                .completeName(dto.completeName())
                .cpf(dto.cpf())
                .cnpj(dto.cnpj())
                .cellphone(dto.cellphone())
                .email(dto.email())
                .personCreatedDate(LocalDateTime.now())
                .build();
        return ResponseEntity.ok().body(personService.registerNewPerson(person));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> listAllPersons(){
        return ResponseEntity.status(HttpStatus.FOUND).body(personService.listAllPersons());
    }

    @RequestMapping(value = "/{completeName}",method = RequestMethod.GET)
    public ResponseEntity<Object> findPersonByCompleteName(@RequestParam(value = "completeName")
                                                               @Valid String completeName){
        Optional<Person> findCompleteName = personService.findByCompleteName(completeName);
        if(findCompleteName.isPresent()){
            return ResponseEntity.ok().body(personService.findByCompleteName(completeName));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person not found");
    }


}
