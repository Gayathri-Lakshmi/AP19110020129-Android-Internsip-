package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    RecyclerView rv;
    static ViewModel vm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        textView=findViewById ( R.id.text );
        rv=findViewById ( R.id.recycle );

        vm=new ViewModelProvider ( this ).get ( ViewModel.class );

        vm.readData().observe ( this, new Observer<List<Profile>> () {
            @Override
            public void onChanged(List<Profile> profiles) {
                if(profiles.size ()==0){
                    textView.setVisibility ( View.VISIBLE );
                    rv.setVisibility ( View.GONE );
                }
                else {
                    textView.setVisibility ( View.GONE );
                    rv.setVisibility ( View.VISIBLE );
                    rv.setLayoutManager ( new LinearLayoutManager ( MainActivity.this ) );
                    rv.setAdapter ( new Adapter ( MainActivity.this, profiles ) );
                }

            }
        } );
    }

    public void add(View view) {

        startActivity ( new Intent ( this,AddProfile.class ) );
    }
}