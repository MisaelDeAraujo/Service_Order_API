package com.misael.service.order.controllers;

import com.misael.service.order.entities.Person;
import com.misael.service.order.entities.dtos.LegalPersonDto;
import com.misael.service.order.entities.dtos.PhysicalPersonDto;
import com.misael.service.order.services.PersonService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/persons")
public class PersonController {

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
