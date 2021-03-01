package com.example.userlist.ViewModel;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

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

public class UserViewModel extends AndroidViewModel {
    private final MutableLiveData<List<User>> userLiveData = new MutableLiveData<>();

    public UserViewModel(@NonNull Application application){
        super(application);
    }

    public void getUser(Context ctx){
        String url = "https://jsonplaceholder.typicode.com/users";
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Gson convertidor = new Gson();
                Type tipolistaUsers = new TypeToken<List<User>>(){}.getType();
                List<User> users = convertidor.fromJson(response.toString(), tipolistaUsers);
                userLiveData.setValue(users);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ctx, String.valueOf(error), Toast.LENGTH_LONG).show();
            }
        });
        VolleySingleton.getInstance(ctx).addToRequestQueue(request);
    }

    public LiveData<List<User>> getUsers () {
        return  userLiveData;
    }
}
