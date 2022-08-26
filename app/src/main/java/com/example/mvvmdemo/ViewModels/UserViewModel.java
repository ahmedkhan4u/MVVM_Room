package com.example.mvvmdemo.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mvvmdemo.AppDatabase.User;
import com.example.mvvmdemo.AppDatabase.UserRepsitory;

import java.util.List;

public class UserViewModel extends AndroidViewModel {

    private UserRepsitory repsitory;
    private LiveData<List<User>> userData;

    public UserViewModel(@NonNull Application application) {
        super(application);
        repsitory = new UserRepsitory(application);
        userData = repsitory.getAllUsers();
    }

    public void insertUser(User user){
        repsitory.insertUser(user);
    }

    public void deleteUser(User user){
        repsitory.deleteUser(user);
    }

    public void updateUser(User user){
        repsitory.updateUser(user);
    }

    public LiveData<List<User>> getUserData() {
        return userData;
    }
}
