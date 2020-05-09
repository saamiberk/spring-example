package com.tutorial.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Document(indexName = "persons", type = "person",
        createIndex = true, replicas = 1)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person {
    @Id
    private String id;
    @Field(name = "name", type = FieldType.Text)
    private String name;
    @Field(name = "surName", type = FieldType.Text)
    private String surName;
    @Field(name = "email", type = FieldType.Text)
    private String email;
    @Field(name = "married", type = FieldType.Boolean)
    private boolean married;
    @Field(name = "age", type = FieldType.Integer)
    private int age;
    @Field(name = "point", type = FieldType.Double)
    private double point;
    @Field(type = FieldType.Nested, includeInParent = true)
    private Social social;

}
