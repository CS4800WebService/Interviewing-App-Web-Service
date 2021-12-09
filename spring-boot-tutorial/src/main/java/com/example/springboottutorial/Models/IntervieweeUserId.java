package com.example.springboottutorial.Models;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Objects;

public class IntervieweeUserId implements Serializable {

    @Id
    private int intervieweeid;

    @Id
    private String username;

    public IntervieweeUserId(){}

    public IntervieweeUserId(int intervieweeid, String username) {
        this.intervieweeid = this.intervieweeid;
        this.username = username;
    }

    public int getIntervieweeid() {
        return intervieweeid;
    }

    public void setIntervieweeid(int intervieweeid) {
        this.intervieweeid = intervieweeid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + intervieweeid;
        result = Integer.parseInt(prime * result + username);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        IntervieweeUserId other = (IntervieweeUserId) obj;
        if (intervieweeid != other.intervieweeid)
            return false;
        if (!Objects.equals(username, other.username))
            return false;
        return true;
    }
}
