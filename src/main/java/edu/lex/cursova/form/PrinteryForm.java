package edu.lex.cursova.form;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class PrinteryForm {
    @Size(min = 2, max = 50)
    private String name;
    @Size(max = 50)
    private String address;
    @Pattern(regexp = "0[0-9]{9}")
    private String phoneNumber;

    public PrinteryForm() {
    }

    public PrinteryForm(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
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
    public String toString() {
        return "PrinteryForm{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
