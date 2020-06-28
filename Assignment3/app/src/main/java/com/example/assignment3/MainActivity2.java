package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main2 );
        String s= getIntent ().getStringExtra ( "name" );
        TextView tv = (TextView) findViewById ( R.id.textView );
        tv.setText ( "Welcome: \n"+s );
    }
}