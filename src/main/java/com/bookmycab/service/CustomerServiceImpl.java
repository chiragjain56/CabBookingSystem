package com.bookmycab.service;

import com.bookmycab.exceptions.CustomerExceptions;
import com.bookmycab.model.Customer;
import com.bookmycab.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepositry;

    @Override
    public Customer insertCustomer(Customer customer)throws CustomerExceptions {
      return customerRepositry.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer, Integer id) throws CustomerExceptions {
        Customer customerDb = customerRepositry.findById(id)
                .orElseThrow(() -> new CustomerExceptions("Admin doesn't exist with id : " + customer.getUserId()));

        if (Objects.nonNull(customer.getUsername()) &&
                !"".equalsIgnoreCase(customer.getUsername()))
            customerDb.setUsername(customer.getUsername());

        if (Objects.nonNull(customer.getName()) &&
                !"".equalsIgnoreCase(customer.getName()))
            customerDb.setName(customer.getName());

        if (Objects.nonNull(customer.getPassword()) &&
                !"".equalsIgnoreCase(customer.getPassword()))
            customerDb.setPassword(customer.getPassword());

        if (Objects.nonNull(customer.getEmail()) &&
                !"".equalsIgnoreCase(customer.getEmail()))
            customerDb.setEmail(customer.getEmail());

        if (Objects.nonNull(customer.getMobileNo()) &&
                customer.getMobileNo() != 0)
            customerDb.setMobileNo(customer.getMobileNo());


        return customerRepositry.save(customerDb);
    }

    @Override
    public Customer deleteCustomer(Integer customerId) throws CustomerExceptions {
       Customer customer =  customerRepositry.findById(customerId).orElseThrow(() -> new CustomerExceptions("Customer doesn't exist with this Id"+ customerId));
       customerRepositry.delete(customer);
       return customer;
    }

    @Override
    public List<Customer> viewCustomers() {
        return customerRepositry.findAll();
    }

    @Override
    public Customer viewCustomer(Integer customerId) throws CustomerExceptions {
        Customer customer = customerRepositry.findById(customerId).orElseThrow(() -> new CustomerExceptions("Customer doesn't exist with this ID "+ customerId));
        return customer;
    }

    @Override
    public Customer validateCustomer(String username, String password) throws CustomerExceptions {
       Customer customer = customerRepositry.validateCustomer(username,password);
       if(customer == null)
           throw new CustomerExceptions("Customer doesn't Exist... Sorry!");
       else
           return customer;
    }
}
