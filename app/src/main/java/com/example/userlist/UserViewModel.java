package com.example.userlist;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class UserViewModel extends AndroidViewModel {
    private final MutableLiveData<List<User>> userLiveData = new MutableLiveData<>();

    public UserViewModel(@NonNull Application application){
        super(application);
    }

    public LiveData<List<User>> getUsers () {
        return  userLiveData;
    }
}
