package com.example.assignment2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv1;
    TextView tv2;
    String n1,n2;
    int m1,m2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        tv1 = (TextView) findViewById ( R.id.text );
        tv2 = (TextView) findViewById ( R.id.text1 );
        n1=tv1.getText ().toString ();
        n2=tv2.getText ().toString ();

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState ( outState );
        outState.putString ( "count1",n1 );
        outState.putString ( "count2",n2 );
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState ( savedInstanceState );
        n1=savedInstanceState.getString ( "count1" );
        n2=savedInstanceState.getString ( "count2" );

    }

    public void oneA(View view) {
        m1=Integer.parseInt ( n1 );
        m1++;
        n1=Integer.toString ( m1 );
        tv1.setText (n1 );
    }

    public void twoA(View view) {
        m1=Integer.parseInt ( n1 );
        m1=m1+2;
        n1=Integer.toString ( m1 );
        tv1.setText (n1 );
    }

    public void threeA(View view) {
        m1=Integer.parseInt ( n1 );
        m1=m1+3;
        n1=Integer.toString ( m1 );
        tv1.setText (n1 );
    }

    public void oneB(View view) {
        m2=Integer.parseInt ( n2 );
        m2++;
        n2=Integer.toString ( m2 );
        tv2.setText (n2 );
    }

    public void twoB(View view) {
        m2=Integer.parseInt ( n2 );
        m2=m2+2;
        n2=Integer.toString ( m2 );
        tv2.setText (n2 );
    }

    public void threeB(View view) {
        m2=Integer.parseInt ( n2 );
        m2=m2+3;
        n2=Integer.toString ( m2 );
        tv2.setText (n2 );
    }

    public void reset(View view) {
        n1=n2="0";
        tv1.setText (n1 );
        tv2.setText (n2 );
    }
}