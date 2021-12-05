package com.example.springboottutorial.Models;
import java.sql.Blob;

import javax.persistence.*;
@Entity
@Table(name = "InterviewRecords")
public class InterviewRecords
{

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;

        @Column(name = "recordId")
        private int recordId;

        @Column(name = "intervieweeId")
        private int intervieweeId;

        @Column(name = "questionVideo")
        @Lob
        private Blob questionVideo;

        @Column(name = "questionText")
        private String questionText;

        @Column(name = "answerVideo")
        @Lob
        private Blob answerVideo;

        @Column(name = "answerText")
        private String answerText;


        @Column(name = "dateCreated")
        private String dateCreated;



        public InterviewRecords(){}

        //front end to edit the answertext field
        public InterviewRecords(String questionText)
        {
            this.questionText = questionText;
        }

        //backend with generated questions
        public InterviewRecords(String answerText, int recordId)
        {
            this.answerText = answerText;
            this.recordId = recordId;
        }

        /*
        public InterviewRecords(int intervieweeId, String dateCreated, String questionText, String answerText) {
            this.intervieweeId = intervieweeId;
            this.dateCreated = dateCreated;

            //remove?? front end shouldnt create questions
            this.questionText = questionText;

            this.answerText= answerText;
        }*/

        public int getId() {
            return intervieweeId;
        }

        public void setId(long id) {
                this.id = id;
        }

        public int getRecordId() {
                return recordId;
        }

        public void setRecordId(int recordId) {
                this.recordId = recordId;
        }

        public int getIntervieweeId() {
                return intervieweeId;
        }

        public void setIntervieweeId(int intervieweeId) {
                this.intervieweeId = intervieweeId;
        }

        public Blob getQuestionVideo() {
                return questionVideo;
        }

        public void setQuestionVideo(Blob questionVideo) {
                this.questionVideo = questionVideo;
        }

        public Blob getAnswerVideo() {
                return answerVideo;
        }

        public void setAnswerVideo(Blob answerVideo) {
                this.answerVideo = answerVideo;
        }

        public String getDateCreated() {
            return dateCreated;
        }

        public  void setDateCreated(String dateCreated)
        {
            this.dateCreated = dateCreated;
        }

        public String getQuestionText() {
            return questionText;
        }

        public void setQuestionText(String questionText)
        {
            this.questionText = questionText;
        }

        public String getAnswerText() {
            return answerText;
        }

        public void setAnswerText(String answerText)
        {
            this.answerText = answerText;
        }

        @Override
        public String toString() {
            return "Interview Records [id=" + intervieweeId + ", date=" + dateCreated + ", " +
                    "question=" + questionText + ", answer=" + answerText + "]";
        }
}
