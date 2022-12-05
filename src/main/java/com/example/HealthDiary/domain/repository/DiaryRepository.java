package com.example.HealthDiary.domain.repository;

import com.example.HealthDiary.domain.entity.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiaryRepository extends JpaRepository<Diary,String> {
    @Query("select d from Diary d where d.userId = :UserId")
    List<Diary> findByUserId(@Param("UserId") String user_id);

}
