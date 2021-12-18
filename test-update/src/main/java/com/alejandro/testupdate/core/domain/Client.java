package com.alejandro.testupdate.core.domain;

public class Client {
    private Integer id;
    private String name;
    private String lastName;
    private String city;
    private String address;
    private String email;
    private String phone;

    public Client(Integer id, String name, String lastName, String city, String address, String email, String phone) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.city = city;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    public Client(String name, String lastName, String city, String address, String email, String phone) {
        this.name = name;
        this.lastName = lastName;
        this.city = city;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    public void updateFrom(Client client) {
        if(client!=null){
            if(client.getName()!=null) this.name = client.getName();
            if(client.getLastName()!=null) this.lastName = client.getLastName();
            if(client.getCity()!=null) this.city = client.getCity();
            if(client.getAddress()!=null) this.address = client.getAddress();
            if(client.getEmail()!=null) this.email = client.getEmail();
            if(client.getPhone()!=null) this.phone = client.getPhone();
        }
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

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
