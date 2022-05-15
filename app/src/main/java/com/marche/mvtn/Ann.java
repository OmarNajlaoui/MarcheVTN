package com.marche.mvtn;

public class Ann {

    String Category,Description,Energie,Etat,Image,Modele,Titre,Uid,Marque;
    long Kilometrage,Puissance,Prix;
   public Ann(){}
    public Ann(String category, String description, String energie, String etat, String image, String modele, String titre,String marque, String uid, long kilometrage, long puissance, long prix) {
        Category = category;
        Description = description;
        Energie = energie;
        Etat = etat;
        Image = image;
        Modele = modele;
        Marque =marque;
        Titre = titre;
        Uid = uid;
        Kilometrage = kilometrage;
        Puissance = puissance;
        Prix = prix;
    }

    public String getMarque() {
        return Marque;
    }

    public void setMarque(String marque) {
        Marque = marque;
    }
    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getEnergie() {
        return Energie;
    }

    public void setEnergie(String energie) {
        Energie = energie;
    }

    public String getEtat() {
        return Etat;
    }

    public void setEtat(String etat) {
        Etat = etat;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getModele() {
        return Modele;
    }

    public void setModele(String modele) {
        Modele = modele;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String titre) {
        Titre = titre;
    }

    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        Uid = uid;
    }

    public long getKilometrage() {
        return Kilometrage;
    }

    public void setKilometrage(long kilometrage) {
        Kilometrage = kilometrage;
    }

    public long getPuissance() {
        return Puissance;
    }

    public void setPuissance(long puissance) {
        Puissance = puissance;
    }

    public long getPrix() {
        return Prix;
    }

    public void setPrix(long prix) {
        Prix = prix;
    }
}
