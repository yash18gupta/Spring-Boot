package org.geeksforgeeks.jbdl60.one2one;

public class CustomerTranscation {

    private int id;
    private double total;
    private Customer customer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "CustomerTranscation{" +
                "id=" + id +
                ", total=" + total +
                ", customer=" + customer +
                '}';
    }

    public CustomerTranscation(int id, double total, Customer customer) {
        super();
        this.id = id;
        this.total = total;
        this.customer = customer;
    }

    public CustomerTranscation() {
        super();
    }
}
