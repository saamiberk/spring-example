package com.tutorial.api;

import com.tutorial.entity.Person;
import com.tutorial.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/Person")
public class PersonRest {

    private PersonRepository personRepository;

    @GetMapping
    public List<Person> getPersons(String name, String surname){
        List<Person> personList = personRepository.findByNameOrSurName(name, surname);
        return personList;
    }

}
