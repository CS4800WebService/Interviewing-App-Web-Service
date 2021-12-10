package com.example.springboottutorial.Models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.Timestamp;

@Entity
@Table(name = "interviewrecords")
public class InterviewRecords
{

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "recordid")
        private int recordid;

        @ManyToOne
        @JoinColumn(name = "itemid")
        @JsonBackReference
        private IntervieweeApplication intervieweeApplication;

        @Column(name = "questionvideo")
        @Lob
        private Blob questionvideo;

        @Column(name = "questionvideolink")
        private String questionvideolink;

        @Column(name = "questiontext")
        private String questiontext;

        @Column(name = "answervideo")
        @Lob
        private Blob answervideo;

        @Column(name = "answervideolink")
        private String answervideolink;

        @Column(name = "answertext")
        private String answertext;

        @CreationTimestamp
        @Column(name = "datecreated")
        private Timestamp datecreated;

        @Column(name = "voiceres")
        private String voiceres;

        @Column(name = "faceres")
        private String faceres;

        @Column(name = "textres")
        private String textres;

        public InterviewRecords(){}

        public int getRecordid() {
                return recordid;
        }

        public void setRecordid(int recordid) {
                this.recordid = recordid;
        }

        public IntervieweeApplication getIntervieweeApplication() {
                return intervieweeApplication;
        }

        public void setIntervieweeApplication(IntervieweeApplication intervieweeApplication) {
                this.intervieweeApplication = intervieweeApplication;
        }

        public Blob getQuestionvideo() {
                return questionvideo;
        }

        public void setQuestionvideo(Blob questionvideo) {
                this.questionvideo = questionvideo;
        }

        public String getQuestionvideolink() {
                return questionvideolink;
        }

        public void setQuestionvideolink(String questionvideolink) {
                this.questionvideolink = questionvideolink;
        }

        public String getQuestiontext() {
                return questiontext;
        }

        public void setQuestiontext(String questiontext) {
                this.questiontext = questiontext;
        }

        public Blob getAnswervideo() {
                return answervideo;
        }

        public void setAnswervideo(Blob answervideo) {
                this.answervideo = answervideo;
        }

        public String getAnswervideolink() {
                return answervideolink;
        }

        public void setAnswervideolink(String answervideolink) {
                this.answervideolink = answervideolink;
        }

        public String getAnswertext() {
                return answertext;
        }

        public void setAnswertext(String answertext) {
                this.answertext = answertext;
        }

        public Timestamp getDatecreated() {
                return datecreated;
        }

        public void setDatecreated(Timestamp datecreated) {
                this.datecreated = datecreated;
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
