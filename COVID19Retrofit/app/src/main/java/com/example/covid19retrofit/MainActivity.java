package com.example.covid19retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Retrofit retrofit;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        tv=(TextView) findViewById ( R.id.text );
        pd=new ProgressDialog ( this );
        pd.setMessage ( "Please wait..." );
        pd.setProgressStyle ( ProgressDialog.STYLE_SPINNER );
    }

    public void enter(View view) {
        pd.show ();
        retrofit=new Retrofit.Builder ().
                baseUrl ( "https://api.covid19api.com/" ).
                addConverterFactory ( ScalarsConverterFactory.create () ).build ();
        Covid19Api api = retrofit.create ( Covid19Api.class );
        Call<String> covid = api.getInfo ();
        covid.enqueue ( new Callback<String> () {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {



                try {
                    JSONArray jsonArray=new JSONArray ( response.body ());
                    JSONObject jsonObject = jsonArray.getJSONObject ( 0);
                    String active = jsonObject.getString ( "Active" );
                    String recovered = jsonObject.getString ( "Recovered" );
                    String deaths = jsonObject.getString ( "Deaths" );
                    String date = jsonObject.getString ( "Date" );
                    tv.append ( active+"\n" );
                    tv.append ( recovered+"\n" );
                    tv.append ( deaths+"\n" );
                    tv.append ( date+"\n" );
                    pd.dismiss ();


                } catch (JSONException e) {
                    e.printStackTrace ();
                }


            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        } );


    }
}