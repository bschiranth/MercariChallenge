package com.mercari.mercaritest.dagger;

import android.app.Activity;
import android.content.Context;

import com.mercari.mercaritest.ui.SaleAdapter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by bschiranth1692 on 9/25/17.
 */

@Module
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

    @Provides
    public SaleAdapter providesAdapter(@ActivityContext Context context){
        return new SaleAdapter(context);
    }

}
