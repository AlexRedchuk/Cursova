package edu.lex.cursova.model;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public class Order {
    @Id
    private String id;
    private String numberOfOrder;
    private Customer customer;
    private ProductType productType;
    private Printery printery;
    private OrderProcess orderProcess;

    public Order() {
    }

    public Order(String id, String numberOfOrder, Customer customer, ProductType productType, Printery printery, OrderProcess orderProcess) {
        this.id = id;
        this.numberOfOrder = numberOfOrder;
        this.customer = customer;
        this.productType = productType;
        this.printery = printery;
        this.orderProcess = orderProcess;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumberOfOrder() {
        return numberOfOrder;
    }

    public void setNumberOfOrder(String numberOfOrder) {
        this.numberOfOrder = numberOfOrder;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Printery getPrintery() {
        return printery;
    }

    public void setPrintery(Printery printery) {
        this.printery = printery;
    }

    public OrderProcess getOrderProcess() {
        return orderProcess;
    }

    public void setOrderProcess(OrderProcess orderProcess) {
        this.orderProcess = orderProcess;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id &&
                numberOfOrder == order.numberOfOrder &&
                Objects.equals(customer, order.customer) &&
                productType == order.productType &&
                Objects.equals(printery, order.printery) &&
                Objects.equals(orderProcess, order.orderProcess);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numberOfOrder, customer, productType, printery, orderProcess);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", numberOfOrder=" + numberOfOrder +
                ", customer=" + customer +
                ", productType=" + productType +
                ", printery=" + printery +
                ", orderProcess=" + orderProcess +
                '}';
    }
}
