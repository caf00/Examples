package com.alejandro.testupdate.db;

import com.alejandro.testupdate.core.domain.Client;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class ClientDb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String lastName;
    private String city;
    @Column(nullable = false)
    private String address;
    private String email;
    private String phone;

    protected ClientDb() {
    }

    public ClientDb(Integer id, String name, String lastName, String city, String address, String email, String phone) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.city = city;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    public ClientDb(Integer id, String name, String lastName, String address) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
    }

    public ClientDb(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.lastName = client.getLastName();
        this.city = client.getCity();
        this.address = client.getAddress();
        this.email = client.getEmail();
        this.phone = client.getPhone();
    }

    public Client toClient() {
        return new Client(
                this.id,
                this.name,
                this.lastName,
                this.city,
                this.address,
                this.email,
                this.phone
        );
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
