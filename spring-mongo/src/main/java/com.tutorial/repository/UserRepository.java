package com.tutorial.repository;

import com.tutorial.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
    @Query("{ 'name' : ?0 }")
    List<User> findUsersByName(String name);
    @Query("{ 'name' : { $regex: ?0 } }")
    List<User> findUsersByRegexpName(String regexp);
}
