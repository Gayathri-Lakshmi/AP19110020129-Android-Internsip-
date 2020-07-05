package com.example.list_contextmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView list;
    ArrayList<String> items= new ArrayList<> ();
    ArrayAdapter adapter;

    Button click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        list = (ListView) findViewById ( R.id.list );
        registerForContextMenu ( list );
        click=(Button)findViewById ( R.id.button ) ;
        registerForContextMenu ( click );
        items.add("Store one");
        items.add("Store two");
        items.add("XYZ Shop");
        items.add("Abc Store");
        items.add("Store A");
        items.add("Store B");
        adapter = new ArrayAdapter ( this,android.R.layout.simple_list_item_1,items );
        list.setAdapter ( adapter );


        list.setOnItemLongClickListener ( new AdapterView.OnItemLongClickListener(){
                                              @Override
                                              public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                                                  return false;
                                              }
                                          }
        );
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        if(v.getId ()==R.id.list) {
            ((MenuInflater) inflater).inflate ( R.menu.menu_context, menu );
        }
        else{
            ((MenuInflater) inflater).inflate ( R.menu.menu_context_button, menu );
        }
        }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.coupons:
                Toast.makeText ( this,"Coupons Selected",Toast.LENGTH_SHORT ).show ();
                return true;
            case R.id.cashback:
                Toast.makeText ( this,"Cashback Selected",Toast.LENGTH_SHORT ).show ();
                return true;
            case R.id.deals:
                Toast.makeText ( this,"Deals Selected",Toast.LENGTH_SHORT ).show ();
            case R.id.notification:
                Toast.makeText ( this,"Notifications Selected",Toast.LENGTH_SHORT ).show ();
            case R.id.help:
                Toast.makeText ( this,"Help Selected",Toast.LENGTH_SHORT ).show ();
            case R.id.settings:
                Toast.makeText ( this,"Settings Selected",Toast.LENGTH_SHORT ).show ();
            case R.id.logOut:
                Toast.makeText ( this,"LogOUt Selected",Toast.LENGTH_SHORT ).show ();
            default:
                Toast.makeText ( this,"Please select one of the options",Toast.LENGTH_SHORT ).show ();
                return super.onContextItemSelected(item);
        }
    }

}