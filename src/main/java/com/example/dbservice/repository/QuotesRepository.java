package com.example.dbservice.repository;

import com.example.dbservice.model.Quote;
import com.example.dbservice.model.Quotes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface QuotesRepository extends CrudRepository<Quote, Long> {
    List<Quote> findByUserName(String username);
}
