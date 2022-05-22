package com.bookmycab.controller;


import com.bookmycab.exceptions.CustomerExceptions;
import com.bookmycab.model.Customer;
import com.bookmycab.repository.CustomerRepository;
import com.bookmycab.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer")
    public List<Customer> viewCustomers(){
        return customerService.viewCustomers();
    }

    @GetMapping("/customer/{id}")
    public Customer viewCustomer(@PathVariable("id") Integer id) throws CustomerExceptions {

        return customerService.viewCustomer(id);
    }

    @PutMapping("/customer/{id}")
    public Customer updateCustomer(@RequestBody Customer customer, @PathVariable("id") Integer id) throws CustomerExceptions{
        return customerService.updateCustomer(customer,id);
    }

    @PostMapping("/customer")
    public Customer insertCustomer(@RequestBody Customer customer){
        return customerService.insertCustomer(customer);
    }

    @DeleteMapping("/customer/{id}")
    public Customer deleteCustomer(@PathVariable("id") Integer id){
       return customerService.deleteCustomer(id);
    }

    @GetMapping("/customer/{name}/{pass}")
    public Customer validateCustomer(@PathVariable("user") String username, @PathVariable("pass") String password) throws CustomerExceptions{
        return  customerService.validateCustomer(username,password);
    }
}
