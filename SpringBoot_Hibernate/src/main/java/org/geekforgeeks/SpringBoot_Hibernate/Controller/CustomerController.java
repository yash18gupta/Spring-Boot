package org.geekforgeeks.SpringBoot_Hibernate.Controller;

import org.geekforgeeks.SpringBoot_Hibernate.Entity.Customer;
import org.geekforgeeks.SpringBoot_Hibernate.Model.CustomerCreateRequest;
import org.geekforgeeks.SpringBoot_Hibernate.Model.CustomerCreateResponse;
import org.geekforgeeks.SpringBoot_Hibernate.Model.GetCustomerResponse;
import org.geekforgeeks.SpringBoot_Hibernate.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping("/test")
    public String testing(){
        return "Test API Works!";
    }

    @PostMapping("/create")
    public CustomerCreateResponse createCustomer(@RequestBody CustomerCreateRequest customer){
        return customerService.createCustomer(customer);
    }

    @GetMapping("/get/{id}")
    public GetCustomerResponse getCustomer(@PathVariable int id){
        return customerService.getCustomer(id);
    }

    @GetMapping("/getAll")
    public List<Customer> getAllCustomer(){
        return customerService.getAllCustomer();
    }
}
