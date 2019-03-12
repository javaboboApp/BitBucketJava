package com.example.bitbucket.domain.usecases;


import com.example.bitbucket.data.repository.TransactionRepository;
import com.example.bitbucket.domain.models.Transaction;

import javax.inject.Inject;

import rx.Observable;


public class GetTransaction {
    private TransactionRepository transactionRepository;

    @Inject
    public GetTransaction(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }


    public Observable<Transaction> getTransaction() {
        return transactionRepository.getTransaction();
    }

}
