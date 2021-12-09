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

    // create a new interviewee with username and password or with username, password, firstname, and lastname
    @PostMapping("/interviewee")
    public ResponseEntity<Interviewee> createInterviewee(@RequestBody Interviewee interviewee) {
        try {
            // check if the username has been used
            String userName = interviewee.getUsername();
            if(userName != null){
                List<Interviewee> interviewees = intervieweeRepository.findByUsername(userName);
                if (!interviewees.isEmpty())
                    return new ResponseEntity<>(HttpStatus.IM_USED);
            }
            if (interviewee.getPassword() != null && interviewee.getFirstname()!=null && interviewee.getLastname()!= null){
                Interviewee _interviewee = intervieweeRepository
                        .save(interviewee);
                return new ResponseEntity<>(_interviewee, HttpStatus.CREATED);
            } else if (interviewee.getPassword() != null){
                Interviewee _interviewee = intervieweeRepository
                        .save(interviewee);
                return new ResponseEntity<>(_interviewee, HttpStatus.CREATED);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get all interviewees or by username
    @GetMapping("/interviewee")
    public ResponseEntity<List<Interviewee>> getAllInterviewee(@RequestParam(required = false) String username) {
        try {
            List<Interviewee> interviewees = new ArrayList<Interviewee>();
            if (username == null)
                interviewees.addAll(intervieweeRepository.findAll());
            else
                interviewees.addAll(intervieweeRepository.findByUsername(username));
            if (interviewees.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(interviewees, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // to retrieve the interviewee with a specific id,
    // example request url: http://localhost:8080/api/interviewee/1
    @GetMapping("/interviewee/{intervieweeid}")
    public ResponseEntity<Interviewee> getIntervieweebyId(@PathVariable("intervieweeid") int intervieweeid) {
        List<Interviewee> interviewees = intervieweeRepository.findByIntervieweeid(intervieweeid);

        if(!interviewees.isEmpty()){
            return new ResponseEntity<>(interviewees.get(0), HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //update profile Picture
    @PutMapping("/interviewee/{intervieweeid}/profilepic")
    public ResponseEntity<Interviewee> updateProfilePic(@PathVariable("intervieweeid") int intervieweeid, @RequestParam Blob profilepic) {
        List<Interviewee> intervieweeData = intervieweeRepository.findByIntervieweeid(intervieweeid);

        if (!intervieweeData.isEmpty()) {
            Interviewee _interviewee = intervieweeData.get(0);
            _interviewee.setProfilepic(profilepic);
            return new ResponseEntity<>(intervieweeRepository.save(_interviewee), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //update firstname and last name
    @PutMapping("/interviewee/{intervieweeid}/name")
    public ResponseEntity<Interviewee> updateFirstLastName(@PathVariable("intervieweeid") int intervieweeid, @RequestParam String firstname, @RequestParam String lastname) {
        List<Interviewee> intervieweeData = intervieweeRepository.findByIntervieweeid(intervieweeid);
        if (!intervieweeData.isEmpty()) {
            Interviewee _interviewee = intervieweeData.get(0);
            _interviewee.setFirstname(firstname);
            _interviewee.setLastname(lastname);
            return new ResponseEntity<>(intervieweeRepository.save(_interviewee), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // delete interviewee by ID
    @DeleteMapping("/interviewee/{intervieweeid}")
    public ResponseEntity<HttpStatus> deleteIntervieweeById(@PathVariable("intervieweeid") int intervieweeid) {
        try {
            List<Interviewee> intervieweeData = intervieweeRepository.findByIntervieweeid(intervieweeid);
            if (intervieweeData.isEmpty())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            Interviewee _interviewee = intervieweeData.get(0);
            intervieweeRepository.delete(_interviewee);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // delete all interviewees
    @DeleteMapping("/interviewees")
    public ResponseEntity<HttpStatus> deleteAllInterviewees() {
        try {
            intervieweeRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
