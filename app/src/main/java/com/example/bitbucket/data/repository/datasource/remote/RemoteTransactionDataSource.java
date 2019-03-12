package com.example.bitbucket.data.repository.datasource.remote;


import com.example.bitbucket.data.entites.TransactionEntity;
import com.example.bitbucket.data.repository.datasource.TransactionDataSource;
import com.example.bitbucket.domain.network.StoreService;

import rx.Observable;

public class RemoteTransactionDataSource implements TransactionDataSource {

    private final StoreService mTransactionService;

    public RemoteTransactionDataSource(StoreService transactionStoreService) {
        this.mTransactionService = transactionStoreService;
    }


    @Override
    public Observable<TransactionEntity> getTransaction() {
        return mTransactionService.getTransaction();
    }
}
