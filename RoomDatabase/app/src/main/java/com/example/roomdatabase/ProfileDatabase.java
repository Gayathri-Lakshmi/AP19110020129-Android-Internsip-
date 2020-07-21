package com.example.roomdatabase;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database( entities = Profile.class,version = 1,exportSchema = true)
public abstract class ProfileDatabase extends RoomDatabase {

    public abstract ProfileDao myDao();

    public static ProfileDatabase database;

    public static synchronized ProfileDatabase getDatabase(Context context) {
        if (database == null) {
            database = Room.databaseBuilder ( context, ProfileDatabase.class, "MYDB" )
                    .allowMainThreadQueries ().fallbackToDestructiveMigration ().build ();
        }
        return database;
    }





}
