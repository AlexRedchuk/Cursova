package edu.lex.cursova.model;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public class Printery {
    @Id
    private String id;
    private String name;
    private String address;
    private String phoneNumber;

    public Printery() {
    }

    public Printery(String id, String name, String address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Printery printery = (Printery) o;
        return id == printery.id &&
                Objects.equals(name, printery.name) &&
                Objects.equals(address, printery.address) &&
                Objects.equals(phoneNumber, printery.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, phoneNumber);
    }

    @Override
    public String toString() {
        return "Printery{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
