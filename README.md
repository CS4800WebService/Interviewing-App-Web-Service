# Interviewing-App-Web-Service

![image](https://user-images.githubusercontent.com/83794482/143147314-cce498e4-6b1f-41a3-8ba7-41413293fe19.png)

## Schema Design

### Models

Interviewee

| Property  | Type | Description |
| ------------- | ------------- | -------------|
| intervieweeId | String | unique id for the user (default field) |
| userName | String  | unique username for the user |
| firstName  | String  | user's first name |
| lastName  | String  | user's last name |
| dateCreated | DateTime  | date when account was created (default field) |
| profilePic | File  | stores user's profile picture |
| password  | String  | stores user's password |
    
Employer

| Property  | Type | Description |
| ------------- | ------------- | -------------|
| employerId | String | unique id for the user (default field) |
| userName | String  | unique username for the employer |
| firstName  | String  | user's first name |
| lastName  | String  | user's last name |
| dateCreated | DateTime  | date when account was created (default field) |
| profilePic | File  | stores user's profile picture |
| password  | String  | stores user's password |
| status  | String  | stores employer's status (active hiring / away / closed) |

IntervieweeApplication

| Property  | Type | Description |
| ------------- | ------------- | -------------|
| itemId | String | unique id (default field) |
| intervieweeId | String | foreign key |
| jobId | String | foreign key |
| status | String | stores interviewing status (waiting / accepted / pending) |

JobPosition

| Property  | Type | Description |
| ------------- | ------------- | -------------|
| jobId | String | unique id (default field) |
| employerId | String | foreign key |
| status | String | stores job status (waiting / accepting / closed) |
| numApplicant | Number | stores the number of the applicants |
| numHiring | Number | stores the hiring number |

InterviewRecords

| Property  | Type | Description |
| ------------- | ------------- | -------------|
| recordId | String | unique id for the interviewing question (default field) |
| intervieweeId | String | foreign key |
| dateCreated | DateTime  | date when account was created (default field) |
| questionVideo | File  | stores the question video |
| questionText | String  | stores the question texts |
| answerVideo | File  | stores user's video recorded answer for the question |
| answerText | String | stores the answer texts |

InterviewAnalysis

| Property  | Type | Description |
| ------------- | ------------- | -------------|
| itemId | String | unique id (default field) |
| recordId | String | foreign key |
| voiceRes | String | stores the result of voice analysis |
| faceRes | String | stores the result of facial analysis |
| textRes | String | stores the result of textual analysis |

## Network Requests

|HTTP Verb | Endpoint | Description |
|--------------|--------------|------------|
| `GET` | /interviewee | fetches lists of interviewees|
| `GET` | /interviewee/{intervieweeId} | fetches a single interviewee by id |
| `GET` | /interviewee/{intervieweeId}/firstName | fetches the name by id |
| `PUT` | /interviewee/{intervieweeId}/firstName | updates an interviewee firstname |
| `POST` | /interviewee | adds an interviewee |
| `GET` | /intervieweeApplication/{intervieweeId}/jobId | fetches the position by a interviewee id |
    
| HTTP Verb | Endpoint | Description
   ----------|-----------|------------
| `GET` | /employer | fetches lists of employers |
| `GET` | /employer/{employerId} | fetches a single employer by id |
| `GET` | /employer/{employerId}/name | fetches the name by id |
| `GET` | /employer/{employerId}/status | fetches the position by a employer id |
| `PUT` | /employer/{employerId}/status | updates an employer status |
| `POST` | /employer | adds an employer |
