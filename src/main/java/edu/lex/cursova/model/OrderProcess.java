package edu.lex.cursova.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.Objects;

public class OrderProcess {
    @Id
    private String id;
    private Order order;
    private LocalDateTime acceptDate;
    private LocalDateTime completionDate;

    public OrderProcess() {
    }

    public OrderProcess(String id, Order order, LocalDateTime acceptDate, LocalDateTime completionDate) {
        this.id = id;
        this.order = order;
        this.acceptDate = acceptDate;
        this.completionDate = completionDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public LocalDateTime getAcceptDate() {
        return acceptDate;
    }

    public void setAcceptDate(LocalDateTime acceptDate) {
        this.acceptDate = acceptDate;
    }

    public LocalDateTime getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(LocalDateTime completionDate) {
        this.completionDate = completionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderProcess that = (OrderProcess) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(order, that.order) &&
                Objects.equals(acceptDate, that.acceptDate) &&
                Objects.equals(completionDate, that.completionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, order, acceptDate, completionDate);
    }

    @Override
    public String toString() {
        return "OrderProcess{" +
                "id='" + id + '\'' +
                ", order=" + order +
                ", acceptDate=" + acceptDate +
                ", completionDate=" + completionDate +
                '}';
    }
}
