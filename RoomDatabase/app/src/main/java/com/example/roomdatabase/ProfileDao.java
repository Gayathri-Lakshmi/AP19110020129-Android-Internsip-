package com.example.roomdatabase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProfileDao {

    @Insert
    public void insert(Profile profile);

    @Query( "SELECT * FROM ProfileData")
    public LiveData<List<Profile>> readData();

    @Delete
    public void delete(Profile profile);

    @Update
    public void update(Profile profile);
}
