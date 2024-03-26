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

    @RequestMapping(value = "/physicals",method = RequestMethod.POST)
    public ResponseEntity<PhysicalPersonDto> registerNewPhysicalPerson(@RequestBody @Valid PhysicalPersonDto physicalPersonDto){
        personService.registerNewPhysicalPerson(physicalPersonDto);
        return ResponseEntity.ok().body(physicalPersonDto);
    }

    @RequestMapping(value = "/legals",method = RequestMethod.POST)
    public ResponseEntity<LegalPersonDto> registerNewLegalPerson(@RequestBody @Valid LegalPersonDto legalPersonDto){
        personService.registerNewLegalPerson(legalPersonDto);
        return ResponseEntity.ok().body(legalPersonDto);
    }
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Person>> listAllPersons(){
        return ResponseEntity.status(HttpStatus.OK).body(personService.listAllPersons());
    }



}
