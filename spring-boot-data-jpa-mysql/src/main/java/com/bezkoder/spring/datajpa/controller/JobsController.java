package com.bezkoder.spring.datajpa.controller;

import com.bezkoder.spring.datajpa.repository.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class JobsController {
    @Autowired
    JobsRepository jobsRepository;


}
