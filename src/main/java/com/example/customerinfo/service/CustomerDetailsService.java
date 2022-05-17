package com.example.customerinfo.service;

import com.example.customerinfo.domain.Customer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashSet;

@Service
@Transactional
public class CustomerDetailsService implements UserDetailsService {

    private CustomerService customerService;

    public CustomerDetailsService(CustomerService customerService) {
        this.customerService = customerService;
    }

    //gets called automatic by Spring Security framework when a user tries to login. get the user to create a session for it.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user;
        Customer theCustomer = customerService.getCustomerByUsername(username);
        if (theCustomer == null)
            throw new UsernameNotFoundException("The user does not exist");
        else
        user=new User(username, theCustomer.getPassword(),true,true,true,true, new HashSet<GrantedAuthority>());
        return user;
    }

}
