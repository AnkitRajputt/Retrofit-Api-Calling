package com.example.retrofitapicalling;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.animation.ImageMatrixProperty;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {

    MainActivity mainActivity;
    List<UserModel> userModels;

    public UserAdapter(MainActivity mainActivity, List<UserModel> userModels) {
        this.mainActivity= mainActivity;
        this.userModels= userModels;
    }

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserHolder(LayoutInflater.from(mainActivity).inflate(R.layout.item_users, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder holder, int position) {
        holder.txt_name.setText(userModels.get(position).getName());
        holder.txt_email.setText(userModels.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return userModels.size();
    }

    class UserHolder extends RecyclerView.ViewHolder {
        TextView txt_name, txt_email;

        public UserHolder(@NonNull View itemView) {
            super(itemView);
            txt_name= itemView.findViewById(R.id.txt_name);
            txt_email= itemView.findViewById(R.id.txt_email);
        }
    }

}
