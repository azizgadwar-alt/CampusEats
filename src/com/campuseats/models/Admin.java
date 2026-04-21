package com.campuseats.models;

import java.util.List;

/**
 * Classe Admin — Fonctionnalité : Tableau de bord et statistiques
 * Responsable : Membre 5
 * Branche Git : feature/admin-dashboard
 */
public class Admin {

    // Champs privés
    private int id;
    private String nom;
    private String email;
    private List<Etudiant> etudiants;
    private List<Commande> commandes;
    private List<Livraison> livraisons;

    // Constructeur vide
    public Admin() {}

    // Constructeur complet
    public Admin(int id, String nom, String email,
                 List<Etudiant> etudiants,
                 List<Commande> commandes,
                 List<Livraison> livraisons) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.etudiants = etudiants;
        this.commandes = commandes;
        this.livraisons = livraisons;
    }

    // ===== MÉTHODES MÉTIER =====

    /**
     * Affiche le tableau de bord complet
     */
    public void afficherTableauDeBord() {
        System.out.println("  ========== TABLEAU DE BORD ADMIN ==========");
        System.out.println("  Admin       : " + nom);
        System.out.println("  Étudiants inscrits  : " + etudiants.size());
        System.out.println("  Commandes du jour   : " + commandes.size());
        System.out.println("  Revenus du jour     : " + calculerRevenusJour() + " DT");
        System.out.println("  Livraisons en cours : " + compterLivraisonsEnCours());
        verifierAlertes();
        System.out.println("  ==========================================");
    }

    /**
     * Calcule les revenus totaux du jour (commandes non annulées)
     */
    public double calculerRevenusJour() {
        double total = 0.0;
        for (Commande c : commandes) {
            if (c.getStatut() != Commande.Statut.ANNULEE) {
                total += c.getTotal();
            }
        }
        return total;
    }

    /**
     * Compte les livraisons en cours
     */
    public int compterLivraisonsEnCours() {
        int count = 0;
        for (Livraison l : livraisons) {
            if (l.getStatut() == Livraison.StatutLivraison.EN_COURS) count++;
        }
        return count;
    }

    /**
     * Liste tous les étudiants inscrits
     */
    public void listerEtudiants() {
        System.out.println("  --- Liste des étudiants inscrits ---");
        for (Etudiant e : etudiants) {
            System.out.println("  • " + e.getPrenom() + " " + e.getNom() + " | " + e.getEmail() + " | Solde: " + e.getSolde() + " DT");
        }
    }

    /**
     * Liste toutes les commandes du jour
     */
    public void listerCommandes() {
        System.out.println("  --- Commandes du jour ---");
        for (Commande c : commandes) {
            System.out.println("  • Commande #" + c.getId() + " | " + c.getEtudiant().getPrenom() + " | " + c.getTotal() + " DT | " + c.getStatut());
        }
    }

    /**
     * Vérifie les alertes système
     */
    public void verifierAlertes() {
        boolean alerteTrouvee = false;
        for (Commande c : commandes) {
            if (c.getStatut() == Commande.Statut.EN_ATTENTE) {
                System.out.println("  ⚠️ Alerte : Commande #" + c.getId() + " en attente depuis longtemps !");
                alerteTrouvee = true;
            }
        }
        for (Livraison l : livraisons) {
            if (l.getStatut() == Livraison.StatutLivraison.ECHEC) {
                System.out.println("  ⚠️ Alerte : Livraison #" + l.getId() + " en échec !");
                alerteTrouvee = true;
            }
        }
        if (!alerteTrouvee) System.out.println("  ✅ Aucune alerte.");
    }

    /**
     * Affiche les statistiques globales
     */
    public void afficherStats() {
        long commandesLivrees = commandes.stream()
            .filter(c -> c.getStatut() == Commande.Statut.LIVREE).count();
        long commandesAnnulees = commandes.stream()
            .filter(c -> c.getStatut() == Commande.Statut.ANNULEE).count();

        System.out.println("  --- Statistiques ---");
        System.out.println("  Total commandes   : " + commandes.size());
        System.out.println("  Commandes livrées : " + commandesLivrees);
        System.out.println("  Commandes annulées: " + commandesAnnulees);
        System.out.println("  Revenus totaux    : " + calculerRevenusJour() + " DT");
    }

    @Override
    public String toString() {
        return "Admin{id=" + id + ", nom='" + nom + "', email='" + email + "'}";
    }

    // ===== GETTERS & SETTERS =====
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public List<Etudiant> getEtudiants() { return etudiants; }
    public void setEtudiants(List<Etudiant> etudiants) { this.etudiants = etudiants; }
    public List<Commande> getCommandes() { return commandes; }
    public void setCommandes(List<Commande> commandes) { this.commandes = commandes; }
    public List<Livraison> getLivraisons() { return livraisons; }
    public void setLivraisons(List<Livraison> livraisons) { this.livraisons = livraisons; }
}
