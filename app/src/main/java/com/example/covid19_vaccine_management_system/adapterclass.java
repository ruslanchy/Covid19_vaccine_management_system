package com.example.covid19_vaccine_management_system;

import android.content.Context;
import android.graphics.ColorSpace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapterclass extends RecyclerView.Adapter<adapterclass.myviewholder> {
    ArrayList<usermodel> mList;
    Context context;

    public adapterclass(Context context,ArrayList<usermodel> mList){
        this.mList=mList;
        this.context=context;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(context).inflate(R.layout.activity_item,parent,false);
       return new myviewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        usermodel userModel = mList.get(position);
        holder.full_name.setText(userModel.getName());
        holder.email_admin.setText(userModel.getEmail());
        holder.adress_admin.setText(userModel.getAdress());
        holder.age_admin.setText(userModel.getAge());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class myviewholder extends RecyclerView.ViewHolder{
        TextView full_name , email_admin , adress_admin , age_admin;
        public myviewholder(@NonNull View itemView) {
            super(itemView);

            full_name = (TextView)itemView.findViewById(R.id.fullname_tv);
            email_admin = (TextView)itemView.findViewById(R.id.email_tv);
            adress_admin = (TextView)itemView.findViewById(R.id.adress_tv);
            age_admin = (TextView)itemView.findViewById(R.id.age_tv);
        }
    }
}
