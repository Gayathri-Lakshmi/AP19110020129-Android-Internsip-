package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class AddProfile extends AppCompatActivity {

    EditText name,phone,mail,address,dep;
    CheckBox tel,eng,hin;
    RadioGroup rg;
    RadioButton male,female;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_add_profile );
        name=findViewById ( R.id.name );
        phone=findViewById ( R.id.phone );
        mail=findViewById ( R.id.mail );
        address=findViewById ( R.id.address );
        dep=findViewById ( R.id.dep );
        tel=findViewById ( R.id.tel );
        eng=findViewById ( R.id.eng );
        hin=findViewById ( R.id.hin );
        rg=findViewById ( R.id.rg );
        male=findViewById ( R.id.male );
        female=findViewById ( R.id.female );

    }

    public void save(View view) {

        String nm=name.getText ().toString ();
        String ph=phone.getText ().toString ();
        String email=mail.getText ().toString ();
        String add=address.getText ().toString ();
        String depart=dep.getText ().toString ();
        String gender="";
        String lang ="";

        if(male.isChecked ()){
            gender="Male";
        }
        else if(female.isChecked ()){
            gender="Female";
        }
        else{
            Toast.makeText (AddProfile.this,"Please Check either male or female",Toast.LENGTH_SHORT ).show ();
        }

        if(tel.isChecked ()){
            lang=lang+"Telugu,";
        }
        if(hin.isChecked ()){
            lang=lang+"Hindi,";
        }
        if(eng.isChecked ()){
            lang=lang+"English,";
        }


        Profile profile = new Profile ();
        profile.setName(nm);
        profile.setAddress ( add );
        profile.setGender ( gender );
        profile.setLanguages ( lang );
        profile.setMailId ( email );
        profile.setPhoneNo ( ph );
        profile.setDepartment ( depart );


        MainActivity.vm.Insert ( profile );

        Toast.makeText ( AddProfile.this,"Data saved successfully!",Toast.LENGTH_SHORT ).show ();

        finish ();


        }





}