package com.campuseats.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Commande — Fonctionnalité : Commander et payer
 * Responsable : Membre 3
 * Branche Git : feature/commande-paiement
 */
public class Commande {

    // Enumération des statuts possibles
    public enum Statut {
        EN_ATTENTE, EN_PREPARATION, PRETE, LIVREE, ANNULEE
    }

    // Champs privés
    private int id;
    private Etudiant etudiant;
    private List<Plat> platsCommandes;
    private double total;
    private Statut statut;
    private String heureCommande;

    // Constructeur vide
    public Commande() {
        this.platsCommandes = new ArrayList<>();
        this.statut = Statut.EN_ATTENTE;
        this.total = 0.0;
    }

    // Constructeur complet
    public Commande(int id, Etudiant etudiant, String heureCommande) {
        this.id = id;
        this.etudiant = etudiant;
        this.heureCommande = heureCommande;
        this.platsCommandes = new ArrayList<>();
        this.statut = Statut.EN_ATTENTE;
        this.total = 0.0;
    }

    // ===== MÉTHODES MÉTIER =====

    /**
     * Ajoute un plat à la commande
     */
    public boolean ajouterPlat(Plat plat) {
        if (plat == null || !plat.isDisponible()) {
            System.out.println("  ❌ Plat indisponible.");
            return false;
        }
        platsCommandes.add(plat);
        calculerTotal();
        System.out.println("  ✅ Plat ajouté à la commande : " + plat.getNom() + " (" + plat.getPrix() + " DT)");
        return true;
    }

    /**
     * Calcule le total de la commande
     */
    public double calculerTotal() {
        this.total = 0.0;
        for (Plat p : platsCommandes) {
            this.total += p.getPrix();
        }
        return this.total;
    }

    /**
     * Passe la commande et effectue le paiement
     */
    public boolean passerCommande() {
        if (platsCommandes.isEmpty()) {
            System.out.println("  ❌ Impossible de commander : panier vide.");
            return false;
        }
        calculerTotal();
        System.out.println("  💳 Total à payer : " + total + " DT");

        // Débiter le solde de l'étudiant
        boolean paiementOk = etudiant.debiterSolde(total);
        if (!paiementOk) return false;

        // Réduire le stock de chaque plat commandé
        for (Plat p : platsCommandes) {
            p.reduireStock(1);
        }

        this.statut = Statut.EN_PREPARATION;
        System.out.println("  ✅ Commande #" + id + " confirmée ! Statut : EN PRÉPARATION");
        return true;
    }

    /**
     * Annule la commande et rembourse l'étudiant
     */
    public boolean annulerCommande() {
        if (statut == Statut.LIVREE) {
            System.out.println("  ❌ Impossible d'annuler : commande déjà livrée.");
            return false;
        }
        if (statut == Statut.ANNULEE) {
            System.out.println("  ❌ Commande déjà annulée.");
            return false;
        }
        // Rembourser si déjà payée
        if (statut == Statut.EN_PREPARATION || statut == Statut.PRETE) {
            etudiant.rechargerSolde(total);
            System.out.println("  💰 Remboursement de " + total + " DT effectué.");
        }
        this.statut = Statut.ANNULEE;
        System.out.println("  ✅ Commande #" + id + " annulée.");
        return true;
    }

    /**
     * Affiche les détails de la commande
     */
    public void afficherDetails() {
        System.out.println("  --- Commande #" + id + " ---");
        System.out.println("  Étudiant  : " + etudiant.getPrenom() + " " + etudiant.getNom());
        System.out.println("  Heure     : " + heureCommande);
        System.out.println("  Plats     :");
        for (Plat p : platsCommandes) {
            System.out.println("             • " + p.getNom() + " — " + p.getPrix() + " DT");
        }
        System.out.println("  Total     : " + total + " DT");
        System.out.println("  Statut    : " + statut);
    }

    @Override
    public String toString() {
        return "Commande{id=" + id + ", etudiant='" + etudiant.getPrenom() + "', total=" + total + " DT, statut=" + statut + "}";
    }

    // ===== GETTERS & SETTERS =====
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Etudiant getEtudiant() { return etudiant; }
    public void setEtudiant(Etudiant etudiant) { this.etudiant = etudiant; }
    public List<Plat> getPlatsCommandes() { return platsCommandes; }
    public void setPlatsCommandes(List<Plat> platsCommandes) { this.platsCommandes = platsCommandes; }
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
    public Statut getStatut() { return statut; }
    public void setStatut(Statut statut) { this.statut = statut; }
    public String getHeureCommande() { return heureCommande; }
    public void setHeureCommande(String heureCommande) { this.heureCommande = heureCommande; }
}
