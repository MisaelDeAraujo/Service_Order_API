package com.misael.service.order.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misael.service.order.entities.Person;
import com.misael.service.order.entities.dtos.PersonDto;
import com.misael.service.order.entities.enums.PersonRegisteredType;
import com.misael.service.order.exceptions.PersonNotFoundException;
import com.misael.service.order.repositories.PersonRepository;

import lombok.Builder;

@Builder
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public PersonDto registerNewPerson(PersonDto personDto){
    	
    	if(personDto.document().length() == 14) {
            var person = Person.builder()
                    .completeName(personDto.completeName().toUpperCase())
                    .cnpj(personDto.document())
                    .cellphone(personDto.cellphone())
                    .email(personDto.email())
                    .personType(PersonRegisteredType.LEGAL)
                    .personCreatedDate(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))
                    .build();
            personRepository.save(person);
            return personDto;
    	}else if(personDto.document().length() == 11) {
            var person = Person.builder()
                    .completeName(personDto.completeName().toUpperCase())
                    .cpf(personDto.document())
                    .cellphone(personDto.cellphone())
                    .email(personDto.email())
                    .personType(PersonRegisteredType.PHYSYCAL)
                    .personCreatedDate(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))
                    .build();
            personRepository.save(person);
            return personDto;
    	}
    	
    	return personDto;


    }
    public List<PersonDto> listAllPersons(){
    	
    	List<Person> allPersons =  personRepository.findAll();
    	List<PersonDto> dtos = new ArrayList<>();
    	for (Person person : allPersons) {
    		if(person.getPersonType() == PersonRegisteredType.PHYSYCAL) {
    			PersonDto dtoPhysycal = PersonDto.builder()
    					.completeName(person.getCompleteName())
    					.document(person.getCpf())
    					.cellphone(person.getCellphone())
    					.email(person.getEmail())
    					.build();
    			dtos.add(dtoPhysycal);	
    		}
    		if(person.getPersonType() == PersonRegisteredType.LEGAL) {
    			PersonDto dtoLegal = PersonDto.builder()
    					.completeName(person.getCompleteName())
    					.document(person.getCnpj())
    					.cellphone(person.getCellphone())
    					.email(person.getEmail())
    					.build();
    			dtos.add(dtoLegal);	
    		}
		}
 
    	
    	return dtos;
    }

    public Optional<Person> findByCompleteName(String completeName){
        if(personRepository.findByCompleteName(completeName).isEmpty()){
            throw new PersonNotFoundException();
        }
        return personRepository.findByCompleteName(completeName);
    }


}
