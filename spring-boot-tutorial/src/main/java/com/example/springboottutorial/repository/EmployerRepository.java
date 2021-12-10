package com.example.springboottutorial.repository;
import java.util.List;
import com.example.springboottutorial.Models.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Integer> {
    List<Employer> findByEmployerid(Integer intervieweeid);
    List<Employer> findByUsername(String username);
    List<Employer> findByCompanyname(String companyname);
}
