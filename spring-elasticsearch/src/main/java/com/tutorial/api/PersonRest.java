package com.tutorial.api;

import com.tutorial.entity.Person;
import com.tutorial.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/persons")
public class PersonRest {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    public List<Person> getPersons(String name, String surname){
        List<Person> personList = personRepository.findByNameOrSurName(name, surname);
        return personList;
    }

    @GetMapping("/count")
    public long getPersonsCount(){
        return personRepository.count();
    }

    @GetMapping("/contains/comment/{word}")
    public List<Person> getPersonCommentByWord(@PathVariable String word){
        return personRepository.findBySocialCommentContains(word);
    }

}
