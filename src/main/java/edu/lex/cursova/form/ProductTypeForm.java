package edu.lex.cursova.form;

import javax.validation.constraints.Size;

public class ProductTypeForm {
    @Size(min = 2, max = 50)
    private String name;
    @Size(max = 50)
    private String description;

    public ProductTypeForm() {
    }

    public ProductTypeForm(String name, String description) {
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
        return "ProductTypeForm{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
