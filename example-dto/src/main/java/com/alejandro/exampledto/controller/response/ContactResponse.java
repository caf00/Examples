package com.alejandro.exampledto.controller.response;

import java.io.Serializable;

public class ContactResponse implements Serializable {
    private Integer id;
    private String name;
    private String lastName;
    private String address;
    private String phone;

    public ContactResponse(Integer id, String name, String lastName, String address, String phone) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
}
