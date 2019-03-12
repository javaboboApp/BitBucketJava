package com.example.bitbucket.data.repository.impl;


import com.example.bitbucket.data.repository.TransactionRepository;
import com.example.bitbucket.data.repository.datasource.TransactionDataSource;
import com.example.bitbucket.data.repository.datasource.mapper.TransactionEntityToTransactionMapper;
import com.example.bitbucket.domain.models.Transaction;

import rx.Observable;

public class TransactionRepositoryImpl implements TransactionRepository {

    private TransactionDataSource transactionDataSource;
    private TransactionEntityToTransactionMapper transactionEntityToTransactionMapper;


    public TransactionRepositoryImpl(TransactionDataSource transactionDataSource,
                                     TransactionEntityToTransactionMapper transactionEntityToTransactionMapper) {
        this.transactionDataSource = transactionDataSource;
        this.transactionEntityToTransactionMapper = transactionEntityToTransactionMapper;
    }

    @Override
    public Observable<Transaction> getTransaction() {
        return transactionDataSource.getTransaction().map(
                transactionEntity -> transactionEntityToTransactionMapper.reverseMap(transactionEntity));
    }
}
