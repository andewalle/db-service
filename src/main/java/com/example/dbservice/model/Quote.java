package com.example.dbservice.model;


import javax.persistence.*;

@Entity

public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;

    private String quote;



    public Quote(String userName, String quote){
        this.userName = userName;
        this.quote = quote;

    }

    public Quote() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "userName='" + userName + '\'' +
                ", quote='" + quote + '\'' +
                '}';
    }
}
