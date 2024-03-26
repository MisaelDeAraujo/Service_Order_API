package com.misael.service.order.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.misael.service.order.entities.Person;
import com.misael.service.order.entities.dtos.LegalPersonDto;
import com.misael.service.order.entities.dtos.PhysicalPersonDto;
import com.misael.service.order.services.PersonService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/persons")
public class PersonController {

	@Autowired
    private PersonService personService;

    @PostMapping("/physicals")
    public ResponseEntity<PhysicalPersonDto> registerNewPhysicalPerson(@RequestBody @Valid PhysicalPersonDto physicalPersonDto){
        personService.registerNewPhysicalPerson(physicalPersonDto);
        return ResponseEntity.status(HttpStatus.OK).body(physicalPersonDto);
    }

    @PostMapping("/legals")
    public ResponseEntity<LegalPersonDto> registerNewLegalPerson(@RequestBody @Valid LegalPersonDto legalPersonDto){
        personService.registerNewLegalPerson(legalPersonDto);
        return ResponseEntity.status(HttpStatus.OK).body(legalPersonDto);
    }
    @GetMapping
    public ResponseEntity<List<Person>> listAllPersons(){
    	List<Person> persons = personService.listAllPersons();
        return ResponseEntity.status(HttpStatus.OK).body(persons);
    }



}
