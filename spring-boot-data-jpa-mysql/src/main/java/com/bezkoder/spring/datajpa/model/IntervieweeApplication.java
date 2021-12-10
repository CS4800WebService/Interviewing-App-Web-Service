package com.bezkoder.spring.datajpa.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "intervieweeapplication")
public class IntervieweeApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "itemid")
    private int itemid;

    @ManyToOne
    @JoinColumn(name = "intervieweeid")
    @JsonBackReference
    private Interviewee interviewee;

    @ManyToOne
    @JoinColumn(name = "jobid")
    @JsonBackReference(value="job-application")
    private Jobs job;

    @OneToMany(mappedBy = "intervieweeApplication")
    private Set<InterviewRecords> interviewRecords = new HashSet<>();

    @Column(name = "title")
    private String title;

    @Column(name = "body")
    private String body;

    @Column(name = "status")
    private String status;

    @CreationTimestamp
    @Column(name = "datecreated")
    private Timestamp dateCreated;

    public IntervieweeApplication() {
    }

    public IntervieweeApplication(Interviewee interviewee, Jobs job, String title, String body, String status) {
        this.interviewee = interviewee;
        this.job = job;
        this.title = title;
        this.body = body;
        this.status = status;
    }

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    public Interviewee getInterviewee() {
        return interviewee;
    }

    public void setInterviewee(Interviewee interviewee) {
        this.interviewee = interviewee;
    }

    public Jobs getJob() {
        return job;
    }

    public void setJob(Jobs job) {
        this.job = job;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Set<InterviewRecords> getInterviewRecords() {
        return interviewRecords;
    }

    public void setInterviewRecords(Set<InterviewRecords> interviewRecords) {
        this.interviewRecords = interviewRecords;
    }
}
