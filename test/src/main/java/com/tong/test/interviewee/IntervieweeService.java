package com.tong.test.interviewee;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IntervieweeService {

    List<Interviewee> intervieweeList;

    public IntervieweeService() {
        intervieweeList = new ArrayList<>();
        intervieweeList.add(new Interviewee(
                1L,
                "davisInterviewee1",
                "totallysecurepassword",
                "davis","banana",
                11302021));
        intervieweeList.add(new Interviewee(
                2L,
                "mymom543",
                "secrets",
                "my","mom",
                12012021));

    }

    public List<Interviewee> getInterviewees() {
        return intervieweeList;
    }

    public Interviewee getInterviewee(Long id) {
        Interviewee i = null;
        for(Interviewee interviewee:intervieweeList) {
            if(interviewee.getIntervieweeId() == id) {
                i = interviewee;
                break;
            }
        }
        return i;
    }

    public Interviewee addInterviewee(Interviewee interviewee) {
        intervieweeList.add(interviewee);
        return interviewee;
    }
}
