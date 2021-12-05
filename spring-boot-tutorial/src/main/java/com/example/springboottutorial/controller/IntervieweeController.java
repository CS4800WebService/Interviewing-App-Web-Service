package com.example.springboottutorial.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.springboottutorial.repository.InterviewRecordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboottutorial.repository.IntervieweeRepository;
import com.example.springboottutorial.Models.Interviewee;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class IntervieweeController
{
    @Autowired
    IntervieweeRepository intervieweeRepository;

    @PostMapping("/interviewee")
    public ResponseEntity<Interviewee> createInterviewee(@RequestBody Interviewee interviewee) {
        try {
            Interviewee _interviewee = intervieweeRepository
                    .save(new Interviewee(interviewee.getUserName(), interviewee.getPassword()));
            return new ResponseEntity<>(_interviewee, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/interviewee")
    public ResponseEntity<List<Interviewee>> getAllInterviewee(@RequestParam(required = false) String userName) {
        try {
            List<Interviewee> interviewees = new ArrayList<Interviewee>();

            if (userName == null)
                intervieweeRepository.findAll().forEach(interviewees::add);
            else
                intervieweeRepository.findByUserNameContaining(userName).forEach(interviewees::add);

            if (interviewees.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(interviewees, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
