package edu.lex.cursova.form;

import javax.validation.constraints.Pattern;

public class OrderForm {
    @Pattern(regexp = "[0-9]{6}")
    private String numberOfOrder;
    private String customer;
    private String productType;
    private String printery;

    public OrderForm() {
    }

    public OrderForm(String numberOfOrder, String customer, String productType, String printery) {
        this.numberOfOrder = numberOfOrder;
        this.customer = customer;
        this.productType = productType;
        this.printery = printery;
    }

    public String getNumberOfOrder() {
        return numberOfOrder;
    }

    public void setNumberOfOrder(String numberOfOrder) {
        this.numberOfOrder = numberOfOrder;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getPrintery() {
        return printery;
    }

    public void setPrintery(String printery) {
        this.printery = printery;
    }

    @Override
    public String toString() {
        return "OrderForm{" +
                "numberOfOrder='" + numberOfOrder + '\'' +
                ", customer='" + customer + '\'' +
                ", productType='" + productType + '\'' +
                ", printery='" + printery + '\'' +
                '}';
    }
}
