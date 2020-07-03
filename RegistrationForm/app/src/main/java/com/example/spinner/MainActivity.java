package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    EditText roll,name,phone,email,pass;
    RadioButton gen_male,gen_female,cse,ece,eee,civil,mech;
    String gender,branch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        roll = (EditText) findViewById ( R.id.roll );
        name= (EditText) findViewById(R.id.name);
        phone=(EditText) findViewById(R.id.no);
        email=(EditText) findViewById(R.id.email);
        pass=(EditText) findViewById(R.id.pass);
        gen_male=(RadioButton) findViewById ( R.id.radio_male );
        gen_female=(RadioButton) findViewById(R.id.radio_female);
        cse=(RadioButton) findViewById(R.id.cse);
        ece=(RadioButton) findViewById(R.id.ece);
        eee=(RadioButton) findViewById(R.id.eee);
        civil=(RadioButton) findViewById(R.id.civil);
        mech=(RadioButton) findViewById(R.id.mech);
    }

    public void submit(View view) {
        if(gen_male.isChecked ()){
            gender=gen_male.getText ().toString ();
        }
        else if(gen_female.isChecked ()){
            gender=gen_female.getText ().toString ();
        } else {
            Toast.makeText ( this, "Please fill the above details", Toast.LENGTH_SHORT ).show ();
        }

        if(cse.isChecked ()){
            branch=cse.getText ().toString ();
        }
        else if(ece.isChecked ()){
            branch=ece.getText ().toString ();
        }
        else if(civil.isChecked ()){
            branch=civil.getText ().toString ();
        }
        else if(eee.isChecked ()){
            branch=eee.getText ().toString ();
        }
        else if(mech.isChecked ()){
            branch=mech.getText ().toString ();
        }
        else{
            Toast.makeText ( this, "Please fill the above details", Toast.LENGTH_SHORT ).show ();
        }

        if(!roll.getText ().toString ().equals ( "" ) && !name.getText ().toString ().equals ( "" ) && !email.getText ().toString ().equals ( "" ) &&
                !phone.getText ().toString ().equals ( "" ) && !pass.getText ().toString ().equals ( "" )){
            Intent i = new Intent ( getApplicationContext (),MainActivity2.class );
            i.putExtra ( "rollNo",roll.getText ().toString () );
            i.putExtra ( "name",name.getText ().toString () );
            i.putExtra ( "phone",phone.getText ().toString () );
            i.putExtra ( "email",email.getText ().toString () );
            i.putExtra ( "pass",pass.getText ().toString ());
            i.putExtra ( "gender",gender );
            i.putExtra ( "branch",branch );
            startActivity ( i );
        }
        else{
            Toast.makeText ( this, "Please fill the above details", Toast.LENGTH_SHORT ).show ();
        }
    }
}