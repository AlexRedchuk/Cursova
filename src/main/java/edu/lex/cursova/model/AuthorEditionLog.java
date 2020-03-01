package edu.lex.cursova.model;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public class AuthorEditionLog {
    @Id
    private String id;
    private Edition edition;
    private Author author;
    private String additionalInformation;

    public AuthorEditionLog() {
    }

    public AuthorEditionLog(String id, Edition edition, Author author, String additionalInformation) {
        this.id = id;
        this.edition = edition;
        this.author = author;
        this.additionalInformation = additionalInformation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Edition getEdition() {
        return edition;
    }

    public void setEdition(Edition edition) {
        this.edition = edition;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorEditionLog that = (AuthorEditionLog) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(edition, that.edition) &&
                Objects.equals(author, that.author) &&
                Objects.equals(additionalInformation, that.additionalInformation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, edition, author, additionalInformation);
    }

    @Override
    public String toString() {
        return "AuthorEditionLog{" +
                "id='" + id + '\'' +
                ", edition=" + edition +
                ", author=" + author +
                ", additionalInformation='" + additionalInformation + '\'' +
                '}';
    }
}
