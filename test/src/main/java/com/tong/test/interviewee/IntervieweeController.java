package com.tong.test.interviewee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path =  "api/v1/interviewee")
public class IntervieweeController {

    private final IntervieweeService intervieweeService;

    @Autowired
    public IntervieweeController(IntervieweeService intervieweeService) {
        this.intervieweeService = intervieweeService;
    }

    @RequestMapping("/listInterviewees")
    public List<Interviewee> getInterviewees() {
        return intervieweeService.getInterviewees();
    }

    @GetMapping("/listInterviewees/{intervieweeId}")
    public Interviewee getInterviewee(@PathVariable String intervieweeId) {
        return this.intervieweeService.getInterviewee(Long.parseLong(intervieweeId));
    }

    @PostMapping(path = "/addInterviewee")
    public Interviewee addInterviewee(@RequestBody Interviewee interviewee) {
        return this.intervieweeService.addInterviewee(interviewee);
    }
}
