package com.mercari.mercaritest.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mercari.mercaritest.R;
import com.mercari.mercaritest.utils.Constants;
import com.mercari.mercaritest.utils.JsonUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerViewId)
    RecyclerView recyclerView;

    SaleAdapter saleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new GridLayoutManager(this, Constants.NUMBER_OF_COLUMNS));
        saleAdapter = new SaleAdapter(this);
        recyclerView.setAdapter(saleAdapter);
        recyclerView.setHasFixedSize(true);

        JsonUtils.parseJson(this,saleAdapter);
    }
}
