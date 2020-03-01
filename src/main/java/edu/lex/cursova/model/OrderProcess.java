package edu.lex.cursova.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.Objects;

public class OrderProcess {
    @Id
    private String id;
    private LocalDateTime acceptDate;
    private LocalDateTime completionDate;
    private boolean isComplited;

    public OrderProcess() {
    }

    public OrderProcess(String id, LocalDateTime acceptDate, LocalDateTime completionDate, boolean isComplited) {
        this.id = id;
        this.acceptDate = acceptDate;
        this.completionDate = completionDate;
        this.isComplited = isComplited;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public boolean isComplited() {
        return isComplited;
    }

    public void setComplited(boolean complited) {
        isComplited = complited;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderProcess that = (OrderProcess) o;
        return id == that.id &&
                isComplited == that.isComplited &&
                Objects.equals(acceptDate, that.acceptDate) &&
                Objects.equals(completionDate, that.completionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, acceptDate, completionDate, isComplited);
    }

    @Override
    public String toString() {
        return "OrderProcess{" +
                "id=" + id +
                ", acceptDate=" + acceptDate +
                ", completionDate=" + completionDate +
                ", isComplited=" + isComplited +
                '}';
    }
}
