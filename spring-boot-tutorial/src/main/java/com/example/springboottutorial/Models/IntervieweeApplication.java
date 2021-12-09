package com.example.springboottutorial.Models;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "intervieweeapplication")
public class IntervieweeApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "itemid")
    private String itemid;

    @Column(name = "intervieweeid")
    private String intervieweeid;

    @Column(name = "jobid")
    private String jobid;

    @Column(name = "status")
    private String status;

    @CreationTimestamp
    @Column(name = "datecreated")
    private Timestamp dateCreated;

    public IntervieweeApplication(String itemid, String intervieweeid, String jobid, String status, Timestamp dateCreated)
    {
        this.itemid = itemid;
        this.jobid = jobid;
        this.status = status;
        this.dateCreated = dateCreated;
    }

    public IntervieweeApplication() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public String getIntervieweeid() {
        return intervieweeid;
    }

    public void setIntervieweeid(String intervieweeid) {
        this.intervieweeid = intervieweeid;
    }

    public String getJobid() {
        return jobid;
    }

    public void setJobid(String jobid) {
        this.jobid = jobid;
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
}
