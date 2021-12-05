package com.example.springboottutorial.repository;
import java.util.List;
import java.util.Optional;

import com.example.springboottutorial.Models.Interviewee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntervieweeRepository extends JpaRepository<Interviewee, Long> {
    List<Interviewee> findByIntervieweeIdContaining(int intervieweeId);
    List<Interviewee> findByUserNameContaining(String userName);
}
