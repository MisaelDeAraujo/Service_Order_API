package com.misael.service.order.controllers;

import com.misael.service.order.entities.dtos.LegalPersonDto;
import com.misael.service.order.entities.dtos.PhysicalPersonDto;
import com.misael.service.order.services.PersonService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/persons")
public class PersonController {

    private PersonService personService;

    @RequestMapping(value = "/physicals",method = RequestMethod.POST)
    public ResponseEntity<Object> registerNewPhysicalPerson(@RequestBody @Valid PhysicalPersonDto physicalPersonDto){
        return ResponseEntity.ok().body(personService.registerNewPhysicalPerson(physicalPersonDto));
    }

    @RequestMapping(value = "/legals",method = RequestMethod.POST)
    public ResponseEntity<Object> registerNewLegalPerson(@RequestBody @Valid LegalPersonDto legalPersonDto){
        return ResponseEntity.ok().body(personService.registerNewLegalPerson(legalPersonDto));
    }
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> listAllPersons(){
        return ResponseEntity.status(HttpStatus.FOUND).body(personService.listAllPersons());
    }

    @RequestMapping(value = "/{completeName}",method = RequestMethod.GET)
    public ResponseEntity<Object> findPersonByCompleteName(@RequestParam(value = "completeName")
                                                               @Valid String completeName){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(completeName);
    }



}
