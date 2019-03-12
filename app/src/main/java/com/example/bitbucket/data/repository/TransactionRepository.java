package com.example.bitbucket.data.repository;



import com.example.bitbucket.domain.models.Transaction;

import rx.Observable;

public interface TransactionRepository {
    Observable<Transaction> getTransaction();

}
