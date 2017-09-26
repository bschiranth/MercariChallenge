package com.mercari.mercaritest.dagger;

import android.app.Activity;
import android.content.Context;

import dagger.Provides;

/**
 * Created by bschiranth1692 on 9/25/17.
 */

public class ActivityModule {

    private Activity activity;

    public ActivityModule(Activity activity){
        this.activity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext(){
        return activity;
    }

}
