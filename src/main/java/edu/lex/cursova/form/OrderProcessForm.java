package edu.lex.cursova.form;

import java.time.LocalDateTime;

public class OrderProcessForm {
    private String order;
    private LocalDateTime acceptDate;
    private LocalDateTime completionDate;
    private String isComplited;

    public OrderProcessForm() {
    }

    public OrderProcessForm(String order, LocalDateTime acceptDate, LocalDateTime completionDate, String isComplited) {
        this.order = order;
        this.acceptDate = acceptDate;
        this.completionDate = completionDate;
        this.isComplited = isComplited;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
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

    public String getIsComplited() {
        return isComplited;
    }

    public void setIsComplited(String isComplited) {
        this.isComplited = isComplited;
    }

    @Override
    public String toString() {
        return "OrderProcessForm{" +
                "order='" + order + '\'' +
                ", acceptDate=" + acceptDate +
                ", completionDate=" + completionDate +
                ", isComplited='" + isComplited + '\'' +
                '}';
    }
}
