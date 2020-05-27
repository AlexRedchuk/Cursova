package edu.lex.cursova.form;

import javax.validation.constraints.Size;

public class AuthorEditionLogForm {
    private String author;
    private String edition;
    @Size(max = 50)
    private String additionalInformation;

    public AuthorEditionLogForm() {
    }

    public AuthorEditionLogForm(String author, String edition, String additionalInformation) {
        this.author = author;
        this.edition = edition;
        this.additionalInformation = additionalInformation;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    @Override
    public String toString() {
        return "AuthorEditionLogForm{" +
                "author='" + author + '\'' +
                ", edition='" + edition + '\'' +
                ", additionalInformation='" + additionalInformation + '\'' +
                '}';
    }
}
