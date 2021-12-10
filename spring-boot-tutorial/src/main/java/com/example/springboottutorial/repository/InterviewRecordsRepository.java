package com.example.springboottutorial.repository;

import com.example.springboottutorial.Models.InterviewRecords;
import com.example.springboottutorial.Models.IntervieweeApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterviewRecordsRepository extends JpaRepository<InterviewRecords,Integer> {
    List<InterviewRecords> findByIntervieweeApplication(IntervieweeApplication intervieweeApplication);
}
