package com.example.userlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.userlist.databinding.ListUsersBinding;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private final List<User> userList;
    //private LayoutInflater mInflater;
    //private Context context;

    public UserAdapter (List<User> userList, Context context)
    {
        //this.mInflater=LayoutInflater.from(context);
        //this.context=context;
        this.userList=userList;
    }

    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        final ListUsersBinding listUsersBinding = ListUsersBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent,false);
        //View view=mInflater.inflate(R.layout.list_users,null);
        return new UserAdapter.ViewHolder(listUsersBinding);
    }

    @Override
    public void onBindViewHolder(final UserAdapter.ViewHolder holder, final int position)
    {
        final User user = this.userList.get(position);
        holder.bind(user);
        //holder.bindData(userList.get(position));
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private final ListUsersBinding listUsersBinding;
        //TextView name;
        //TextView username;
        //TextView email;

        public ViewHolder(ListUsersBinding listView)
        {
            super(listView.getRoot());
            this.listUsersBinding=listView;
            /*name=itemView.findViewById(R.id.name);
            username=itemView.findViewById(R.id.username);
            email=itemView.findViewById(R.id.email);*/
        }
        /*public void bindData(final User user)
        {
            name.setText(user.getName());
            username.setText(user.getUsername());
            email.setText(user.getEmail());
        }*/
        private void bind (User user){
            this.listUsersBinding.setUser(user);
        }
    }
}
