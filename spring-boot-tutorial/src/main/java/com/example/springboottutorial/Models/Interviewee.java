package com.example.springboottutorial.Models;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Blob;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import javax.persistence.*;
@Entity
@Table (name = "Interviewee")
@IdClass(IntervieweeUserId.class)
public class Interviewee
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "intervieweeId")
    private int intervieweeId;

    @Id
    @Column(name = "userName")
    private String userName;

    @CreationTimestamp
    @Column(name = "dateCreated")
    private Timestamp dateCreated;

    @Column(name = "password")
    private String password;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Lob
    @Column(name = "profilePic")
    private Blob profilePic;

    public Interviewee(){}


    public Interviewee (String firstName, String lastName, String userName, String password)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
    }

    //front end to create a new user with username and password
    public Interviewee (String userName, String password)
    {
        this.userName = userName;
        this.password = password;
    }

    public int getIntervieweeId() {return intervieweeId; }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPassword()
    {
        return password;
    }

}

