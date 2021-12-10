package com.example.springboottutorial.repository;

import com.example.springboottutorial.Models.Interviewee;
import com.example.springboottutorial.Models.IntervieweeApplication;
import com.example.springboottutorial.Models.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IntervieweeApplicationRepository extends JpaRepository<IntervieweeApplication, Integer> {
    List<IntervieweeApplication> findByStatus(String status);
    List<IntervieweeApplication> findByInterviewee(Interviewee interviewee);
    List<IntervieweeApplication> findByJob(Jobs job);
}
