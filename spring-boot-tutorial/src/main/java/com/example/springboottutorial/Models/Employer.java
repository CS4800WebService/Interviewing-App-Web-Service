package com.example.springboottutorial.Models;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.*;

@Entity
@Table(name = "employer")
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "employerid")
    private String employerid;

    @Column(name = "username")
    private String username;

    @Column(name = "companyname")
    private String companyname;

    @CreationTimestamp
    @Column(name = "datecreated")
    private Timestamp dateCreated;

    @Column(name = "profilepic")
    @Lob
    private Blob profilepic;

    @Column(name = "password")
    private String password;

    @Column(name = "status")
    private String status;

    public Employer(String employerid, String username, String companyname,
                    Timestamp dateCreated, Blob profilepic, String password, String status)
    {
        this.employerid = employerid;
        this.username = username;
        this.companyname = companyname;
        this.dateCreated = dateCreated;
        this.profilepic = profilepic;
        this.password = password;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmployerid() {
        return employerid;
    }

    public void setEmployerid(String employerid) {
        this.employerid = employerid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
