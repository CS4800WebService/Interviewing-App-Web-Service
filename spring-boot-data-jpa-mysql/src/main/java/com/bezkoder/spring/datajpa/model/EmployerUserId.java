package com.bezkoder.spring.datajpa.model;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Objects;

public class EmployerUserId implements Serializable {

    @Id
    private int employerid;

    @Id
    private String username;

    public EmployerUserId(){}

    public EmployerUserId(int employerid, String username) {
        this.employerid = employerid;
        this.username = username;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result =  (prime * result + employerid);
        result = prime * result + Integer.parseInt(username);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        EmployerUserId other = (EmployerUserId) obj;
        if (employerid != other.employerid)
            return false;
        if (!Objects.equals(username, other.username))
            return false;
        return true;
    }
}
