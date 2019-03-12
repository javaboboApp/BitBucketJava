package com.example.bitbucket.di.modules;

import com.example.bitbucket.data.repository.datasource.TransactionDataSource;
import com.example.bitbucket.data.repository.datasource.remote.RemoteTransactionDataSource;
import com.example.bitbucket.domain.network.StoreService;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        includes = NetworkModule.class
)
public class DataSourceModule {

    @Provides
    @Singleton
    TransactionDataSource provideRemoteDataSource(StoreService storeService) {
        return new RemoteTransactionDataSource(storeService);
    }



}
