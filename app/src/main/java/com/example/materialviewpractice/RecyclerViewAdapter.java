package com.example.materialviewpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<Contacts> contacts = new ArrayList<>();
    private Context context;

    public RecyclerViewAdapter(ArrayList<Contacts> contacts, Context context) {
        this.contacts = contacts;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nameTxt.setText(contacts.get(position).getName());
        holder.ageTxt.setText(contacts.get(position).getAge());

        Glide.with(context).asBitmap().load(contacts.get(position).getImageUrl())
                .centerCrop().dontAnimate().into(holder.imgView);

        //Setting Click Action
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, contacts.get(position).getName(),Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public void setContacts(ArrayList<Contacts> contacts) {
        this.contacts = contacts;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView nameTxt,ageTxt;
        private ImageView imgView;
        private CardView parentHolder;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTxt = itemView.findViewById(R.id.recyclerName);
            ageTxt = itemView.findViewById(R.id.recyclerAge);
            imgView = itemView.findViewById(R.id.recyclerImgView);
            parentHolder = itemView.findViewById(R.id.recyclerViewItem);
        }
    }
}
