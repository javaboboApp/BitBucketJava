package com.example.bitbucket;


import android.app.Application;
import android.content.Context;

import com.example.bitbucket.di.components.DaggerMainComponent;
import com.example.bitbucket.di.components.MainComponent;
import com.example.bitbucket.di.modules.ApplicationModule;
import com.example.bitbucket.di.modules.MainModule;
import com.example.bitbucket.di.modules.NetworkModule;
import com.example.bitbucket.ui.helpers.ConstUtils;


public class BitBuketApp extends Application {


    private static Context context;



    private MainComponent mainComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();


    }

    private void initializeInjector() {
        mainComponent = DaggerMainComponent.builder().mainModule(new MainModule(this))
                .applicationModule(new ApplicationModule(this))
                .networkModule(new NetworkModule(ConstUtils.BASE_URL))

                .build();
    }

    public MainComponent getMainComponent() {
        return mainComponent;
    }


}
