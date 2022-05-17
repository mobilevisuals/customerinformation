package com.example.customerinfo.repository;

import com.example.customerinfo.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

   List<Customer> findByUserNameAndPassword(String userName,String password);
List<Customer> findByUserName(String userName);

}
