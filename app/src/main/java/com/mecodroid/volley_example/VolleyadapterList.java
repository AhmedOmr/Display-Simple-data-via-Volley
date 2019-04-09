package com.mecodroid.volley_example;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class VolleyadapterList extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    viewHolder holders;
    Context context;
    ArrayList<Models> volleylists;

    public VolleyadapterList(Context context, ArrayList<Models> volleylists) {
        this.context = context;
        this.volleylists = volleylists;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listnobeldesign, viewGroup, false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        holders = (viewHolder) viewHolder;
        holders.text1.setText(volleylists.get(i).getPname());
        holders.text2.setText(volleylists.get(i).getPemail());
        holders.text3.setText(volleylists.get(i).getPphone());
        holders.text4.setText(volleylists.get(i).getPaddress());
        holders.text5.setText(volleylists.get(i).getPcompany());

    }

    @Override
    public int getItemCount() {
        return volleylists !=null ?volleylists.size():0;
    }


    class viewHolder extends RecyclerView.ViewHolder {
        TextView text1, text2, text3, text4, text5;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            text1 = itemView.findViewById(R.id.textv11);
            text2 = itemView.findViewById(R.id.textv21);
            text3 = itemView.findViewById(R.id.textv31);
            text4 = itemView.findViewById(R.id.textv41);
            text5 = itemView.findViewById(R.id.textv51);

        }
    }
}
