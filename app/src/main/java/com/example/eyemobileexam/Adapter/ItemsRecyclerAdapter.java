package com.example.eyemobileexam.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.eyemobileexam.Model.Product;
import com.example.eyemobileexam.R;

import java.util.ArrayList;

public class ItemsRecyclerAdapter extends RecyclerView.Adapter<ItemsRecyclerAdapter.MyViewHolder> {
    private ArrayList<Product> data;
    private Context context;

    public ItemsRecyclerAdapter(Context context, ArrayList<Product> data) {
        this.context = context;
        this.data = data;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView priceText;
        TextView nameText;
        TextView typeText;

        public MyViewHolder(View v) {
            super(v);
            priceText = v.findViewById(R.id.priceText);
            nameText = v.findViewById(R.id.nameText);
            typeText = v.findViewById(R.id.typeText);
        }

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);

        MyViewHolder vh = new ItemsRecyclerAdapter.MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ItemsRecyclerAdapter.MyViewHolder holder, int position) {


        holder.priceText.setText("R$ " + data.get(position).getPrice());
        holder.nameText.setText(data.get(position).getName());
        holder.typeText.setText(data.get(position).getType());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        if(data != null && data.size() >0 ){
            return data.size();
        }else{
            return  0;
        }
    }



}
