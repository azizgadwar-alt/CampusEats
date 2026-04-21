package com.campuseats.models;

/**
 * Classe Plat — représente un plat du menu
 * Utilisée par la classe Menu
 */
public class Plat {

    // Champs privés
    private int id;
    private String nom;
    private double prix;
    private int stock;
    private String categorie;
    private boolean disponible;

    // Constructeur vide
    public Plat() {}

    // Constructeur complet
    public Plat(int id, String nom, double prix, int stock, String categorie) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.stock = stock;
        this.categorie = categorie;
        this.disponible = stock > 0;
    }

    /**
     * Affiche les détails du plat
     */
    public void afficherDetails() {
        String dispo = disponible ? "✅ Disponible" : "❌ Épuisé";
        System.out.println("  [" + id + "] " + nom + " — " + prix + " DT | Stock: " + stock + " | " + dispo);
    }

    /**
     * Réduit le stock d'une portion
     */
    public boolean reduireStock(int quantite) {
        if (stock < quantite) {
            System.out.println("  ❌ Stock insuffisant pour : " + nom);
            return false;
        }
        this.stock -= quantite;
        if (this.stock == 0) this.disponible = false;
        return true;
    }

    /**
     * Réapprovisionne le stock
     */
    public void reapprovisionner(int quantite) {
        this.stock += quantite;
        this.disponible = true;
        System.out.println("  ✅ Stock de " + nom + " mis à jour : " + this.stock + " portions");
    }

    @Override
    public String toString() {
        return nom + " (" + prix + " DT)";
    }

    // ===== GETTERS & SETTERS =====
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public double getPrix() { return prix; }
    public void setPrix(double prix) { this.prix = prix; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
    public String getCategorie() { return categorie; }
    public void setCategorie(String categorie) { this.categorie = categorie; }
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
}
