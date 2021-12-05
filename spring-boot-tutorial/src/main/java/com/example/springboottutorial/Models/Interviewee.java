package com.example.springboottutorial.Models;
import java.sql.Blob;

import javax.persistence.*;
@Entity
@Table(name = "Interviewee")
public class Interviewee
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    @Column(name = "intervieweeId")
    private int intervieweeId;

    @Column(name = "dateCreated")
    private String dateCreated;

    @Column(name = "userName")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "profilePic")
    @Lob
    private Blob profilePic;

    public Interviewee(){}

    //front end to edit the password field
    public Interviewee (String firstName, String lastName, String userName, String password)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
    }

    //backend with generated questions
    public Interviewee ( String userName, int intervieweeId)
    {
        this.userName = userName;
        this.intervieweeId = intervieweeId;
    }

    public int getId() {
        return intervieweeId;
    }

    public String getDateCreated() {
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

    public  void setDateCreated(String dateCreated)
    {
        this.dateCreated = dateCreated;
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