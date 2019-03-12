package com.example.bitbucket.di.modules;

import android.content.Context;

import com.example.bitbucket.BitBuketApp;
import com.example.bitbucket.domain.usecases.GetTransaction;
import com.example.bitbucket.rx.SchedulerProvider;
import com.example.bitbucket.ui.mvp.contracts.TransactionContract;
import com.example.bitbucket.ui.mvp.presenters.TransactionActivityPresenter;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class MainModule {

    private final BitBuketApp bitBuketApp;

    public MainModule(BitBuketApp sumraApp) {
        this.bitBuketApp = sumraApp;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return bitBuketApp;
    }


    @Provides
    TransactionContract.Presenter providePreferencesPresenter(SchedulerProvider schedulerProvider,
                                                                      GetTransaction getTransaction) {
        return new TransactionActivityPresenter(schedulerProvider, getTransaction);
    }




}
