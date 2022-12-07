package com.example.HealthDiary.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Getter
@Table(name = "diary")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Diary {
    @Id
    private String diaryId;
    private String userId;

    private String conditions;
    private String headache;
    private String waistPain;
//    @Id
    private Timestamp date;


    @Column(columnDefinition = "TEXT")
    private String appendixMemo;
}
