package com.example.covid19india;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class Covid extends AsyncTask<Void,Void,String> {

    Context context;
    String url ="https://api.covid19api.com/dayone/country/IN";
    ProgressDialog pd;
    RecyclerView recyclerView;

    public Covid(MainActivity mainActivity, RecyclerView rv) {

        context=mainActivity;
        recyclerView=rv;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute ();
        pd=new ProgressDialog (context);
        pd.setMessage ( "Please wait..." );
        pd.setProgressStyle ( ProgressDialog.STYLE_SPINNER );
        pd.setCanceledOnTouchOutside(false);
        pd.show ();


    }



    @Override
    protected String doInBackground(Void... voids) {
        try {
            URL u = new URL(url);
            HttpsURLConnection connection =(HttpsURLConnection) u.openConnection ();
            InputStream i = connection.getInputStream ();
            BufferedReader bf=new BufferedReader ( new InputStreamReader ( i ) );
            String s ;
            s=" ";
            StringBuilder sb = new StringBuilder (  );
            while((s=bf.readLine ())!=null){
                sb.append ( s );

            }
            return sb.toString ();

        } catch (MalformedURLException e) {
            e.printStackTrace ();
            Log.i("Exception:","!");
            Log.i("e:",e.toString ());
        } catch (IOException e) {
            e.printStackTrace ();
            Log.i("Exception:","!");
            Log.i("e:",e.toString ());
        }

        return " ";
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute ( s );
        pd.dismiss ();
        List<Cases> caseslist =new ArrayList<> (  );
        try {
            JSONArray jsonArray=new JSONArray ( s );
            for (int i= jsonArray.length ()-1;i>=0;i--){
                JSONObject jsonObject = jsonArray.getJSONObject ( i );
                String active = jsonObject.getString ( "Active" );
                String recovered = jsonObject.getString ( "Recovered" );
                String deaths = jsonObject.getString ( "Deaths" );
                String date = jsonObject.getString ( "Date" );

                Cases c =new Cases(date,active,recovered,deaths);
                caseslist.add ( c );



            }
            recyclerView.setLayoutManager ( new LinearLayoutManager ( context ) );
            recyclerView.setAdapter ( new Adapter (context,caseslist) );
        } catch (JSONException e) {
            e.printStackTrace ();
        }

    }

}
