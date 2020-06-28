package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    EditText text,pass,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main3 );
        text = (EditText)findViewById ( R.id.text );
        pass = (EditText)findViewById ( R.id.editTextTextPassword );
        email = (EditText)findViewById ( R.id.editTextTextEmailAddress );
    }

    public void register(View view) {
        if(!text.getText ().toString ().equals ( "" ) && !pass.getText ().toString ().equals ( "" ) && !email.getText ().toString ().equals ( "" )){
            Intent i = new Intent ( getApplicationContext (),MainActivity2.class );
            i.putExtra ( "name",text.getText ().toString () );
            startActivity ( i );
        }else {
            Toast.makeText ( this,"Please fill the above details!",Toast.LENGTH_SHORT ).show ();
        }
    }
}