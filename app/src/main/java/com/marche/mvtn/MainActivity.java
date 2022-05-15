package com.marche.mvtn;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {
    RecyclerView annRycleView ;
    ArrayList<Ann> annArrayList;
    AnnDAO annDaO;
    FirebaseFirestore db;
    ProgressDialog prog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prog = new ProgressDialog(this);
        prog.setCancelable(false);
        prog.setMessage("La7adhat barka ...");
        prog.show();

       annRycleView = findViewById(R.id.annRycle);
       annRycleView.setHasFixedSize(true);
       annRycleView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
       db = FirebaseFirestore.getInstance();
       annArrayList = new ArrayList<Ann>();
       annDaO = new AnnDAO(MainActivity.this,annArrayList,this);
       annRycleView.setAdapter(annDaO);
       
       getDataListner();
    }

    private void getDataListner() {
        db.collection("ANNONCES").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if(error!= null){
                    if(prog.isShowing()){
                        prog.dismiss();
                    }
                    Log.e("PORoblem de data ftech",error.getMessage());
                    return;

                }
                for (DocumentChange docu  :value.getDocumentChanges()){
                    if(docu.getType()==DocumentChange.Type.ADDED){
                        annArrayList.add(docu.getDocument().toObject(Ann.class));
                    }
                    annDaO.notifyDataSetChanged();
                    if(prog.isShowing()){
                        prog.dismiss();
                    }
                }
            }
        });
    }

    @Override
    public void clickann(int position) {
        Intent  intent = new Intent(MainActivity.this,AnnDetail.class);


        intent.putExtra("Titre",annArrayList.get(position).getTitre());
        intent.putExtra("Marque",annArrayList.get(position).getMarque());
        intent.putExtra("Modele",annArrayList.get(position).getModele());
        intent.putExtra("Etat",annArrayList.get(position).getEtat());
        intent.putExtra("Cat",annArrayList.get(position).getCategory());
        intent.putExtra("Kilometrage",Long.toString(annArrayList.get(position).getKilometrage()));
        intent.putExtra("Puissance",Long.toString(annArrayList.get(position).getPuissance()));
        intent.putExtra("Energie",annArrayList.get(position).getEnergie());
        intent.putExtra("Desc",annArrayList.get(position).getDescription());
        intent.putExtra("Prix",Long.toString( annArrayList.get(position).getPrix()));
        intent.putExtra("Image",annArrayList.get(position).getImage());
        startActivity(intent);

    }
}