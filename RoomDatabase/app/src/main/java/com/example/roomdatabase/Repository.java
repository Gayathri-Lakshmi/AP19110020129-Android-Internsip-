package com.example.roomdatabase;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class Repository {

    ProfileDatabase profileDatabase;
    LiveData<List<Profile>> readData;

    public Repository(Application application) {

        profileDatabase=profileDatabase.getDatabase ( application );
        readData=profileDatabase.myDao ().readData ();


    }

    public void insert(Profile profile){

        new InsertTask ().execute ( profile );
    }

    public LiveData<List<Profile>> readAllData(){
        return readData;
    }

    public void Update(Profile profile){
        new  UpdateTask ().execute ( profile ) ;
    }

    public void Deleter(Profile profile){
        new DeleteTask ().execute ( profile );
    }




    class InsertTask extends AsyncTask<Profile,Void,Void> {


        @Override
        protected Void doInBackground(Profile... students) {
            profileDatabase.myDao ().insert ( students[0] );
            return null;
        }
    }


    class UpdateTask extends AsyncTask<Profile,Void,Void>{



        @Override
        protected Void doInBackground(Profile... profiles) {
            profileDatabase.myDao ().update ( profiles[0] );
            return null;
        }
    }

    class DeleteTask extends AsyncTask<Profile,Void,Void>{


        @Override
        protected Void doInBackground(Profile... profiles) {
            profileDatabase.myDao ().delete ( profiles[0] );
            return null;
        }
    }

}
