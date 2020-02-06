package com.example.dbservice;

import com.example.dbservice.model.Quote;
import com.example.dbservice.repository.QuotesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableJpaRepositories(basePackages = "com.example.dbservice.repository")
//jdbc:h2:mem:testdb

@SpringBootApplication

public class DbServiceApplication {

    private QuotesRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(DbServiceApplication.class, args);



//        repository.save( new Quote("hej", "da"));



    }

//    @Bean
//    CommandLineRunner runner(QuotesRepository repository){
//
//
//      return (args) -> {
//
//          repository.save(new Quote("hej", "då"));
//          System.out.println(repository);
//      }  ;
//    }

}
