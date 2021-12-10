package com.bezkoder.spring.datajpa.repository;

import com.bezkoder.spring.datajpa.model.InterviewRecords;
import com.bezkoder.spring.datajpa.model.IntervieweeApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterviewRecordsRepository extends JpaRepository<InterviewRecords,Integer> {
    List<InterviewRecords> findByIntervieweeApplication(IntervieweeApplication intervieweeApplication);
}
