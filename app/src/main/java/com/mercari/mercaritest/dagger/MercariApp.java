package com.mercari.mercaritest.dagger;

import android.app.Application;

import com.mercari.mercaritest.dagger.AppComponent;


public class MercariApp extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = AppComponent.Initializer.init(this);
        appComponent.inject(this);
    }
}
