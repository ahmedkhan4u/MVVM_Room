package com.example.mvvmdemo.AppDatabase;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class UserRepsitory {

    private UserDao userDao;
    private LiveData<List<User>> allUsers;

    public UserRepsitory(Application application) {
        UserDatabase database = UserDatabase.getInstance(application);
        userDao = database.userDao();
        allUsers = userDao.getAllUsers();
    }

    public void  insertUser(User user){
        new InsertUserAsyncTask(userDao).execute(user);

    }

    public void updateUser(User user){
        new UpdateUserAsyncTask(userDao).execute(user);
    }

    public void deleteUser(User user) {
        new DeleteUserAsyncTask(userDao).execute(user);
    }

    public LiveData<List<User>> getAllUsers() {
        return allUsers;
    }

    public static class InsertUserAsyncTask extends AsyncTask<User, Void, Void> {
        private UserDao userDao;
        public InsertUserAsyncTask(UserDao userDao){
            this.userDao = userDao;
        }
        @Override
        protected Void doInBackground(User... users) {
            userDao.insert(users[0]);
            return null;
        }
    }

    public static class DeleteUserAsyncTask extends AsyncTask<User, Void, Void> {
        private UserDao userDao;
        public DeleteUserAsyncTask(UserDao userDao){
            this.userDao = userDao;
        }
        @Override
        protected Void doInBackground(User... users) {
            userDao.deleteUser(users[0]);
            return null;
        }
    }

    public static class UpdateUserAsyncTask extends AsyncTask<User, Void, Void> {
        private UserDao userDao;
        public UpdateUserAsyncTask(UserDao userDao){
            this.userDao = userDao;
        }
        @Override
        protected Void doInBackground(User... users) {
            userDao.updateUser(users[0]);
            return null;
        }
    }
}
