package com.alejandro.crud.simplearraycrud.response;

import com.alejandro.crud.simplearraycrud.entity.Person;

import java.io.Serializable;
import java.util.List;

public class DataListResponse implements Serializable {
   private List<Person> list;
   private int status;

    public DataListResponse(List<Person> list, int status) {
        this.list = list;
        this.status = status;
    }

    public List<Person> getPersonList() {
        return list;
    }

    public void setPersonList(List<Person> list) {
        this.list = list;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
