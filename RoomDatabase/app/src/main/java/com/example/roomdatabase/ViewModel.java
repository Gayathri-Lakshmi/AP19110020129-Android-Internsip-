package com.example.roomdatabase;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ViewModel extends AndroidViewModel {

    Repository repository;
    LiveData<List<Profile>> getAllData;
    public ViewModel(@NonNull Application application) {
        super ( application );
        repository=new Repository ( application );
        getAllData=repository.readAllData ();
    }

    public void Insert(Profile profile){
        repository.insert ( profile );
    }

    public void update(Profile profile){
        repository.Update ( profile );
    }

    public void delete(Profile profile){
        repository.Deleter(profile );
    }
    public  LiveData<List<Profile>> readData(){
        return getAllData;
    }

}
