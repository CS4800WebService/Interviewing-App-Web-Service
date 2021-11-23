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

## Network Requests

|HTTP Verb | Endpoint | Description |
|--------------|--------------|------------|
| `GET` | /interviewee | fetches lists of interviewees|
| `GET` | /interviewee/{intervieweeId} | fetches a single interviewee by id |
| `GET` | /interviewee/{intervieweeId}/name | fetches the name by id |
| `GET` | /interviewee/{intervieweeId}/position | fetches the position by a interviewee id |
| `PUT` | /interviewee/{intervieweeId}/position | updates an interviewee position |
| `POST` | /interviewee | adds an interviewee |
    
| HTTP Verb | Endpoint | Description
   ----------|-----------|------------
| `GET` | /employer | fetches lists of employers |
| `GET` | /employer/{employerId} | fetches a single employer by id |
| `GET` | /employer/{employerId}/name | fetches the name by id |
| `GET` | /employer/{employerId}/status | fetches the position by a employer id |
| `PUT` | /employer/{employerId}/status | updates an employer status |
| `POST` | /employer | adds an employer |
