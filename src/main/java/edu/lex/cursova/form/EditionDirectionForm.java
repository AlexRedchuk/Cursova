package edu.lex.cursova.form;

public class EditionDirectionForm {
    private String name;
    private String description;

    public EditionDirectionForm() {
    }

    public EditionDirectionForm(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "EditionDirectionForm{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
