package com.example.userlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.userlist.databinding.ActivityMainBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RequestQueue queue;
    private ActivityMainBinding mainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        queue=VolleySingleton.getInstance(getApplicationContext()).getRequestQueue();
        ObtenerDatos();
    }
    private void ObtenerDatos()
    {
        String url="https://jsonplaceholder.typicode.com/users";
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Gson convertidor= new Gson();
                Type tipolistaUsers =new TypeToken<List<User>>(){}.getType();
                List<User> users=convertidor.fromJson(response.toString(),tipolistaUsers);
                UserAdapter userAdapter= new UserAdapter(users,MainActivity.this);
                RecyclerView recyclerView= findViewById(R.id.reView);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerView.setAdapter(userAdapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,String.valueOf(error),Toast.LENGTH_LONG).show();
            }
        });
        queue.add(request);
    }
}