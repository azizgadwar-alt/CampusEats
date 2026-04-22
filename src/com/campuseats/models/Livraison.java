// Classe Livraison — ghofrane jlassi — Livraison
package com.campuseats.models;

/**
 * Classe Livraison — Fonctionnalité : Confirmation de remise du repas
 * Responsable : Membre 4 (Livreur)
 * Branche Git : feature/livraison
 */
public class Livraison {

    // Enumération des statuts de livraison
    public enum StatutLivraison {
        EN_ATTENTE, EN_COURS, LIVREE, ECHEC
    }

    // Champs privés
    private int id;
    private Commande commande;
    private String nomLivreur;
    private StatutLivraison statut;
    private String heureLivraison;
    private String pointRetrait;

    // Constructeur vide
    public Livraison() {
        this.statut = StatutLivraison.EN_ATTENTE;
    }

    // Constructeur complet
    public Livraison(int id, Commande commande, String nomLivreur, String pointRetrait) {
        this.id = id;
        this.commande = commande;
        this.nomLivreur = nomLivreur;
        this.pointRetrait = pointRetrait;
        this.statut = StatutLivraison.EN_ATTENTE;
    }

    // ===== MÉTHODES MÉTIER =====

    /**
     * Démarre la livraison (livreur prend en charge la commande)
     */
    public boolean demarrerLivraison() {
        if (commande.getStatut() != Commande.Statut.PRETE && 
            commande.getStatut() != Commande.Statut.EN_PREPARATION) {
            System.out.println("  ❌ La commande n'est pas prête pour la livraison.");
            return false;
        }
        this.statut = StatutLivraison.EN_COURS;
        System.out.println("  🚀 Livraison #" + id + " démarrée par " + nomLivreur);
        System.out.println("  📍 Point de retrait : " + pointRetrait);
        return true;
    }

    /**
     * Confirme la remise du repas à l'étudiant
     */
    public boolean confirmerLivraison(String heure) {
        if (statut == StatutLivraison.LIVREE) {
            System.out.println("  ❌ Livraison déjà confirmée.");
            return false;
        }
        this.heureLivraison = heure;
        this.statut = StatutLivraison.LIVREE;
        commande.setStatut(Commande.Statut.LIVREE);
        System.out.println("  ✅ Remise confirmée à " + heure + " par " + nomLivreur);
        System.out.println("  ✅ Commande #" + commande.getId() + " marquée comme LIVRÉE");
        return true;
    }

    /**
     * Signale un échec de livraison
     */
    public void signalerEchec(String raison) {
        this.statut = StatutLivraison.ECHEC;
        System.out.println("  ❌ Échec de livraison #" + id + " : " + raison);
    }

    /**
     * Affiche le statut actuel de la livraison
     */
    public void afficherStatut() {
        System.out.println("  --- Livraison #" + id + " ---");
        System.out.println("  Livreur       : " + nomLivreur);
        System.out.println("  Commande #    : " + commande.getId());
        System.out.println("  Étudiant      : " + commande.getEtudiant().getPrenom() + " " + commande.getEtudiant().getNom());
        System.out.println("  Point retrait : " + pointRetrait);
        System.out.println("  Statut        : " + statut);
        if (heureLivraison != null) {
            System.out.println("  Livré à       : " + heureLivraison);
        }
    }

    /**
     * Met à jour le statut de la livraison
     */
    public void mettreAJourStatut(StatutLivraison nouveauStatut) {
        this.statut = nouveauStatut;
        System.out.println("  🔄 Statut livraison #" + id + " → " + nouveauStatut);
    }

    @Override
    public String toString() {
        return "Livraison{id=" + id + ", livreur='" + nomLivreur + "', statut=" + statut + "}";
    }

    // ===== GETTERS & SETTERS =====
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Commande getCommande() { return commande; }
    public void setCommande(Commande commande) { this.commande = commande; }
    public String getNomLivreur() { return nomLivreur; }
    public void setNomLivreur(String nomLivreur) { this.nomLivreur = nomLivreur; }
    public StatutLivraison getStatut() { return statut; }
    public void setStatut(StatutLivraison statut) { this.statut = statut; }
    public String getHeureLivraison() { return heureLivraison; }
    public void setHeureLivraison(String heureLivraison) { this.heureLivraison = heureLivraison; }
    public String getPointRetrait() { return pointRetrait; }
    public void setPointRetrait(String pointRetrait) { this.pointRetrait = pointRetrait; }
}
