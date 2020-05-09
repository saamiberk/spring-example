package com.tutorial.repository;

import com.tutorial.entity.Person;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends ElasticsearchRepository<Person, String> {
    //todo regex vs
    List<Person> findByNameOrSurName(String name, String surName);
}
