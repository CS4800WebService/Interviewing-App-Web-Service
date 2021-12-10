package com.bezkoder.spring.datajpa.repository;

import com.bezkoder.spring.datajpa.model.Interviewee;
import com.bezkoder.spring.datajpa.model.IntervieweeApplication;
import com.bezkoder.spring.datajpa.model.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IntervieweeApplicationRepository extends JpaRepository<IntervieweeApplication, Integer> {
    List<IntervieweeApplication> findByStatus(String status);
    List<IntervieweeApplication> findByInterviewee(Interviewee interviewee);
    List<IntervieweeApplication> findByJob(Jobs job);
}
