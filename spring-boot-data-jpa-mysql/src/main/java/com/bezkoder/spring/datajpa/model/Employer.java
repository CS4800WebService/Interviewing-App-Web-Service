package com.bezkoder.spring.datajpa.model;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table (name = "Employer")
@IdClass(EmployerUserId.class)
public class Employer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employerid")
    private int employerid;

    @Id
    @Column(name = "username")
    private String username;


    @CreationTimestamp
    @Column(name = "datecreated")
    private Timestamp datecreated;

    @Column(name = "password")
    private String password;

    @Column(name = "companyname")
    private String companyname;

    @Column(name = "status")
    private String status;

    @Lob
    @Column(name = "profilepic")
    private Blob profilepic;

    public Employer() {
    }

    //create a new user with username,password, and companyname
    public Employer(String username, String password, String companyname)
    {
        this.companyname = companyname;
        this.username = username;
        this.password = password;
    }

    //create a new user with username and password
    public Employer(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    public int getEmployerid() {
        return employerid;
    }

    public void setEmployerid(int employerid) {
        this.employerid = employerid;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public Blob getProfilepic() {
        return profilepic;
    }

    public void setProfilepic(Blob profilepic) {
        this.profilepic = profilepic;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

