package com.feedback.feedbackapp.repository;

import com.feedback.feedbackapp.model.Homework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface HomeworkRepository extends JpaRepository<Homework, Long> {
    Optional<Homework> findById(Long homeworkId);
    Optional<Homework> findByName(String name);

    Optional<Homework> deleteById(Homework homework);
}