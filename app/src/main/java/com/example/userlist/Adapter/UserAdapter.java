package com.example.userlist.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.userlist.User;
import com.example.userlist.databinding.ListUsersBinding;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private final List<User> userList;

    public UserAdapter (List<User> userList) {
        this.userList=userList;
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        final ListUsersBinding listUsersBinding = ListUsersBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent,false);
        return new UserAdapter.ViewHolder(listUsersBinding);
    }

    @Override
    public void onBindViewHolder(final UserAdapter.ViewHolder holder, final int position)
    {
        final User user = this.userList.get(position);
        holder.bind(user);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ListUsersBinding listUsersBinding;

        public ViewHolder(@NonNull ListUsersBinding listView)
        {
            super(listView.getRoot());
            this.listUsersBinding=listView;
        }
        private void bind (User user){ this.listUsersBinding.setUser(user);
        }
    }
}
