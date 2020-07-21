package com.example.roomdatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.List;

public class Adapter  extends RecyclerView.Adapter<Adapter.MyDataViewHolder> {

    Context ct;
    List<Profile> list;
    public Adapter(MainActivity mainActivity, List<Profile> profiles) {
        ct=mainActivity;
        list=profiles;
    }


    @NonNull
    @Override
    public MyDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from ( ct ).inflate ( R.layout.design,parent,false );
        return new MyDataViewHolder ( v );
    }

    @Override
    public void onBindViewHolder(@NonNull MyDataViewHolder holder, int position) {

        final Profile profile=list.get ( position );
        holder.name.setText ( profile.getName () );
        holder.phone.setText ( profile.getPhoneNo () );
        holder.mail.setText ( profile.getMailId () );
        holder.lang.setText ( profile.getLanguages () );
        holder.add.setText ( profile.getAddress () );
        holder.dep.setText ( profile.getDepartment () );
        holder.gen.setText ( profile.getGender () );

        holder.del.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                MainActivity.vm.delete ( profile );

            }
        } );

    }


    @Override
    public int getItemCount() {
        return list.size ();
    }

    public class MyDataViewHolder extends RecyclerView.ViewHolder {

        TextView name,phone,mail,dep,gen,add,lang;
        Button del,updt;


        public MyDataViewHolder(@NonNull View itemView) {
            super ( itemView );
            name=itemView.findViewById ( R.id.name);
            phone=itemView.findViewById ( R.id.phoneNo);
            mail=itemView.findViewById ( R.id.emailId);
            dep=itemView.findViewById ( R.id.dept);
            gen=itemView.findViewById ( R.id.gen);
            add=itemView.findViewById ( R.id.add);
            lang=itemView.findViewById ( R.id.lang);
            del=itemView.findViewById ( R.id.delete);
            updt=itemView.findViewById ( R.id.update);

            updt.setOnClickListener ( new View.OnClickListener () {
                @Override
                public void onClick(View v) {

                    final String sName =name.getText ().toString ();
                    final String sGen=gen.getText ().toString ();
                    final String sLang=lang.getText ().toString ();
                    final String sAdd = add.getText ().toString ();
                    final String sDept =dep.getText ().toString ();
                    final String sMail =mail.getText ().toString ();
                    final String sPhone =phone.getText ().toString ();

                    ViewGroup vg =v.findViewById ( android.R.id.content );
                    View view=LayoutInflater.from ( ct ).inflate ( R.layout.update,vg );

                    final EditText uName=view.findViewById ( R.id.updatename );
                    final EditText uGen=view.findViewById ( R.id.updategender);
                    final EditText uLang=view.findViewById ( R.id.updatelang);
                    final EditText uAdd=view.findViewById ( R.id.updateadd);
                    final EditText uDep=view.findViewById ( R.id.updatedep);
                    final EditText uMail=view.findViewById ( R.id.updateemail );
                    final EditText uPhone=view.findViewById ( R.id.updatephone );

                    Button usave=view.findViewById ( R.id.save );
                    Button ucancel= view.findViewById (R.id.cancel);

                    final BottomSheetDialog dialog=new BottomSheetDialog ( ct);
                    dialog.setContentView ( view );
                    dialog.setCancelable ( false );

                    uAdd.setText ( sAdd );
                    uGen.setText ( sGen );
                    uLang.setText ( sLang );
                    uDep.setText ( sDept );
                    uName.setText ( sName );
                    uMail.setText ( sMail );
                    uPhone.setText ( sPhone );

                    usave.setOnClickListener ( new View.OnClickListener () {
                        @Override
                        public void onClick(View v) {


                            Profile profile = new Profile ();
                            profile.setMailId ( uMail.getText ().toString () );
                            profile.setPhoneNo ( uPhone.getText ().toString () );
                            profile.setName ( uName.getText ().toString () );
                            profile.setLanguages ( uLang.getText ().toString () );
                            profile.setGender ( uGen.getText ().toString () );
                            profile.setAddress ( uAdd.getText ().toString () );
                            profile.setDepartment ( uDep.getText ().toString () );

                            MainActivity.vm.update ( profile );
                            Toast.makeText ( ct,"Data Updated Successfully!" ,Toast.LENGTH_SHORT).show ();
                            dialog.dismiss ();

                        }
                    } );




                    ucancel.setOnClickListener ( new View.OnClickListener () {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss ();
                        }
                    } );
                    dialog.show ();



                }
            } );

        }
    }
}
