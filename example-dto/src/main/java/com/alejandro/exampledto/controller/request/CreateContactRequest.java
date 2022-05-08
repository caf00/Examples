package com.alejandro.exampledto.controller.request;

import java.io.Serializable;

public class CreateContactRequest implements Serializable {
    private String name;
    private String lastName;
    private String address;
    private String phone;

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
