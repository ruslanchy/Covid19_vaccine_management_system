package com.example.covid19_vaccine_management_system;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterReview extends RecyclerView.Adapter<AdapterReview.myViewHolder> {
    ArrayList<ReviewModel> slist;
    Context context;
    public AdapterReview(Context context, ArrayList<ReviewModel> slist){
        this.slist=slist;
        this.context=context;
    }
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.activity_item2,parent,false);
        return new myViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
       ReviewModel model1=slist.get(position);
       holder.fname.setText(model1.getName());
        holder.age.setText(model1.getAge());
        holder.review3.setText(model1.getReview1());
        holder.review4.setText(model1.getReview2());
    }

    @Override
    public int getItemCount() {
        return slist.size();
    }

    public static class myViewHolder extends RecyclerView.ViewHolder{
        TextView fname,age,review3,review4;

        public myViewHolder(@NonNull  View itemView2){
            super(itemView2);
            fname=(TextView)itemView2.findViewById(R.id.name_tv);
            age=(TextView)itemView2.findViewById(R.id.Age_tv);
            review3=(TextView)itemView2.findViewById(R.id.seeReview1_tv);
            review4=(TextView)itemView2.findViewById(R.id.seeReview2_tv);
        }
    }
}
