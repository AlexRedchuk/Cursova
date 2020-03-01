package edu.lex.cursova.dataSet;

import edu.lex.cursova.model.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataSet {

    private List<ContactPerson> contactPeople = new ArrayList<>(Arrays.asList(
            new ContactPerson("1","Irina","0975638391","2334"),
            new ContactPerson("2","Petro","0975645621","2114"),
            new ContactPerson("3","Sophia","0976334691","6783")

    ));

    private List<Author> authors = new ArrayList<>(Arrays.asList(
            new Author("1","Taras Grigorovich Shevchenko", "Poltava Hmeltinskogo 2a", "0983357127"),
            new Author("2","Sophia Petrivna Kravchuk", "Kyiv Grushevskogo 12", "0984622118"),
            new Author("3","Liliya Olegivna Timoshchuk", "Kharkiv Zolotareva 56b", "0988732997")
    ));

    private List<Printery> printeries = new ArrayList<>(Arrays.asList(
            new Printery("1", "Persha Drukarnia", "Ternopil Grushevskogo 12b", "0932254411"),
            new Printery("2", "Phoenix", "Kyiv Krushelnitskoi 3b", "0961165772"),
            new Printery("3", "Druk", "Poltava Shevchenka 8", "0974433888")
    ));

    private List<ProductType> productTypes = new ArrayList<>(Arrays.asList(
            new ProductType("1","Book","Simple paper book"),
            new ProductType("2", "Booklet","Addvertisement booklet"),
            new ProductType("3","Talon","Talons for election, applications etc")
    ));

    private List<EditionDirection> editionDirections = new ArrayList<>(Arrays.asList(
            new EditionDirection("1","For kids","targeted at children under 8 years\n"),
            new EditionDirection("2","Psychology","Human psychology literature"),
            new EditionDirection("3","Addvertation","Commersial products")
    ));

    private List<OrderProcess> orderProcesses = new ArrayList<>(Arrays.asList(
            new OrderProcess("1", LocalDateTime.now(), LocalDateTime.now(),true),
            new OrderProcess("2", LocalDateTime.now(), LocalDateTime.now(),false),
            new OrderProcess("3", LocalDateTime.now(), LocalDateTime.now(),false)
    ));

    private List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer("1", OrganisationType.ORGANISATION, "Sokil",
                    contactPeople.get(0),
                    "Chernivtsi Ruska 3A","8954"),
            new Customer("2", OrganisationType.PRIVATE, "Polina",
                    contactPeople.get(1),
                    "Ternopil Lutchakivskogo 12A","1454"),
            new Customer("3", OrganisationType.PRIVATE, "Oleg",
                    contactPeople.get(2),
                    "Chernivtsi Golovna 48","2751")
    ));

    private List<Order> orders = new ArrayList<>(Arrays.asList(
            new Order("1","284324", customers.get(0),productTypes.get(0),printeries.get(1),orderProcesses.get(1)),
            new Order("2","285922", customers.get(2),productTypes.get(1),printeries.get(2),orderProcesses.get(0)),
            new Order("3","281342", customers.get(1),productTypes.get(2),printeries.get(0),orderProcesses.get(2))
    ));

    private List<Edition> editions = new ArrayList<>(Arrays.asList(
            new Edition("1", "h3145", "Prolisok", 1873, 10000, editionDirections.get(1)),
            new Edition("2", "n4351", "Jaivoronok", 4672, 8000, editionDirections.get(1)),
            new Edition("3","h4152","Ababagalamaga",9421,18235, editionDirections.get(0))

    ));

    private List<AuthorEditionLog> authorEditionLogs = new ArrayList<>(Arrays.asList(
            new AuthorEditionLog("1", editions.get(1), authors.get(2),"Popular psychologyst"),
            new AuthorEditionLog("2", editions.get(0), authors.get(1),"Exciting storytelling"),
            new AuthorEditionLog("3", editions.get(1), authors.get(0),"Verbal psychology")
    ));

    private List<EditionOrderLog> editionOrderLogs = new ArrayList<>(Arrays.asList(
            new EditionOrderLog("1", editions.get(1), orders.get(0)),
            new EditionOrderLog("2", editions.get(2), orders.get(1)),
            new EditionOrderLog("3", editions.get(2), orders.get(2))
    ));

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }


    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Printery> getPrinteries (){
        return printeries;
    }

    public void setPrinteries(List<Printery> printeries) {
        this.printeries = printeries;
    }

    public List<ProductType> getProductTypes (){
        return productTypes;
    }

    public void setProductTypes(List<ProductType> productTypes) {
        this.productTypes = productTypes;
    }

    public List<EditionDirection> getEditionDirections(){
        return editionDirections;
    }

    public void setEditionDirections(List<EditionDirection> editionDirections) {
        this.editionDirections = editionDirections;
    }

    public List<OrderProcess> getOrderProcesses (){
        return orderProcesses;
    }

    public void setOrderProcesses(List<OrderProcess> orderProcesses){
        this.orderProcesses = orderProcesses;
    }

    public List<Order> getOrders () {
        return orders;
    }

    public void setOrders (List<Order> orders){
        this.orders = orders;
    }
    public List<ContactPerson> getContactPeople () {
        return contactPeople;
    }

    public void setContactPeople (List<ContactPerson> contactPeople) {
        this.contactPeople = contactPeople;
    }

    public List<Edition> getEditions () {
        return editions;
    }

    public void setEditions (List<Edition> editions) {
        this.editions = editions;
    }

    public List<AuthorEditionLog> getAuthorEditionLogs() {
        return authorEditionLogs;
    }

    public void setAuthorEditionLogs (List<AuthorEditionLog> authorEditionLogs) {
        this.authorEditionLogs = authorEditionLogs;
    }

    public List<EditionOrderLog> getEditionOrderLogs () {
        return editionOrderLogs;
    }

    public void setEditionOrderLogs (List<EditionOrderLog> editionOrderLogs) {
        this.editionOrderLogs = editionOrderLogs;
    }
}
