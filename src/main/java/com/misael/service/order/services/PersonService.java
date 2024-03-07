package com.misael.service.order.services;

import com.misael.service.order.entities.Person;
import com.misael.service.order.exceptions.PersonNotFoundException;
import com.misael.service.order.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Builder
@AllArgsConstructor
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person registerNewPerson(Person person){
        return personRepository.save(person);

    }
    public Optional<Person> findById(Integer id){
        return personRepository.findById(id);
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



}
