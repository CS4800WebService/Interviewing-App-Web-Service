package com.example.springboottutorial.controller;

import com.example.springboottutorial.Models.Employer;
import com.example.springboottutorial.Models.Jobs;
import com.example.springboottutorial.repository.EmployerRepository;
import com.example.springboottutorial.repository.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class JobsController {
    @Autowired
    JobsRepository jobsRepository;
    @Autowired
    EmployerRepository employerRepository;

    // create a new job with employer and title
    @PostMapping("/jobs")
    public ResponseEntity<?> createJob(@RequestParam String title, @RequestBody Employer employer) {
        try {
            // check if the employer exists
            List<Employer> employers = employerRepository.findByEmployerid(employer.getEmployerid());
            if(employers.isEmpty()){
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
            if (title != null) {
                Jobs _job = new Jobs();
                _job.setEmployer(employers.get(0));
                _job.setTitle(title);
                return new ResponseEntity<>(jobsRepository
                        .save(_job), HttpStatus.CREATED);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // retrieve all the jobs or by status
    @GetMapping("/jobs")
    public ResponseEntity<List<Jobs>> getJobs(@RequestParam (required = false) String status){
        try {
            List<Jobs> jobs = new ArrayList<>();
            if (status == null)
                jobs.addAll(jobsRepository.findAll());
            else
                jobs.addAll(jobsRepository.findByStatus(status));
            if (jobs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(jobs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // to retrieve the job info with a specific job id,
    // example request url: http://localhost:8080/api/jobs/1
    @GetMapping("/jobs/{jobid}")
    public ResponseEntity<Jobs> getJobById(@PathVariable("jobid") int jobid) {
        Optional<Jobs> jobs = jobsRepository.findById(jobid);
        if(jobs.isPresent()){
            return new ResponseEntity<>(jobs.get(), HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // to retrieve the employers with a specific job id,
    // example request url: http://localhost:8080/api/jobs/1
    @GetMapping("/jobs/{jobid}/employer")
    public ResponseEntity<Employer> getEmployerByJobId(@PathVariable("jobid") int jobid) {
        Optional<Jobs> jobs = jobsRepository.findById(jobid);
        if(jobs.isPresent()){
            return new ResponseEntity<>(jobs.get().getEmployer(), HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //update job info
    @PutMapping("/job")
    public ResponseEntity<Jobs> updateFirstLastName(@RequestBody Jobs job) {
        Optional<Jobs> jobs = jobsRepository.findById(job.getJobid());
        if(jobs.isPresent()){
            Jobs _job = jobs.get();
            _job.setTitle(job.getTitle());
            _job.setStatus(job.getStatus());
            _job.setDescription(job.getDescription());
            _job.setNumapplicant(job.getNumapplicant());
            _job.setNumhiring(job.getNumhiring());
            return new ResponseEntity<>(jobsRepository.save(_job), HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // delete job by ID
    @DeleteMapping("/job/{jobid}")
    public ResponseEntity<HttpStatus> deleteJobById(@PathVariable("jobid") int jobid) {
        try {
            Optional<Jobs> jobData = jobsRepository.findById(jobid);
            if (jobData.isPresent()) {
                Jobs _job = jobData.get();
                jobsRepository.delete(_job);
                return new ResponseEntity<>(HttpStatus.GONE);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // delete all jobs
    @DeleteMapping("/jobs")
    public ResponseEntity<HttpStatus> deleteAllJobs() {
        try {
            jobsRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
