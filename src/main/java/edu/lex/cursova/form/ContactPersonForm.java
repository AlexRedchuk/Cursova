package edu.lex.cursova.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ContactPersonForm {
    @NotNull
    @Size(min=3, max=20, message = "Name is not valid")
    private String fullName;
    @Pattern(regexp = "0[0-9]{9}")
    private String phoneNumber;
    @Pattern(regexp = "[0-9]{10}")
    private String fax;

    public ContactPersonForm() {
    }

    public ContactPersonForm(String fullName, String phoneNumber, String fax) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.fax = fax;
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
    public String toString() {
        return "ContactPersonForm{" +
                "fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", fax='" + fax + '\'' +
                '}';
    }
}
