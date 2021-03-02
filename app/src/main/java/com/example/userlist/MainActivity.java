package com.example.userlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.userlist.Adapter.CharacterAdapter;
import com.example.userlist.Adapter.UserAdapter;
import com.example.userlist.ViewModel.CharacterViewModel;
import com.example.userlist.ViewModel.UserViewModel;
import com.example.userlist.databinding.ActivityMainBinding;

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
        getCharacters();
        observeCharacters();
        //getUsers();
        //observeUsers();
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

    public static class Character {
        private int id;
        private String name;
        private String nickname;
        private String username;
        private String technique;
        private String image;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getTechnique() {
            return technique;
        }

        public void setTechnique(String technique) {
            this.technique = technique;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public Character(int id, String name, String username, String technique, String image) {
            this.id = id;
            this.name = name;
            this.username = username;
            this.technique = technique;
            this.image = image;
        }
    }
}