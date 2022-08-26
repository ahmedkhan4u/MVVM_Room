package com.example.mvvmdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;

import com.example.mvvmdemo.AppDatabase.User;
import com.example.mvvmdemo.ViewModels.MainActivityViewModel;
import com.example.mvvmdemo.ViewModels.UserViewModel;
import com.example.mvvmdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    UserViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel = new ViewModelProvider(this).get(UserViewModel.class);

        viewModel.getUserData().observe(this, users -> {
            String text = "";
            for (int i=0; i< users.size(); i++) {
                text += users.get(i).getId() + " : " + users.get(i).getFirstName()
                        + " " + users.get(i).getLastName() + "\n";
            }
            binding.text.setText(text);
        });

        binding.insert.setOnClickListener(view -> {
            viewModel.insertUser(new User("Test", "User"));
        });

        binding.delete.setOnClickListener(view -> {
            User user = new User("Ahmed", "Khan");
            user.setId(2);
            viewModel.deleteUser(user);
        });

        binding.update.setOnClickListener(view -> {
            User user = new User("Updated", "Name");
            user.setId(7);
            viewModel.updateUser(user);
        });


    }
}