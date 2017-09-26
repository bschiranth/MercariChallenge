package com.mercari.mercaritest.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mercari.mercaritest.R;
import com.mercari.mercaritest.data.model.Item;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by bschiranth1692 on 9/21/17.
 */

public class SaleAdapter extends RecyclerView.Adapter<SaleAdapter.SaleViewHolder>{

    private List<Item> items ;
    private Context context;

    public SaleAdapter(Context context) {
        this.context = context;
    }

    public void updateAdapter(List<Item> items){
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    public SaleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
        SaleViewHolder saleViewHolder = new SaleViewHolder(view);
        return saleViewHolder;
    }

    @Override
    public void onBindViewHolder(SaleViewHolder holder, int position) {

        if(items == null) return;

        Item item = items.get(position);
        holder.menTextView.setText(item.name);
        holder.priceTextView.setText("$"+item.price);
        Glide.with(context)
                .load(item.photo)
                .placeholder(android.R.drawable.progress_indeterminate_horizontal)
                .into(holder.menImageView);
        if(item.status.equals("sold_out")){
            holder.soldImageView.setVisibility(View.VISIBLE);
        }else {
            holder.soldImageView.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {

        if(items != null)
            return items.size();

        return 0;
    }

    public class SaleViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.menTextViewId)
        TextView menTextView;

        @BindView(R.id.priceTextViewId)
        TextView priceTextView;

        @BindView(R.id.soldImageViewId)
        ImageView soldImageView;

        @BindView(R.id.menImageViewId)
        ImageView menImageView;

        public SaleViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);
        }
    }

}
