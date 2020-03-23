package edu.lex.cursova.form;

public class ContactPersonForm {
    private String fullName;
    private String phoneNumber;
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
