package com.example.HealthDiary.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Table(name = "User")
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class User {

    @Id
    private String id;

    private String name;

    private String password;

    private String email;


}
