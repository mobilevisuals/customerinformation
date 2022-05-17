package com.example.customerinfo.service;

import com.example.customerinfo.domain.Customer;
import com.example.customerinfo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomerByUsername(String userName) {
        Customer theCustomer =null;
        List<Customer> customers = customerRepository.findByUserName(userName);
        if(customers.size()>0)
        theCustomer = customers.get(0);//it can only be one customer
        return theCustomer;
    }

}
