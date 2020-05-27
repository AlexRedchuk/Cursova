package edu.lex.cursova.model;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class ContactPerson {

    @Id
    private String id;
    private String fullName;
    private String phoneNumber;
    private String fax;

    public ContactPerson() {
    }

    public ContactPerson(String id, String fullName, String phoneNumber, String fax) {
        this.id = id;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.fax = fax;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactPerson that = (ContactPerson) o;
        return id == that.id &&
                Objects.equals(fullName, that.fullName) &&
                Objects.equals(phoneNumber, that.phoneNumber) &&
                Objects.equals(fax, that.fax);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, phoneNumber, fax);
    }

    @Override
    public String toString() {
        return "ContactPerson{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", number='" + phoneNumber + '\'' +
                ", fax='" + fax + '\'' +
                '}';
    }
}
