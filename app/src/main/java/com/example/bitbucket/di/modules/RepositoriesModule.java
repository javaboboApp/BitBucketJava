package com.example.bitbucket.di.modules;

import com.example.bitbucket.data.repository.TransactionRepository;
import com.example.bitbucket.data.repository.datasource.TransactionDataSource;
import com.example.bitbucket.data.repository.datasource.mapper.StatementEntityToStatementsMapper;
import com.example.bitbucket.data.repository.datasource.mapper.TransactionEntityToTransactionMapper;
import com.example.bitbucket.data.repository.impl.TransactionRepositoryImpl;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoriesModule {

    @Singleton
    @Provides
    TransactionRepository provideTransactionRepository(TransactionDataSource transactionDataSource,
                                                       TransactionEntityToTransactionMapper transactionEntityToTransactionMapper) {
        return new TransactionRepositoryImpl(transactionDataSource,transactionEntityToTransactionMapper);
    }


    @Singleton
    @Provides
    StatementEntityToStatementsMapper provideGetStatementMapper() {
        return new StatementEntityToStatementsMapper();
    }

    @Singleton
    @Provides
    TransactionEntityToTransactionMapper provideGetTransactionMapper(StatementEntityToStatementsMapper statementEntityToStatementsMapper) {
        return new TransactionEntityToTransactionMapper(statementEntityToStatementsMapper);
    }


}
