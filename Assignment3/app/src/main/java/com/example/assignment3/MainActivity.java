package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et1,et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        et1= (EditText) findViewById ( R.id.text );
        et2=(EditText)findViewById ( R.id.editTextTextPassword);
    }

    public void logIn(View view) {
        if(!et1.getText ().toString ().equals ( "" ) && !et2.getText ().toString ().equals ( "" )){
            Intent i = new Intent ( getApplicationContext (),MainActivity2.class );
            i.putExtra ( "name",et1.getText ().toString () );
            startActivity ( i );
        }else {
            Toast.makeText ( this,"Please enter Username and Password!",Toast.LENGTH_SHORT ).show ();
        }


    }

    public void register(View view) {
        Intent intent = new Intent ( getApplicationContext (),MainActivity3.class );
        startActivity ( intent );
    }
}