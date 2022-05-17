package com.example.customerinfo;

import com.example.customerinfo.domain.Customer;
import com.example.customerinfo.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerinfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerinfoApplication.class, args);
    }

    @Bean
    public CommandLineRunner setup(CustomerRepository customerRepository) {
        return (args) -> { //Encrypted with Bcrypt password 'ererFhh'
            customerRepository.save(new Customer("gustav", "$2a$12$Ycr2WiZpcAbUQjggACkIqOQ2WWrmbK.Ev1b.OwL07hAbjF3Al4d8a", "Pommervägen 2","0709363283",1));


        };
    }

}
