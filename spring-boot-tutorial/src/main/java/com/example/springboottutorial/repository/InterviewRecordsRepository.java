package com.example.springboottutorial.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springboottutorial.Models.InterviewRecords;
import org.springframework.stereotype.Repository;

@Repository
public interface InterviewRecordsRepository extends JpaRepository<InterviewRecords, Long>
{
    List<InterviewRecords> findByIntervieweeIdContaining(int intervieweeId);
    List<InterviewRecords> findByDateCreated(String dateCreated);

    /*Now we can use JpaRepository’s methods: save(), findOne(), findById(), findAll(),
    count(), delete(), deleteById()… without implementing these methods.
     */
}
