package com.example.springboottutorial.controller;
import com.example.springboottutorial.Models.Employer;
import com.example.springboottutorial.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class EmployerController
{
    @Autowired
    EmployerRepository employerRepository;

    // create a new employer with username and password or with username, password, companyname
    @PostMapping("/employer")
    public ResponseEntity<Employer> createEmployer(@RequestBody Employer employer) {
        try {
            // check if the username has been used
            String userName = employer.getUsername();
            if(userName != null){
                List<Employer> employers = employerRepository.findByUsername(userName);
                if (!employers.isEmpty())
                    return new ResponseEntity<>(HttpStatus.IM_USED);
            }
            if (employer.getPassword() != null && employer.getCompanyname()!= null){
                Employer _employer = employerRepository
                        .save(employer);
                return new ResponseEntity<>(_employer, HttpStatus.CREATED);
            } else if (employer.getPassword() != null){
                Employer _employer = employerRepository
                        .save(employer);
                return new ResponseEntity<>(_employer, HttpStatus.CREATED);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get all employers or by username
    @GetMapping("/employer")
    public ResponseEntity<List<Employer>> getAllEmployer(@RequestParam(required = false) String username) {
        try {
            List<Employer> employers = new ArrayList<>();
            if (username == null)
                employers.addAll(employerRepository.findAll());
            else
                employers.addAll(employerRepository.findByUsername(username));
            if (employers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(employers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get employers by companyname
    @GetMapping("/employer/company")
    public ResponseEntity<List<Employer>> getEmployerByCompany(@RequestParam String companyname) {
        try {
            List<Employer> employers = new ArrayList<>(employerRepository.findByCompanyname(companyname));
            if (employers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(employers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // to retrieve the employer with a specific id,
    // example request url: http://localhost:8080/api/employer/1
    @GetMapping("/employer/{employerid}")
    public ResponseEntity<Employer> getEmployerbyId(@PathVariable("employerid") int employerid) {
        List<Employer> employers = employerRepository.findByEmployerid(employerid);

        if(!employers.isEmpty()){
            return new ResponseEntity<>(employers.get(0), HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //update profile Picture
    @PutMapping("/employer/{employerid}/profilepic")
    public ResponseEntity<Employer> updateProfilePic(@PathVariable("employerid") int employerid, @RequestParam Blob profilepic) {
        List<Employer> intervieweeData = employerRepository.findByEmployerid(employerid);

        if (!intervieweeData.isEmpty()) {
            Employer _employer = intervieweeData.get(0);
            _employer.setProfilepic(profilepic);
            return new ResponseEntity<>(employerRepository.save(_employer), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //update company name
    @PutMapping("/employer/{employerid}/company")
    public ResponseEntity<Employer> updateFirstLastName(@PathVariable("employerid") int employerid, @RequestParam String companyname) {
        List<Employer> employerData = employerRepository.findByEmployerid(employerid);
        if (!employerData.isEmpty()) {
            Employer _employer = employerData.get(0);
            _employer.setCompanyname(companyname);
            return new ResponseEntity<>(employerRepository.save(_employer), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //update company status
    @PutMapping("/employer/{employerid}/status")
    public ResponseEntity<Employer> updateCompanyStatus(@PathVariable("employerid") int employerid, @RequestParam String status) {
        List<Employer> employerData = employerRepository.findByEmployerid(employerid);
        if (!employerData.isEmpty()) {
            Employer _employer = employerData.get(0);
            _employer.setStatus(status);
            return new ResponseEntity<>(employerRepository.save(_employer), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // delete employer by ID
    @DeleteMapping("/employer/{employerid}")
    public ResponseEntity<HttpStatus> deleteEmployerById(@PathVariable("employerid") int employerid) {
        try {
            List<Employer> employerData = employerRepository.findByEmployerid(employerid);
            if (employerData.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            Employer _employer = employerData.get(0);
            employerRepository.delete(_employer);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // delete all employers
    @DeleteMapping("/employers")
    public ResponseEntity<HttpStatus> deleteAllEmployers() {
        try {
            employerRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
