package com.example.springboottutorial.Models;

import javax.persistence.*;
@Entity
@Table(name = "InterviewRecords")
public class InterviewRecords
{

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;


        //add in video file???

        @Column(name = "recordId")
        private int recordId;

        @Column(name = "intervieweeId")
        private int intervieweeId;

        @Column(name = "dateCreated")
        private String dateCreated;

        @Column(name = "questionText")
        private String questionText;

        //this should be the interviewee's text responses
        @Column(name = "answerText")
        private String answerText;

        public InterviewRecords(){}

        //front end to edit the answertext field
        public InterviewRecords(String answerText)
        {
            this.answerText = answerText;
        }

        //backend with generated questions
        public InterviewRecords(String questionText, int recordId)
        {
            this.questionText = questionText;
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
