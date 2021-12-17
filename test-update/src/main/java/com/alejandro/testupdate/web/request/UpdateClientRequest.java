package com.alejandro.testupdate.web.request;

public class UpdateClientRequest {
    private Integer id;
    private String name;
    private String lastName;
    private String city;
    private String address;
    private String email;
    private String phone;

    protected UpdateClientRequest() {
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

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
