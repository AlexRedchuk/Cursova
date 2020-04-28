package edu.lex.cursova.form;

public class EditionOrderLogForm {
    private String edition;
    private String order;

    public EditionOrderLogForm() {
    }

    public EditionOrderLogForm(String edition, String order) {
        this.edition = edition;
        this.order = order;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public String   toString() {
        return "EditionOrderLogForm{" +
                "edition='" + edition + '\'' +
                ", order='" + order + '\'' +
                '}';
    }
}
