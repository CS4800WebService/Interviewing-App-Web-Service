package com.example.springboottutorial.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

import com.example.springboottutorial.repository.InterviewRecordsRepository;
import com.example.springboottutorial.Models.InterviewRecords;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class InterviewRecordsController
{
    @Autowired
    InterviewRecordsRepository interviewRecordsRepository;

    @GetMapping("/interviewRecords")
    public ResponseEntity<List<InterviewRecords>> getAllInterviewRecords(@RequestParam(required = false) String title) {
        try {
            List<InterviewRecords> interviewRecords = new ArrayList<InterviewRecords>();
            // add all available records to List
            interviewRecordsRepository.findAll().forEach(interviewRecords::add);

            if (interviewRecords.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(interviewRecords, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //retrieving from db
    @GetMapping("/interviewRecords/{intervieweeId}")
    public ResponseEntity<InterviewRecords> getInterviewRecordById(@RequestParam("intervieweeId") long intervieweeId) {
        List<InterviewRecords> interviewRecordsData = interviewRecordsRepository.findByIntervieweeIdContaining((int)intervieweeId);

        if (interviewRecordsData.contains(intervieweeId)) {
            return new ResponseEntity<>(interviewRecordsData.get(interviewRecordsData.indexOf(intervieweeId)), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //getting text response from front end
    @PostMapping("/interviewRecords/answerText")
    public ResponseEntity<InterviewRecords> createAnswerText(@RequestBody InterviewRecords interviewRecords) {
        try {
            InterviewRecords _interviewRecords = interviewRecordsRepository
                .save(new InterviewRecords(interviewRecords.getAnswerText()));
            return new ResponseEntity<>(_interviewRecords, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // question creation from backend
    @PostMapping("/interviewRecords/questionText")
    public ResponseEntity<InterviewRecords> createQuestionText(@RequestBody InterviewRecords interviewRecords) {
        try {
            InterviewRecords _interviewRecords = interviewRecordsRepository
                    .save(new InterviewRecords(interviewRecords.getQuestionText()));
            return new ResponseEntity<>(_interviewRecords, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // get request for front end to retrieve questions
    @GetMapping("/interviewRecords/{intervieweeId}/questionText")
    public ResponseEntity<String> getInterviewQuestions(@PathVariable("intervieweeId") long intervieweeId) {
        List<InterviewRecords> interviewRecordsData = interviewRecordsRepository.findByIntervieweeIdContaining((int)intervieweeId);
        InterviewRecords interviewRecords = new InterviewRecords();
        try {
            if (interviewRecordsData.contains(intervieweeId)) {
                InterviewRecords _interviewRecords = interviewRecordsRepository
                        .save(new InterviewRecords(interviewRecords.getQuestionText()));
                return new ResponseEntity<>(interviewRecordsData.get(interviewRecordsData.indexOf(intervieweeId)).getQuestionText(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/interviewRecords/{intervieweeId}")
    public ResponseEntity<InterviewRecords> updateInterviewRecords(@PathVariable("intervieweeId") long intervieweeId, @RequestBody InterviewRecords interviewRecords) {
        Optional<InterviewRecords> interviewRecordsData = interviewRecordsRepository.findById(intervieweeId);

        if (interviewRecordsData.isPresent()) {
            InterviewRecords _interviewRecords = interviewRecordsData.get();
            _interviewRecords.setDateCreated(interviewRecords.getDateCreated());
            _interviewRecords.setAnswerText(interviewRecords.getAnswerText());
            _interviewRecords.setQuestionText(interviewRecords.getQuestionText());
            return new ResponseEntity<>(interviewRecordsRepository.save(_interviewRecords), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/interviewRecords/{intervieweeId}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("intervieweeId") long intervieweeId) {
        try {
            interviewRecordsRepository.deleteById(intervieweeId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/interviewRecords")
    public ResponseEntity<HttpStatus> deleteAllInterviewRecords() {
        try {
            interviewRecordsRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
