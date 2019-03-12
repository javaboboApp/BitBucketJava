package com.example.bitbucket.data.repository.datasource;


import com.example.bitbucket.data.entites.TransactionEntity;
import com.example.bitbucket.domain.models.Transaction;

import java.util.List;

import rx.Observable;

public interface TransactionDataSource {

    Observable<TransactionEntity> getTransaction();



}
