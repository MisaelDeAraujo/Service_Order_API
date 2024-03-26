package com.misael.service.order.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misael.service.order.entities.Person;
import com.misael.service.order.entities.dtos.LegalPersonDto;
import com.misael.service.order.entities.dtos.PhysicalPersonDto;
import com.misael.service.order.exceptions.PersonNotFoundException;
import com.misael.service.order.repositories.PersonRepository;

import lombok.Builder;

@Builder
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person registerNewPhysicalPerson(PhysicalPersonDto physicalPersonDto){
        var person = Person.builder()
                .completeName(physicalPersonDto.completeName())
                .cpf(physicalPersonDto.cpf())
                .cellphone(physicalPersonDto.cellphone())
                .email(physicalPersonDto.email())
                .personCreatedDate(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))
                .build();
        return personRepository.save(person);

    }
    public List<Person> listAllPersons(){
        return personRepository.findAll();
    }

    public Optional<Person> findByCompleteName(String completeName){
        if(personRepository.findByCompleteName(completeName).isEmpty()){
            throw new PersonNotFoundException();
        }
        return personRepository.findByCompleteName(completeName);
    }


    public Person registerNewLegalPerson(LegalPersonDto legalPersonDto) {
        var person = Person.builder()
                .completeName(legalPersonDto.completeName())
                .cnpj(legalPersonDto.cnpj())
                .cellphone(legalPersonDto.cellphone())
                .email(legalPersonDto.email())
                .personCreatedDate(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))
                .build();
        return personRepository.save(person);
    }
}
