package com.example.HealthDiary.domain.entity;


import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Table(name = "diary")
public class Diary {
    @Id
    private String userId;

    private String conditions;
    private String headache;
    private String waistPain;



    @Column(columnDefinition = "TEXT")
    private String appendixMemo;
}
