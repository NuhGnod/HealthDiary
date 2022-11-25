package com.example.HealthDiary.domain.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
public class Admin {
    @Id
    private String adminId;

    private String password;

}
