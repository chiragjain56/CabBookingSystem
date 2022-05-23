package com.bookmycab.service;

import com.bookmycab.exceptions.CustomerException;
import com.bookmycab.model.Customer;

import java.util.List;


public interface CustomerService {
    Customer insertCustomer(Customer customer);

    Customer updateCustomer(Customer customer, Integer customerId) throws CustomerException;

    Customer deleteCustomer(Integer customerId) throws CustomerException;

    List<Customer> viewCustomers();

    Customer viewCustomer(Integer customerId) throws CustomerException;

    Customer validateCustomer(String username, String password) throws CustomerException;

}
