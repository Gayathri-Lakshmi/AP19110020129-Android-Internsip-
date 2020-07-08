package com.example.recyclerviewproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {


    int myImages[];
    String myNames[],myversions[],myapis[],mydates[];
    Context context;

    public Adapter(MainActivity mainActivity,int images[],String names[],String versions[], String apis[],String dates[]  ){
        myImages=images;
        myapis=apis;
        mydates=dates;
        myNames=names;
        context=mainActivity;
        myversions = versions;
    }
    @NonNull
    @Override
    public Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from ( context).inflate ( R.layout.design,parent,false );
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.MyViewHolder holder, int position) {
        holder.iv.setImageResource ( myImages[position] );
        holder.tv1.setText ( myNames[position] );
        holder.tv2.setText ( myversions[position] );
        holder.tv3.setText ( myapis[position] );
        holder.tv4.setText ( mydates[position] );


    }

    @Override
    public int getItemCount() {
        return myapis.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv1,tv2,tv3,tv4;
        public MyViewHolder(@NonNull View itemView) {
            super ( itemView );

            iv=itemView.findViewById ( R.id.image );
            tv1=itemView.findViewById ( R.id.name );
            tv2=itemView.findViewById ( R.id.version );
            tv3=itemView.findViewById ( R.id.api );
            tv4=itemView.findViewById ( R.id.date );


        }
    }
}
