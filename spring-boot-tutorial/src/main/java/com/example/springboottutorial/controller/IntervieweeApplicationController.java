package com.example.springboottutorial.controller;

import com.example.springboottutorial.Models.Interviewee;
import com.example.springboottutorial.Models.IntervieweeApplication;
import com.example.springboottutorial.repository.IntervieweeApplicationRepository;
import com.example.springboottutorial.repository.IntervieweeRepository;
import com.example.springboottutorial.repository.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class IntervieweeApplicationController {
    @Autowired
    JobsRepository jobsRepository;
    @Autowired
    IntervieweeApplicationRepository intervieweeApplicationRepository;
    @Autowired
    IntervieweeRepository intervieweeRepository;

    // create a new application with interviewee and title
    @PostMapping("/application")
    public ResponseEntity<?> createApplication(@RequestBody IntervieweeApplication intervieweeApplication,
                                               @RequestParam int intervieweeid, @RequestParam int jobid) {
        try {
            // check if the interviewee exists
            if (intervieweeApplication != null) {
                List<Interviewee> interviewees = intervieweeRepository.findByIntervieweeid(intervieweeid);
                if(interviewees.isEmpty()){
                    return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
                }
                IntervieweeApplication application = new
                        IntervieweeApplication(interviewees.get(0),intervieweeApplication.getJob(),
                        intervieweeApplication.getTitle(),intervieweeApplication.getBody(),intervieweeApplication.getStatus());
                if (jobsRepository.existsById(jobid))
                    application.setJob(jobsRepository.getById(jobid));
                return new ResponseEntity<>(intervieweeApplicationRepository
                        .save(application), HttpStatus.CREATED);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // retrieve all applications or by status
    @GetMapping("/applications")
    public ResponseEntity<List<IntervieweeApplication>> getIntervieweeApplication(@RequestParam (required = false) String status){
        try {
            List<IntervieweeApplication> intervieweeApplication = new ArrayList<>();
            if (status == null)
                intervieweeApplication.addAll(intervieweeApplicationRepository.findAll());
            else
                intervieweeApplication.addAll(intervieweeApplicationRepository.findByStatus(status));
            if (intervieweeApplication.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(intervieweeApplication, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // to retrieve the job info with application id,
    @GetMapping("/application/{itemid}")
    public ResponseEntity<IntervieweeApplication> getApplicationById(@PathVariable("itemid") int itemid) {
        Optional<IntervieweeApplication> intervieweeApplication = intervieweeApplicationRepository.findById(itemid);
        if(intervieweeApplication.isPresent()){
            return new ResponseEntity<>(intervieweeApplication.get(), HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // to retrieve the interviewees info with application id,
    @GetMapping("/application/{itemid}/interviewee")
    public ResponseEntity<Interviewee> getEmployerByJobId(@PathVariable("itemid") int itemid) {
        Optional<IntervieweeApplication> intervieweeApplication = intervieweeApplicationRepository.findById(itemid);
        if(intervieweeApplication.isPresent()){
            return new ResponseEntity<>(intervieweeApplication.get().getInterviewee(), HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //update application info
    @PutMapping("/application")
    public ResponseEntity<IntervieweeApplication> updateApplication(@RequestBody IntervieweeApplication intervieweeApplication,
                                                                    @RequestParam (required = false) int jobid) {
        Optional<IntervieweeApplication> intervieweeApplications = intervieweeApplicationRepository.findById(intervieweeApplication.getItemid());
        if(intervieweeApplications.isPresent()){
            IntervieweeApplication _intervieweeApplication = intervieweeApplications.get();
            if (jobsRepository.existsById(jobid))
                _intervieweeApplication.setJob(jobsRepository.getById(jobid));
            else
                _intervieweeApplication.setJob(intervieweeApplication.getJob());
            _intervieweeApplication.setTitle(intervieweeApplication.getTitle());
            _intervieweeApplication.setBody(intervieweeApplication.getBody());
            _intervieweeApplication.setStatus(intervieweeApplication.getStatus());
            return new ResponseEntity<>(intervieweeApplicationRepository.save(_intervieweeApplication), HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // delete application by ID
    @DeleteMapping("/application/{itemid}")
    public ResponseEntity<HttpStatus> deleteApplicationById(@PathVariable("itemid") int itemid) {
        try {
            Optional<IntervieweeApplication> intervieweeApplicationData = intervieweeApplicationRepository.findById(itemid);
            if (intervieweeApplicationData.isPresent()) {
                IntervieweeApplication _intervieweeApplication = intervieweeApplicationData.get();
                intervieweeApplicationRepository.delete(_intervieweeApplication);
                return new ResponseEntity<>(HttpStatus.GONE);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // delete all applications
    @DeleteMapping("/applications")
    public ResponseEntity<HttpStatus> deleteAllapplication() {
        try {
            intervieweeApplicationRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
