package com.example.springboottutorial.Models;

import lombok.Cleanup;

import javax.persistence.*;

@Entity
@Table(name = "interviewanalysis")
public class InterviewAnalysis {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "itemid")
    private String itemid;

    @Column(name = "recordid")
    private String recordid;

    @Column(name = "voiceres")
    private String voiceres;

    @Column(name = "faceres")
    private String faceres;

    @Column(name = "textres")
    private String textres;

    public InterviewAnalysis(String itemid, String recordid, String voiceres, String faceres, String textres)
    {
        this.itemid = itemid;
        this.recordid = recordid;
        this.voiceres = voiceres;
        this.faceres = faceres;
        this.textres = textres;
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

    public String getRecordid() {
        return recordid;
    }

    public void setRecordid(String recordid) {
        this.recordid = recordid;
    }

    public String getVoiceres() {
        return voiceres;
    }

    public void setVoiceres(String voiceres) {
        this.voiceres = voiceres;
    }

    public String getFaceres() {
        return faceres;
    }

    public void setFaceres(String faceres) {
        this.faceres = faceres;
    }

    public String getTextres() {
        return textres;
    }

    public void setTextres(String textres) {
        this.textres = textres;
    }
}
