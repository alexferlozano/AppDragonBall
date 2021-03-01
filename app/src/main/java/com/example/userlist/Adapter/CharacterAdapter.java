package com.example.userlist.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.userlist.Models.Character;
import com.example.userlist.User;
import com.example.userlist.databinding.ListCharactersBinding;
import com.example.userlist.databinding.ListUsersBinding;

import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.ViewHolder> {
    private final List<Character> charactersList;

    public CharacterAdapter (List<Character> charactersList) {
        this.charactersList=charactersList;
    }

    @NonNull
    @Override
    public CharacterAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        final ListCharactersBinding listCharacterBinding = ListCharactersBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent,false);
        return new CharacterAdapter.ViewHolder(listCharacterBinding);
    }

    @Override
    public void onBindViewHolder(final CharacterAdapter.ViewHolder holder, final int position)
    {
        final Character character = this.charactersList.get(position);
        holder.bind(character);
    }

    @Override
    public int getItemCount() {
        return charactersList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ListCharactersBinding listCharactersBinding;

        public ViewHolder(@NonNull ListCharactersBinding listView)
        {
            super(listView.getRoot());
            this.listCharactersBinding=listView;
        }
        private void bind (Character character){ this.listCharactersBinding.setCharacter(character);
        }
    }
}
