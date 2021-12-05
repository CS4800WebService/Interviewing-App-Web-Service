package com.example.springboottutorial.Models;

import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
import java.util.Objects;

public class IntervieweeUserId implements Serializable {

    @Id
    private int intervieweeId;

    @Id
    private String userName;

    public IntervieweeUserId(){}

    public IntervieweeUserId(int intervieweeId, String userName) {
        this.intervieweeId = intervieweeId;
        this.userName = userName;
    }

    public int getIntervieweeId() {
        return intervieweeId;
    }

    public void setIntervieweeId(int intervieweeId) {
        this.intervieweeId = intervieweeId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + intervieweeId;
        result = Integer.parseInt(prime * result + userName);
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
        if (intervieweeId != other.intervieweeId)
            return false;
        if (!Objects.equals(userName, other.userName))
            return false;
        return true;
    }
}
