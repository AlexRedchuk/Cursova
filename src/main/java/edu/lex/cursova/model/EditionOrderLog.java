package edu.lex.cursova.model;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public class EditionOrderLog {
    @Id
    private String id;
    private Edition edition;
    private Order order;

    public EditionOrderLog() {
    }

    public EditionOrderLog(String id, Edition edition, Order order) {
        this.id = id;
        this.edition = edition;
        this.order = order;
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EditionOrderLog that = (EditionOrderLog) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(edition, that.edition) &&
                Objects.equals(order, that.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, edition, order);
    }

    @Override
    public String toString() {
        return "EditionOrderLog{" +
                "id='" + id + '\'' +
                ", edition=" + edition +
                ", order=" + order +
                '}';
    }
}
