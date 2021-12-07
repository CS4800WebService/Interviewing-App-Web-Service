# Interviewing-App-Web-Service

## Group members

*Davis Tong, David Maestas, Timothy Flach, Nhat Tran, and Alexa Tang*

## Project Architecture

![image](https://user-images.githubusercontent.com/83794482/143147314-cce498e4-6b1f-41a3-8ba7-41413293fe19.png)

## Schema Design

### UML Domain Class Diagram

![Domain Model Class Diagram](https://user-images.githubusercontent.com/83794482/144990941-f365f561-1ee6-4137-948f-4b61371d6a30.png)


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
| companyName  | String  | user's first name |
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
| dateCreated | DateTime  | date when application was created |

Jobs

| Property  | Type | Description |
| ------------- | ------------- | -------------|
| jobId | String | unique id (default field) |
| employerId | String | foreign key |
| status | String | stores job status (waiting / accepting / closed) |
| numApplicant | Number | stores the number of the applicants |
| numHiring | Number | stores the hiring number |
| dateCreated | DateTime  | date when job was created |

InterviewRecords

| Property  | Type | Description |
| ------------- | ------------- | -------------|
| recordId | String | unique id for the interviewing question (default field) |
| intervieweeId | String | foreign key |
| dateCreated | DateTime  | date when record was created |
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
| `GET` | /employer | fetches lists of employers |
| `GET` | /employer/{employerId} | fetches a single employer by id |
| `GET` | /employer/{employerId}/companyName | fetches the name by id |
| `GET` | /employer/{employerId}/status | fetches the position by a employer id |
| `PUT` | /employer/{employerId}/status | updates an employer status |
| `POST` | /employer | adds an employer |

Postman testing requests: https://warped-equinox-550447.postman.co/workspace/My-Workspace~d48de1ad-74d4-43cd-88bd-96184c605f82/documentation/18653391-dc78787a-b8be-404c-9a06-958369554cd0

