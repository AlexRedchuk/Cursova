package edu.lex.cursova.form;

import edu.lex.cursova.model.EditionDirection;

public class EditionForm {
    private String editionCode;
    private String name;
    private int numberOfPages;
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
