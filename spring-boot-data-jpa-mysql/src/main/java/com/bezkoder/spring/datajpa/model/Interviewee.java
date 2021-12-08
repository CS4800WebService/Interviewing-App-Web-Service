package com.bezkoder.spring.datajpa.model;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Blob;
import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table (name = "Interviewee")
@IdClass(IntervieweeUserId.class)
public class Interviewee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "intervieweeid")
    private int intervieweeid;

    @Id
    @Column(name = "username")
    private String username;

    @CreationTimestamp
    @Column(name = "datecreated")
    private Timestamp datecreated;

    @Column(name = "password")
    private String password;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Lob
    @Column(name = "profilepic")
    private Blob profilepic;

    public Interviewee() {
    }

    public Interviewee(String firstname, String lastname, String username, String password)
    {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
    }

    //front end to create a new user with username and password
    public Interviewee(String username, String password)
    {
        this.username = username;
        this.password = password;
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

    public Timestamp getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Timestamp datecreated) {
        this.datecreated = datecreated;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Blob getProfilepic() {
        return profilepic;
    }

    public void setProfilepic(Blob profilepic) {
        this.profilepic = profilepic;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
