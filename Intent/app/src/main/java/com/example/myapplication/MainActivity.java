package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    String n;
    TextView text;
    int m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        text = (TextView) findViewById ( R.id.text );
        n= text.getText ().toString ();


    }





    public void Toast(View view) {
        n= text.getText ().toString ();
        Intent i =new Intent ( getApplicationContext (),MainActivity2.class );
        i.putExtra ( "num",n );
        startActivity ( i );

    }

    public void count(View view) {
        m=Integer.parseInt ( n );
        m++;
        n=Integer.toString ( m );
        text.setText ( n );
    }
}