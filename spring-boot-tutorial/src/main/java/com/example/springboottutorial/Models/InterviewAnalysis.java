package com.example.springboottutorial.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "interviewanalysis")
public class InterviewAnalysis {

    @Column(name = "itemid")
    private String itemid;

    @Column(name = "recordid")
    private String recordid;


}
