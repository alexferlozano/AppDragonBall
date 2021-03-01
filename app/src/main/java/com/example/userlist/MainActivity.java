package com.example.userlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.userlist.Adapter.CharacterAdapter;
import com.example.userlist.Adapter.UserAdapter;
import com.example.userlist.ViewModel.CharacterViewModel;
import com.example.userlist.ViewModel.UserViewModel;
import com.example.userlist.databinding.ActivityMainBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mainBinding;
    private UserViewModel userViewModel;
    private CharacterViewModel characterViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        this.userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        this.characterViewModel = new ViewModelProvider(this).get(CharacterViewModel.class);
        //getCharacters();
        //observeCharacters();
        getUsers();
        observeUsers();
    }
    private void observeUsers(){
        this.userViewModel.getUsers().observe(this, users -> {
            if (users != null){
                this.mainBinding.reView.setAdapter(new UserAdapter(users));
                /*UserAdapter userAdapter= new UserAdapter(users);
                RecyclerView recyclerView= this.mainBinding.reView;
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerView.setAdapter(userAdapter);*/
                //Toast.make
                // Text(getApplicationContext(), String.valueOf(users), Toast.LENGTH_LONG).show();
                //Rowper class
            }
        });
    }

    private void observeCharacters(){
        this.characterViewModel.getCharacters().observe(this, characters -> {
            if (characters != null){
                this.mainBinding.charView.setAdapter(new CharacterAdapter((characters)));
            }
        });
    }
    private void getCharacters(){
        this.characterViewModel.getCharacter(getApplicationContext());
    }
    private void getUsers() {
        this.userViewModel.getUser(getApplicationContext());
    }
}