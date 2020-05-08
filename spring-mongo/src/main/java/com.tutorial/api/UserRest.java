package com.tutorial.api;

import com.tutorial.config.MongoConfig;
import com.tutorial.entity.User;
import com.tutorial.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserRest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    @PostConstruct
    public void init(){
        User user = new User();
        user.setName("berk");
        user.setSurName("kaya");
        HashMap<String,String> hm = new HashMap<>();
        hm.put("email","xdx@gmail.com");
        hm.put("job","software developer");
        user.setFeatures(hm);
        userRepository.save(user);
    }

    @GetMapping("/mongo-template-get")
    private List<User> mongoTemplateGet(){
        return mongoTemplate.findAll(User.class);
    }

    @GetMapping("/mongo-template-criteria")
    private List<User> mongoTemplateCriteria(){
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is("xx"));
        return mongoTemplate.find(query, User.class);

    }

    @GetMapping("/mongo-template-criteria-regex")
    private List<User> mongoTemplateCriteriaRegex(){
        Query query = new Query();
        query.addCriteria(Criteria.where("name").regex("^x"));
        return mongoTemplate.find(query, User.class);

    }
    /*@GetMapping("/mongo-template-criteria-regex")
    private List<User> repositoryQuerydslPredicateExecutor(){
        //need plugins and dependencies and extend repo QuerydslPredicateExecutor<User>
        QUser qUser = new QUser("user");
        Predicate predicate = qUser.name.eq("Eric");
            return (List<User>) userRepository.findAll(predicate);
    }*/

    @GetMapping("/repository-query")
    private List<User> repositoryQuery(){
        return userRepository.findUsersByName("xx");
    }

    @GetMapping("/repository-regex")
    private List<User> repositoryRegex(){
        return userRepository.findUsersByRegexpName("xx");
    }

    @GetMapping
    private List<User> getAll(){
        return userRepository.findAll();
    }

    @PostMapping()
    private ResponseEntity<User> save(@RequestBody User user){
        return ResponseEntity.ok(userRepository.save(user));
    }

}
