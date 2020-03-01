package edu.lex.cursova.model;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public class Edition {
    @Id
    private String id;
    private String editionCode;
    private String name;
    private int numberOfPages;
    private int circulation;
    private EditionDirection editionDirection;

    public Edition() {
    }

    public Edition(String id, String editionCode, String name, int numberOfPages, int circulation, EditionDirection editionDirection) {
        this.id = id;
        this.editionCode = editionCode;
        this.name = name;
        this.numberOfPages = numberOfPages;
        this.circulation = circulation;
        this.editionDirection = editionDirection;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEditionCode() {
        return editionCode;
    }

    public void setEditionCode(String editionCode) {
        this.editionCode = editionCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public int getCirculation() {
        return circulation;
    }

    public void setCirculation(int circulation) {
        this.circulation = circulation;
    }

    public EditionDirection getEditionDirection() {
        return editionDirection;
    }

    public void setEditionDirection(EditionDirection editionDirection) {
        this.editionDirection = editionDirection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edition edition = (Edition) o;
        return numberOfPages == edition.numberOfPages &&
                circulation == edition.circulation &&
                Objects.equals(id, edition.id) &&
                Objects.equals(editionCode, edition.editionCode) &&
                Objects.equals(name, edition.name) &&
                Objects.equals(editionDirection, edition.editionDirection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, editionCode, name, numberOfPages, circulation, editionDirection);
    }

    @Override
    public String toString() {
        return "Edition{" +
                "id='" + id + '\'' +
                ", editionCode='" + editionCode + '\'' +
                ", name='" + name + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", circulation=" + circulation +
                ", editionDirection=" + editionDirection +
                '}';
    }
}
