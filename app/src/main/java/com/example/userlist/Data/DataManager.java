package com.example.userlist.Data;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.userlist.User;
import com.example.userlist.VolleySingleton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.List;

public class DataManager {
    public void getUsers(Context context) {
        String url = "https://jsonplaceholder.typicode.com/users";
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Gson convertidor = new Gson();
                Type tipolistaUsers = new TypeToken<List<User>>() {
                }.getType();
                convertidor.fromJson(response.toString(), tipolistaUsers);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, String.valueOf(error), Toast.LENGTH_LONG).show();
            }
        });
        VolleySingleton.getInstance(context).addToRequestQueue(request);
    }
}


