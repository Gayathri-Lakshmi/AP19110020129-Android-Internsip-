package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main2 );
        TextView tv = (TextView) findViewById ( R.id.text );
        tv.setText ( "User Details:\n"+"Roll No.:\t"+getIntent ().getStringExtra ( "rollNo" )+"\n"+"Name:\t"+getIntent ().getStringExtra ( "name" )+
                 "\n"+"Phone No.:\t"+getIntent ().getStringExtra ( "phone" )+ "\n"+"Email:\t"+getIntent ().getStringExtra ( "email" )+
                "\n"+"Password:\t"+getIntent ().getStringExtra ( "pass" )+"\n"+"Gender:\t"+getIntent ().getStringExtra ( "gender" )+
                "\n"+"Branch:\t"+getIntent ().getStringExtra ( "bramch" ));
    }
}