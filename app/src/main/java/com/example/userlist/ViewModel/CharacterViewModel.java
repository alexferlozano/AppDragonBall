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
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.userlist.MainActivity;
import com.example.userlist.VolleySingleton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.List;

public class CharacterViewModel extends AndroidViewModel {
    private final MutableLiveData<List<Character>> characterLiveData = new MutableLiveData<>();

    public CharacterViewModel(@NonNull Application application){
        super(application);
    }

    public void getCharacter(Context ctx){
        String url = "http://192.168.0.13:3333/characters";
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Gson convertidor = new Gson();
                Type tipolistaCharacter = new TypeToken<List<Character>>(){}.getType();
                List<Character> characters = convertidor.fromJson(response.toString(), tipolistaCharacter);
                characterLiveData.setValue(characters);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ctx, String.valueOf(error), Toast.LENGTH_LONG).show();
            }
        });
        VolleySingleton.getInstance(ctx).addToRequestQueue(request);
    }

    public LiveData<List<Character>> getCharacters () {
        return  characterLiveData;
    }
}
