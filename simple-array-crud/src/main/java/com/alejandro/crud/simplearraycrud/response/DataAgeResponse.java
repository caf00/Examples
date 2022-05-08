package com.alejandro.crud.simplearraycrud.response;

import java.io.Serializable;

public class DataAgeResponse implements Serializable {
    private int age;
    private int status;

    public DataAgeResponse(int age, int status) {
        this.age = age;
        this.status = status;
    }

    public int getYear() {
        return age;
    }

    public void setYear(int year) {
        this.age = year;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
