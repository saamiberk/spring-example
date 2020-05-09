package com.tutorial;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tutorial.entity.Person;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.io.File;
import java.io.IOException;
import java.util.List;

@SpringBootApplication
@EnableElasticsearchRepositories
public class ElasticSearchApplication implements CommandLineRunner {

    private String jsonPath = "D:\\git\\spring-example\\json.json";

    public static void main(String[] args)  {
        SpringApplication.run(ElasticSearchApplication.class, args);
        System.out.println("Test");
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Run Test");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<Person> persons = objectMapper.readValue(new File(jsonPath), new TypeReference<List<Person>>(){});
            for (Person person:persons)
                System.out.println(person);
            //todo saves method
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
