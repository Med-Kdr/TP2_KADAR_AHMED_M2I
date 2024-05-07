package com.example.tp2_kadar_ahmed_m2i.Exercice1;

public class Etudiant {
    int id;
    String nom;
    String prenom;
    String date;
    String cne;

    public Etudiant(int id, String nom, String prenom, String date, String cne) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.date = date;
        this.cne = cne;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }
}
