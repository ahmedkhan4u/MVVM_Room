package com.example.mvvmdemo.AppDatabase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {

    @Query("Select * From User")
    LiveData<List<User>> getAllUsers();

    @Insert
    void insert(User user);

    @Delete
    void deleteUser(User user);

    @Update
    void updateUser(User user);

}
