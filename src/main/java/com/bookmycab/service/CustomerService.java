package com.bookmycab.service;

import com.bookmycab.exceptions.CustomerExceptions;
import com.bookmycab.model.Customer;

import java.util.List;


public interface CustomerService {
     Customer insertCustomer(Customer customer);
     Customer updateCustomer(Customer customer, Integer customerId) throws CustomerExceptions;
     Customer deleteCustomer(Integer customerId) throws CustomerExceptions;
     List<Customer> viewCustomers();
     Customer viewCustomer(Integer customerId) throws CustomerExceptions;
     Customer validateCustomer(String username, String password) throws CustomerExceptions;


}
