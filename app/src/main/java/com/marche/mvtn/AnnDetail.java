package com.marche.mvtn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class AnnDetail extends AppCompatActivity {

    private static final String TAG = "hedha ann details" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ann_detail);
         TextView Titre = findViewById(R.id.annTitreplus);
         TextView Marque = findViewById(R.id.annMarqueplus);
         TextView Modele = findViewById(R.id.annModeleplus);
         TextView Puissance = findViewById(R.id.annPuiss);
         TextView Etat = findViewById(R.id.annEtat);
         TextView Kilometrage =findViewById(R.id.annKm);
         TextView Category =findViewById(R.id.annCat);
         TextView Prix =findViewById(R.id.annPrix);
         TextView desc =findViewById(R.id.annDesc);
         TextView Energie = findViewById(R.id.annEnergie);
        ImageView Image = findViewById(R.id.annImgPlus);
         Button ctct_btn = findViewById(R.id.register_btn);


        String titre_dt = getIntent().getStringExtra("Titre");
        String marque_dt = getIntent().getStringExtra("Marque");
        String modele_dt = getIntent().getStringExtra("Modele");
        String categ_dt = getIntent().getStringExtra("Cat");
        String etat_dt = getIntent().getStringExtra("Etat");
        String kilometrage_dt = getIntent().getStringExtra("Kilometrage");
        String puissance_dt = getIntent().getStringExtra("Puissance");
        String Ensergie_dt = getIntent().getStringExtra("Energie");
        String Desc_dt = getIntent().getStringExtra("Desc");
        String prix_dt = getIntent().getStringExtra("Prix");

        String img = getIntent().getStringExtra("Image");



        Titre.setText("Titre : " + titre_dt);
        Marque.setText("Marque : " + marque_dt);
        Modele.setText("Modele : " + modele_dt);
        Puissance.setText("Puissance : " + puissance_dt + "CV");
        Etat.setText("Etat : " + etat_dt);
        Kilometrage.setText("Kilometrage : " + kilometrage_dt + "KM");
        Category.setText("Categorie : " + categ_dt);
        Energie.setText("Energie : " + Ensergie_dt);
        desc.setText("Description : " + Desc_dt);
        Prix.setText("PRIX: " + prix_dt + "DT");
        Glide.with(this).load(img).into(Image);


    }
}