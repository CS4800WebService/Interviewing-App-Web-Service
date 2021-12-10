package com.example.springboottutorial.repository;

import com.example.springboottutorial.Models.Interviewee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IntervieweeRepository extends JpaRepository<Interviewee, Integer> {
    List<Interviewee> findByIntervieweeid(Integer intervieweeid);
    List<Interviewee> findByUsername(String username);
}
