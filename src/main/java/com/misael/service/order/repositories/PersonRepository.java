package com.misael.service.order.repositories;

import com.misael.service.order.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    Optional<Person> findByCompleteName(String completeName);

    Optional<Person> findByCnpj(String cnpj);


}
