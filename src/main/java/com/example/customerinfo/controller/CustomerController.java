package com.example.customerinfo.controller;

import com.example.customerinfo.domain.Customer;
import com.example.customerinfo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("/info")
    public String viewInformation(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        Customer customer = customerService.getCustomerByUsername(userName);
        model.addAttribute("theCustomer", customer);
        return "info";
    }

}
