package edu.lex.cursova.model;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public class Customer {
    @Id
    private String id;
    private OrganisationType type = OrganisationType.ORGANISATION;
    private String name;
    private ContactPerson contactPerson;
    private String address;
    private String fax;

    public Customer() {
    }

    public Customer(String id, OrganisationType type, String name, ContactPerson contactPerson, String address, String fax) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.contactPerson = contactPerson;
        this.address = address;
        this.fax = fax;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OrganisationType getType() {
        return type;
    }

    public void setType(OrganisationType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ContactPerson getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(ContactPerson contactPerson) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id &&
                type == customer.type &&
                Objects.equals(name, customer.name) &&
                Objects.equals(contactPerson, customer.contactPerson) &&
                Objects.equals(address, customer.address) &&
                Objects.equals(fax, customer.fax);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, name, contactPerson, address, fax);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", contactPerson=" + contactPerson +
                ", address='" + address + '\'' +
                ", fax='" + fax + '\'' +
                '}';
    }
}
