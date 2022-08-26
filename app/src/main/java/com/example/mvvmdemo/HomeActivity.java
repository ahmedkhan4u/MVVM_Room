package com.example.mvvmdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.mvvmdemo.ViewModels.MainActivityViewModel;

public class HomeActivity extends AppCompatActivity {

    MainActivityViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        try {
            Log.d("dxdiag", viewModel.getText().getValue().toString());
        } catch (Exception e) {
            Log.d("dxdiag", e.getMessage());
        }
    }
}