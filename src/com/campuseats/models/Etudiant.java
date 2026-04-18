package com.campuseats.models;

/**
 * Classe Etudiant — Fonctionnalité : Inscription et Authentification
 * Responsable : Membre 1 (Product Owner)
 * Branche Git : feature/authentification
 */
public class Etudiant {

    // Champs privés
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;
    private double solde;
    private boolean connecte;

    // Constructeur vide
    public Etudiant() {}

    // Constructeur complet
    public Etudiant(int id, String nom, String prenom, String email, String motDePasse, double solde) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.solde = solde;
        this.connecte = false;
    }

    // ===== MÉTHODES MÉTIER =====

    /**
     * Inscrit un nouvel étudiant dans le système
     */
    public boolean sInscrire(String nom, String prenom, String email, String motDePasse) {
        if (nom == null || nom.isEmpty()) {
            System.out.println("  ❌ Erreur : Le nom est obligatoire.");
            return false;
        }
        if (!email.contains("@")) {
            System.out.println("  ❌ Erreur : Email invalide.");
            return false;
        }
        if (motDePasse.length() < 6) {
            System.out.println("  ❌ Erreur : Mot de passe trop court (min 6 caractères).");
            return false;
        }
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.solde = 0.0;
        System.out.println("  ✅ Compte créé : " + prenom + " " + nom + " (" + email + ")");
        return true;
    }

    /**
     * Connecte l'étudiant si les credentials sont corrects
     */
    public boolean seConnecter(String email, String motDePasse) {
        if (this.email.equals(email) && this.motDePasse.equals(motDePasse)) {
            this.connecte = true;
            System.out.println("  ✅ Connexion réussie ! Bonjour " + this.prenom + " " + this.nom);
            return true;
        }
        System.out.println("  ❌ Email ou mot de passe incorrect.");
        return false;
    }

    /**
     * Déconnecte l'étudiant
     */
    public void seDeconnecter() {
        this.connecte = false;
        System.out.println("  ✅ Déconnexion de " + this.prenom + " " + this.nom);
    }

    /**
     * Recharge le solde de l'étudiant
     */
    public void rechargerSolde(double montant) {
        if (montant <= 0) {
            System.out.println("  ❌ Montant invalide.");
            return;
        }
        this.solde += montant;
        System.out.println("  ✅ Solde rechargé : +" + montant + " DT → Nouveau solde : " + this.solde + " DT");
    }

    /**
     * Débite le solde de l'étudiant
     */
    public boolean debiterSolde(double montant) {
        if (montant > this.solde) {
            System.out.println("  ❌ Solde insuffisant. Solde actuel : " + this.solde + " DT");
            return false;
        }
        this.solde -= montant;
        System.out.println("  ✅ Paiement de " + montant + " DT effectué. Solde restant : " + this.solde + " DT");
        return true;
    }

    /**
     * Affiche le profil de l'étudiant
     */
    public void afficherProfil() {
        System.out.println("  --- Profil Étudiant ---");
        System.out.println("  Nom     : " + prenom + " " + nom);
        System.out.println("  Email   : " + email);
        System.out.println("  Solde   : " + solde + " DT");
        System.out.println("  Statut  : " + (connecte ? "Connecté" : "Déconnecté"));
    }

    @Override
    public String toString() {
        return "Etudiant{id=" + id + ", nom='" + prenom + " " + nom + "', email='" + email + "', solde=" + solde + " DT}";
    }

    // ===== GETTERS & SETTERS =====
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getMotDePasse() { return motDePasse; }
    public void setMotDePasse(String motDePasse) { this.motDePasse = motDePasse; }
    public double getSolde() { return solde; }
    public void setSolde(double solde) { this.solde = solde; }
    public boolean isConnecte() { return connecte; }
    public void setConnecte(boolean connecte) { this.connecte = connecte; }
}
