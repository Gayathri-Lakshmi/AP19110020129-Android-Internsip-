package com.example.covid19india;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    Context ct;
    List cases;
    public  Adapter(Context context, List<Cases> caseslist){
        ct=context;
        cases= caseslist;

    }

    @NonNull
    @Override
    public Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from ( ct ).inflate ( R.layout.design,parent,false );
        return new MyViewHolder ( v );
    }


    @Override
    public void onBindViewHolder(@NonNull Adapter.MyViewHolder holder, int position) {
        Cases c=(Cases)cases.get ( position );
        holder.date.setText ( c.getDate () );
        holder.active.setText ( c.getActive () );
        holder.deaths.setText ( c.getDeaths () );
        holder.recovered.setText ( c.getRecovered () );

    }


    @Override
    public int getItemCount() {
        return cases.size ();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView date,active,recovered,deaths;
        public MyViewHolder(@NonNull View itemView) {
            super ( itemView );
            date=itemView.findViewById ( R.id.date );
            active=itemView.findViewById ( R.id.active );
            recovered=itemView.findViewById ( R.id.recovered );
            deaths=itemView.findViewById ( R.id.deaths );

        }
    }
}
