package edu.lex.cursova.form;

import edu.lex.cursova.model.EditionDirection;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class EditionForm {
    @Pattern(regexp = "[a-z0-9]{5}")
    private String editionCode;
    @Size(min = 2, max = 20)
    private String name;
    @Positive
    private int numberOfPages;
    @Positive
    private int circulation;
    private String editionDirection;

    public EditionForm() {
    }

    public EditionForm(String editionCode, String name, int numberOfPages, int circulation, String editionDirection) {
        this.editionCode = editionCode;
        this.name = name;
        this.numberOfPages = numberOfPages;
        this.circulation = circulation;
        this.editionDirection = editionDirection;
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

    public String getEditionDirection() {
        return editionDirection;
    }

    public void setEditionDirection(String editionDirection) {
        this.editionDirection = editionDirection;
    }

    @Override
    public String toString() {
        return "EditionForm{" +
                "editionCode='" + editionCode + '\'' +
                ", name='" + name + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", circulation=" + circulation +
                ", editionDirection='" + editionDirection + '\'' +
                '}';
    }
}
