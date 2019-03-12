package com.example.bitbucket.di.components;

import android.content.Context;


import com.example.bitbucket.data.repository.TransactionRepository;
import com.example.bitbucket.di.modules.ApplicationModule;
import com.example.bitbucket.di.modules.DataSourceModule;
import com.example.bitbucket.di.modules.MainModule;
import com.example.bitbucket.di.modules.NetworkModule;
import com.example.bitbucket.di.modules.RepositoriesModule;
import com.example.bitbucket.di.modules.SchedulerModule;
import com.example.bitbucket.rx.SchedulerProvider;
import com.example.bitbucket.ui.views.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton @Component(modules = {ApplicationModule.class, MainModule.class, NetworkModule.class, RepositoriesModule.class, SchedulerModule.class,
        DataSourceModule.class}) public interface MainComponent {

    void inject(MainActivity activity);

    Context context();

    SchedulerProvider schedulerProvider();

    TransactionRepository transactionRepository();
}
