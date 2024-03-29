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

import com.misael.service.order.entities.dtos.PersonDto;
import com.misael.service.order.services.PersonService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/persons")
@Tag(name = "service-order-api")
public class PersonController {

	@Autowired
    private PersonService personService;

	@Operation(summary = "Realiza cadastro de pessoa Física ou Jurídica", description = "Insira nome, CPF/CNPJ, número de contato e email")
    @PostMapping("/physicals")
    public ResponseEntity<PersonDto> registerNewPerson(@RequestBody @Valid PersonDto personDto){
        PersonDto dto =  personService.registerNewPerson(personDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

	@Operation(summary = "Realiza listagem de todas as pessoas cadastradas, seja física ou jurídica")
    @GetMapping
    public ResponseEntity<List<PersonDto>> listAllPersons(){
		List<PersonDto> list = personService.listAllPersons();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }



}
