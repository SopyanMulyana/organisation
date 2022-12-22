package com.mitrais.organisation.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@Document(collection = "user")
@AllArgsConstructor
public class User {
    @Id
    private String id;

    private String name;

    private int age;
}
