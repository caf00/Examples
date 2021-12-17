package com.alejandro.testupdate.web.response;

import com.alejandro.testupdate.core.domain.Client;

public class ClientResponse {
    private final Integer id;
    private final String name;
    private final String lastName;
    private final String city;
    private final String address;
    private final String email;
    private final String phone;

    public ClientResponse(Integer id, String name, String lastName, String city, String address, String email, String phone) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.city = city;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }
    public ClientResponse(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.lastName = client.getLastName();
        this.city = client.getCity();
        this.address = client.getAddress();
        this.email = client.getEmail();
        this.phone = client.getPhone();
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
