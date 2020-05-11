package edu.lex.cursova.form;

public class SearchForm {
    private String searchField;

    public SearchForm() {
    }

    public String getSearchField() {
        return searchField;
    }

    public void setSearchField(String searchField) {
        this.searchField = searchField;
    }

    @Override
    public String toString() {
        return "SearchForm{" +
                "string='" + searchField + '\'' +
                '}';
    }
}
