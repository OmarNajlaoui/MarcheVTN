package com.marche.mvtn;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AnnDAO extends RecyclerView.Adapter<AnnDAO.viewHolder> {
    private final RecyclerViewInterface recyclerViewInterface;
    Context context ;
    ArrayList<Ann> annArrayList;

    public AnnDAO(Context context, ArrayList<Ann> annArrayList,RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.annArrayList = annArrayList;
        this.recyclerViewInterface =recyclerViewInterface;
    }

    @NonNull
    @Override
    public AnnDAO.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.ann,parent,false);
        return new viewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull AnnDAO.viewHolder holder, int position) {
        Ann ann = annArrayList.get(position);
        holder.titre.setText(ann.Titre);
        Glide.with(context).load(ann.Image).into(holder.img);
       // holder.img.setImageURI(Uri.parse(ann.Image));
        holder.desc.setText(ann.Description);
        holder.prix.setText(String.valueOf(ann.Prix));

    }

    @Override
    public int getItemCount() {
        return annArrayList.size();
    }
    public static class viewHolder extends RecyclerView.ViewHolder{
        TextView titre,desc,prix;
        ImageView img;
        Button card_btn;

        public viewHolder(@NonNull View itemView,RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            titre = itemView.findViewById(R.id.annTitre);
            desc =itemView.findViewById(R.id.annDesc);
            prix = itemView.findViewById(R.id.annPrix);
            img = itemView.findViewById(R.id.annImg);
            card_btn = itemView.findViewById(R.id.btnDetails);
            card_btn.setBackgroundColor(R.color.errouge);
            card_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(recyclerViewInterface !=null){
                        int posi = getAdapterPosition();
                        if(posi != RecyclerView.NO_POSITION){
                            recyclerViewInterface.clickann(posi);
                        }

                    }
                }
            });

        }
    }
}
