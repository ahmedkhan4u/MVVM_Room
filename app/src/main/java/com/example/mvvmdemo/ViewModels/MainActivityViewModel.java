package com.example.mvvmdemo.ViewModels;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<String> text;

    private MutableLiveData<String> name;

    public MutableLiveData<String> getName() {

        if (name == null) {
            name = new MutableLiveData<String>();
        }

        return name;
    }

    public MutableLiveData<String> getText() {
        if (text == null) {
            text = new MutableLiveData<String>();
        }

        return text;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("dxdiag", "On Cleared");
    }
}
