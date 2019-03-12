package com.example.bitbucket.domain.models;

import com.example.bitbucket.data.entites.StatementEntity;
import com.example.bitbucket.data.entites.TransactionEntity;

import java.util.List;

public class Transaction {
    private String culture;
    private String status;
    private List<Statement> statements;


    public String getCulture() {
        return culture;
    }

    public void setCulture(String culture) {
        this.culture = culture;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    public void setStatements(List<Statement> statements) {
        this.statements = statements;
    }
}
