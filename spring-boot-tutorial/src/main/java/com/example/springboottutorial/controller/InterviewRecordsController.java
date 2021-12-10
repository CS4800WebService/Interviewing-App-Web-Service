package com.example.springboottutorial.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.springboottutorial.repository.IntervieweeApplicationRepository;
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

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class InterviewRecordsController {
    @Autowired
    InterviewRecordsRepository interviewRecordsRepository;
    @Autowired
    IntervieweeApplicationRepository intervieweeApplicationRepository;

    // create a new interview record
    @PostMapping("/application/record")
    ResponseEntity<InterviewRecords> createIntervieweeRecord(@RequestParam("itemid") int itemid, @RequestBody InterviewRecords interviewRecords){
        try {
            if(intervieweeApplicationRepository.existsById(itemid)){
                InterviewRecords record = new InterviewRecords();
                record.setIntervieweeApplication(intervieweeApplicationRepository.getById(itemid));
                record.setAnswertext(interviewRecords.getAnswertext());
                record.setAnswervideo(interviewRecords.getAnswervideo());
                record.setAnswervideolink(interviewRecords.getAnswervideolink());
                record.setQuestiontext(interviewRecords.getQuestiontext());
                record.setQuestionvideo(interviewRecords.getQuestionvideo());
                record.setQuestionvideolink(interviewRecords.getQuestionvideolink());
                record.setFaceres(interviewRecords.getFaceres());
                record.setTextres(interviewRecords.getTextres());
                record.setVoiceres(interviewRecords.getVoiceres());
                return new ResponseEntity<>(interviewRecordsRepository.save(record), HttpStatus.CREATED);
            }
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // create a new interview record
    @PostMapping("/record")
    ResponseEntity<InterviewRecords> createRecord(@RequestBody InterviewRecords interviewRecords){
        try {
            if(interviewRecords != null){
                return new ResponseEntity<>(interviewRecordsRepository.save(interviewRecords), HttpStatus.CREATED);
            }
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //retrieve all records
    @GetMapping("/records")
    public ResponseEntity<List<InterviewRecords>> getRecords(){
        try {
            List<InterviewRecords> interviewRecords = new ArrayList<>(interviewRecordsRepository.findAll());
            if (interviewRecords.isEmpty()){
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(interviewRecords, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // retrieve a record by record id
    @GetMapping("/record/{recordid}")
    public ResponseEntity<InterviewRecords> getRecordById(@PathVariable("recordid") int recordid){
        Optional<InterviewRecords> interviewRecords = interviewRecordsRepository.findById(recordid);
        if(interviewRecords.isPresent()){
            return new ResponseEntity<>(interviewRecords.get(), HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    // retrieve records by application id
    @GetMapping("/application/{itemid}/records")
    public ResponseEntity<List<InterviewRecords>> getRecordByApplicationId(@PathVariable("itemid") int itemid){
        List<InterviewRecords> interviewRecords = interviewRecordsRepository.findByIntervieweeApplication(intervieweeApplicationRepository.getById(itemid));
        if(interviewRecords.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        else
            return new ResponseEntity<>(interviewRecords, HttpStatus.OK);
    }

    // update a record
    @PutMapping("/record")
    public ResponseEntity<InterviewRecords> updateRecordInfo(@RequestBody InterviewRecords interviewRecords){
        Optional<InterviewRecords> recordData = interviewRecordsRepository.findById(interviewRecords.getRecordid());
        if (recordData.isPresent()){
            InterviewRecords record = recordData.get();
            if(interviewRecords.getIntervieweeApplication()!=null)
                record.setIntervieweeApplication(interviewRecords.getIntervieweeApplication());
            if(interviewRecords.getAnswertext()!=null)
                record.setAnswertext(interviewRecords.getAnswertext());
            if(interviewRecords.getAnswervideo()!=null)
                record.setAnswervideo(interviewRecords.getAnswervideo());
            if(interviewRecords.getAnswervideolink()!=null)
                record.setAnswervideolink(interviewRecords.getAnswervideolink());
            if(interviewRecords.getQuestiontext()!=null)
                record.setQuestiontext(interviewRecords.getQuestiontext());
            if(interviewRecords.getQuestionvideo()!=null)
                record.setQuestionvideo(interviewRecords.getQuestionvideo());
            if(interviewRecords.getQuestionvideolink()!=null)
                record.setQuestionvideolink(interviewRecords.getQuestionvideolink());
            if(interviewRecords.getFaceres()!=null)
                record.setFaceres(interviewRecords.getFaceres());
            if(interviewRecords.getTextres()!=null)
                record.setTextres(interviewRecords.getTextres());
            if(interviewRecords.getVoiceres()!=null)
                record.setVoiceres(interviewRecords.getVoiceres());
            return new ResponseEntity<>(interviewRecordsRepository.save(record), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    // delete record by id
    @DeleteMapping("/record/{recordid}")
    public ResponseEntity<HttpStatus> deleteRecordById(@PathVariable("recordid") int recordid){
        try {
            Optional<InterviewRecords> interviewRecords = interviewRecordsRepository.findById(recordid);
            if (interviewRecords.isPresent()) {
                InterviewRecords _record = interviewRecords.get();
                interviewRecordsRepository.delete(_record);
                return new ResponseEntity<>(HttpStatus.GONE);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //delete all records
    @DeleteMapping("/records")
    public ResponseEntity<HttpStatus> deleteAllRecords() {
        try {
            interviewRecordsRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
