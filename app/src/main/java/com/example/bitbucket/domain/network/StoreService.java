package com.example.bitbucket.domain.network;

import com.example.bitbucket.data.entites.TransactionEntity;


import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import rx.Observable;

public interface StoreService {

    @GET("/transactions")
    Observable<TransactionEntity> getTransaction();

}
