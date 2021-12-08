package com.bezkoder.spring.datajpa.repository;

import com.bezkoder.spring.datajpa.model.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobsRepository extends JpaRepository<Jobs, Integer>{
    List<Jobs> findByStatus(String status);
}
