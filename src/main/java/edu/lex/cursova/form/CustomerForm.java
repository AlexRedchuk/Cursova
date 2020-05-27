package edu.lex.cursova.form;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CustomerForm {
    private String type;
    @Size(min = 2, max = 20)
    private String name;
    private String contactPerson;
    @Size(max = 50)
    private String address;
    @Pattern(regexp = "[0-9]{10}")
    private String fax;

    public CustomerForm() {
    }

    public CustomerForm(String type, String name, String contactPerson, String address, String fax) {
        this.type = type;
        this.name = name;
        this.contactPerson = contactPerson;
        this.address = address;
        this.fax = fax;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Override
    public String toString() {
        return "CustomerForm{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", address='" + address + '\'' +
                ", fax='" + fax + '\'' +
                '}';
    }
}
