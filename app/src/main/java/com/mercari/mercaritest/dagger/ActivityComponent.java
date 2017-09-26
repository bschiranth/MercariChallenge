package com.mercari.mercaritest.dagger;

import com.mercari.mercaritest.ui.MainActivity;

import dagger.Component;

/**
 * Created by bschiranth1692 on 9/25/17.
 */

@PerActivity
@Component(dependencies = AppComponent.class, modules = {ActivityModule.class})
public interface ActivityComponent {

    void inject(MainActivity mainActivity);
}
