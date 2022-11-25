package com.example.HealthDiary.domain.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Table(name = "User")
@NoArgsConstructor

public class User {

    @Id
    private String id;

    private String name;

    private String password;

    private String email;


}
