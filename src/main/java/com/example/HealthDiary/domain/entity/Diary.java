package com.example.HealthDiary.domain.entity;


import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter

public class Diary {
    @Id
    private String userId;

    private String conditions;

    private String pain;

    private String feeling;

    @Column(columnDefinition = "TEXT")
    private String appendixMemo;
}
