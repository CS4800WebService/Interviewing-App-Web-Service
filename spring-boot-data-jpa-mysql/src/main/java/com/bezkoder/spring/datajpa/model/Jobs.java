package com.bezkoder.spring.datajpa.model;

import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table (name = "Jobs")
public class Jobs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "jobid")
    private int jobid;

    @ManyToOne
    @JoinColumn(name = "employerid")
    private Employer employer;

    @CreationTimestamp
    @Column(name = "datecreated")
    private Timestamp datecreated;

    @Column(name = "numhiring")
    private String numhiring;

    @Column(name = "numapplicant")
    private String numapplicant;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;

    // constructors
    public Jobs(){super();}

    public Jobs(Employer employer, String numhiring, String numapplicant, String title, String description, String status) {
        super();
        this.employer = employer;
        this.numhiring = numhiring;
        this.numapplicant = numapplicant;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    // getter and setter

    public int getJobid() {
        return jobid;
    }

    public void setJobid(int jobid) {
        this.jobid = jobid;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Timestamp getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Timestamp datecreated) {
        this.datecreated = datecreated;
    }

    public String getNumhiring() {
        return numhiring;
    }

    public void setNumhiring(String numhiring) {
        this.numhiring = numhiring;
    }

    public String getNumapplicant() {
        return numapplicant;
    }

    public void setNumapplicant(String numapplicant) {
        this.numapplicant = numapplicant;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}