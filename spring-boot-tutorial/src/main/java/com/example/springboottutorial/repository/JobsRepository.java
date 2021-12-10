package com.example.springboottutorial.repository;

import com.example.springboottutorial.Models.Employer;
import com.example.springboottutorial.Models.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobsRepository extends JpaRepository<Jobs, Integer>{
    List<Jobs> findByStatus(String status);
    List<Jobs> findByEmployer(Employer employer);
}
