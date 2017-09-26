package com.mercari.mercaritest.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mercari.mercaritest.R;
import com.mercari.mercaritest.dagger.ActivityComponent;
import com.mercari.mercaritest.dagger.ActivityModule;
import com.mercari.mercaritest.dagger.DaggerActivityComponent;
import com.mercari.mercaritest.dagger.MercariApp;
import com.mercari.mercaritest.utils.Constants;
import com.mercari.mercaritest.utils.JsonUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerViewId)
    RecyclerView recyclerView;

    @Inject
    SaleAdapter saleAdapter;

    ActivityComponent activityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        getActivityComponent().inject(this);

        recyclerView.setLayoutManager(new GridLayoutManager(this, Constants.NUMBER_OF_COLUMNS));
        recyclerView.setAdapter(saleAdapter);
        recyclerView.setHasFixedSize(true);

        JsonUtils.parseJson(this,saleAdapter);
    }

    public ActivityComponent getActivityComponent(){
        if(activityComponent == null){
            activityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    .appComponent(MercariApp.get(this).getAppComponent())
                    .build();
        }
        return activityComponent;
    }
}
