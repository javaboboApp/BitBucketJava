package com.example.bitbucket.di.modules;


import com.example.bitbucket.rx.SchedulerProvider;
import com.example.bitbucket.rx.SchedulerProviderImpl;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class SchedulerModule {

    @Binds
    public abstract SchedulerProvider bindSchedulerProvider(SchedulerProviderImpl schedulerProvider);
}
