package org.geekforgeeks.SpringBoot_Hibernate.Service;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.geekforgeeks.SpringBoot_Hibernate.Entity.Customer;
import org.geekforgeeks.SpringBoot_Hibernate.Model.CustomerCreateRequest;
import org.geekforgeeks.SpringBoot_Hibernate.Model.CustomerCreateResponse;
import org.geekforgeeks.SpringBoot_Hibernate.Model.GetCustomerResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    Configuration c;
    SessionFactory sf;

    public CustomerService(){
        c = new Configuration();
        sf = c.configure("hbm.cfg.xml").buildSessionFactory();
    }
    public CustomerCreateResponse createCustomer(CustomerCreateRequest customer){

        Session s = sf.openSession();
        CustomerCreateResponse response;
        Transaction tx;

        if(customer.getName()==null || customer.getName().equals("")){
            response = new CustomerCreateResponse(300,"Name can't be null");
            return response;
        }

        try {
            tx = s.beginTransaction();
            Customer c = new Customer();
            c.setName(customer.getName());
            c.setEmail(customer.getUsername() + "@" + customer.getDomain());
            c.setAddress(customer.getAddress());


            s.save(c);
            s.flush();

            tx.commit();
            response = new CustomerCreateResponse(c.getId(), c.getName(), c.getEmail(), 200, "Customer successfully added");
        }
        catch (Exception e){
            response = new CustomerCreateResponse(300, "Error while Saving Customer" + e);
        }

        return response;
    }

    public GetCustomerResponse getCustomer(int id){
        Session s = sf.openSession();
        GetCustomerResponse response;
        Transaction tx;

        tx = s.beginTransaction();

        Customer c= s.get(Customer.class, id);
        response = new GetCustomerResponse(c.getId(), c.getName(), c.getEmail(), 200, "Success");


        return response;
    }
    public List<Customer> getAllCustomer(){

        Session s = sf.openSession();

//        CriteriaBuilder cb = s.getCriteriaBuilder();
//        CriteriaQuery<Customer> cqEmp = cb.createQuery(Customer.class);
//        Root<Customer> rootEntry = cqEmp.from(Customer.class);
//        CriteriaQuery<Customer> all = cqEmp.select(rootEntry);
//        all.orderBy(cb.asc(rootEntry.get("name")));
//
//        TypedQuery<Customer> getAllCustomer = s.createQuery(all);

        String query = "from Customer";

        Query q = s.createQuery(query);

        List<Customer> list= q.list();


        return list;


//        return getAllCustomer.getResultList();
    }
}
