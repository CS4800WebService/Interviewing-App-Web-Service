package com.bezkoder.spring.datajpa.repository;
import java.util.List;

import com.bezkoder.spring.datajpa.model.Interviewee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntervieweeRepository extends JpaRepository<Interviewee, Integer> {
    List<Interviewee> findByIntervieweeid(Integer intervieweeid);
    List<Interviewee> findByUsername(String username);
}
