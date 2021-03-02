package com.example.userlist.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.userlist.MainActivity;
import com.example.userlist.databinding.ListCharactersBinding;

import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.ViewHolder> {
    private final List<MainActivity.Character> charactersList;

    public CharacterAdapter (List<MainActivity.Character> charactersList) {
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
        final MainActivity.Character character = this.charactersList.get(position);
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
        private void bind (MainActivity.Character character){ this.listCharactersBinding.setCharacter(character);
        }
    }
}
