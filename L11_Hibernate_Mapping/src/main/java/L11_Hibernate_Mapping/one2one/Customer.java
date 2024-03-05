package L11_Hibernate_Mapping.one2one;

public class Customer {
    private int id;
    private String name;
    private String email;
    private String address;

    private CustomerTranscation transcation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerTranscation getTranscation() {
        return transcation;
    }

    public void setTranscation(CustomerTranscation transcation) {
        this.transcation = transcation;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", transcation=" + transcation +
                '}';
    }

    public Customer(int id, String name, String email, String address, CustomerTranscation transcation) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.transcation = transcation;
    }

    public Customer() {
        super();
    }
}
