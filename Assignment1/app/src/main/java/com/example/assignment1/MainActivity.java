package com.example.assignment1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    String n;
    int m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        tv = (TextView) findViewById ( R.id.textView );
        n= tv.getText ().toString ();
        if (savedInstanceState != null) {
            String count = savedInstanceState.getString("count");
            if (tv != null)
                tv.setText(count);
        }

    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState ( outState );
        outState.putString("count",
                String.valueOf(tv.getText()));

    }

    public void plus(View view) {
        m=Integer.parseInt ( n );
        m++;
        n=Integer.toString ( m );
        tv.setText (n );
    }

    public void minus(View view) {
        m=Integer.parseInt ( n );
        m--;
        n=Integer.toString ( m );
        tv.setText ( n);
    }

    public void zero(View view) {
        tv.setText ( "0");
    }

    public void toast(View view) {
        Toast.makeText(this,"Your Count: "+n, Toast.LENGTH_SHORT).show ();

    }
}