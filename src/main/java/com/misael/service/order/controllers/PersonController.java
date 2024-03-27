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

import com.misael.service.order.entities.dtos.LegalPersonDto;
import com.misael.service.order.entities.dtos.PersonDto;
import com.misael.service.order.entities.dtos.PhysicalPersonDto;
import com.misael.service.order.services.PersonService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/persons")
public class PersonController {

	@Autowired
    private PersonService personService;

	@Operation(summary = "Realiza cadastro de pessoa física", description = "Insira nome, CPF, número de contato e email")
    @PostMapping("/physicals")
    public ResponseEntity<PhysicalPersonDto> registerNewPhysicalPerson(@RequestBody @Valid PhysicalPersonDto physicalPersonDto){
        personService.registerNewPhysicalPerson(physicalPersonDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(physicalPersonDto);
    }
	@Operation(summary = "Realiza cadastro de pessoa jurídica", description = "Insira nome, CNPJ, número de contato e email")
    @PostMapping("/legals")
    public ResponseEntity<LegalPersonDto> registerNewLegalPerson(@RequestBody @Valid LegalPersonDto legalPersonDto){
        personService.registerNewLegalPerson(legalPersonDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(legalPersonDto);
    }
	@Operation(summary = "Realiza listagem de todas as pessoas cadastradas, seja física ou jurídica")
    @GetMapping
    public ResponseEntity<List<PersonDto>> listAllPersons(){
		List<PersonDto> list = personService.listAllPersons();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }



}
