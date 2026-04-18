package com.campuseats.models;

import java.util.ArrayList;
import java.util.List;

/**
 * POINT D'ENTRÉE — CampusEats
 * Contient : Sprint 1 (V1 — démo basique) + Sprint 2 (V2 — scénarios complets)
 *
 * Compilation :
 *   javac -encoding UTF-8 -d out src/com/campuseats/models/*.java
 * Exécution :
 *   java -cp out com.campuseats.models.Main
 */
public class Main {

    public static void main(String[] args) {

        // ============================================================
        //  SPRINT 1 — Main V1 : Démonstration du squelette de base
        // ============================================================
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║     CampusEats — Sprint 1 (V1)          ║");
        System.out.println("╚══════════════════════════════════════════╝");
        System.out.println();

        // --- Membre 1 : Etudiant (Inscription & Connexion) ---
        System.out.println("--- Authentification (Membre 1) ---");
        Etudiant amine = new Etudiant(1, "Belhaj", "Amine", "amine@univ.tn", "amine123", 30.0);
        amine.afficherProfil();
        amine.seConnecter("amine@univ.tn", "amine123");
        System.out.println();

        // --- Membre 2 : Menu du jour (Cuisinier) ---
        System.out.println("--- Menu du Jour (Membre 2) ---");
        Menu menu = new Menu(1, "17/04/2026", "Chef Mounir");
        Plat couscous = new Plat(1, "Couscous", 3.5, 20, "Plat chaud");
        Plat salade   = new Plat(2, "Salade Mechouia", 1.5, 15, "Entrée");
        Plat jus      = new Plat(3, "Jus d'Orange", 2.0, 30, "Boisson");
        menu.ajouterPlat(couscous);
        menu.ajouterPlat(salade);
        menu.ajouterPlat(jus);
        menu.afficherMenu();
        System.out.println();

        // --- Membre 3 : Commande et Paiement ---
        System.out.println("--- Commande & Paiement (Membre 3) ---");
        Commande cmd1 = new Commande(101, amine, "12:30");
        cmd1.ajouterPlat(couscous);
        cmd1.ajouterPlat(jus);
        System.out.println("  Total estimé : " + cmd1.calculerTotal() + " DT");
        System.out.println();

        // --- Membre 4 : Livraison ---
        System.out.println("--- Livraison (Membre 4) ---");
        Livraison liv1 = new Livraison(1, cmd1, "Sami Ben Ali", "Hall A - Cantine");
        liv1.afficherStatut();
        System.out.println();

        // --- Membre 5 : Admin (tableau de bord simplifié) ---
        System.out.println("--- Admin — Tableau de bord (Membre 5) ---");
        System.out.println("  Étudiants inscrits : 1");
        System.out.println("  Plats au menu      : 3");
        System.out.println("  Commandes en cours : 1");
        System.out.println();

        // ============================================================
        //  SPRINT 2 — Main V2 : Scénarios complets bout en bout
        // ============================================================
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║     CampusEats — Sprint 2 (V2)          ║");
        System.out.println("╚══════════════════════════════════════════╝");
        System.out.println();

        // Création de la liste des étudiants, commandes, livraisons pour Admin
        List<Etudiant> tousLesEtudiants = new ArrayList<>();
        List<Commande> toutesLesCommandes = new ArrayList<>();
        List<Livraison> toutesLesLivraisons = new ArrayList<>();

        // Étudiants
        Etudiant fatma   = new Etudiant(2, "Mansour", "Fatma", "fatma@univ.tn", "fatma456", 50.0);
        Etudiant youssef = new Etudiant(3, "Trabelsi", "Youssef", "youssef@univ.tn", "youssef789", 20.0);
        tousLesEtudiants.add(amine);
        tousLesEtudiants.add(fatma);
        tousLesEtudiants.add(youssef);

        // Réinitialisation du menu Sprint 2 (nouveau stock)
        Menu menu2 = new Menu(2, "17/04/2026", "Chef Mounir");
        Plat plat_couscous = new Plat(1, "Couscous", 3.5, 4, "Plat chaud");  // stock faible intentionnel
        Plat plat_brick    = new Plat(2, "Brick à l'œuf", 2.0, 10, "Entrée");
        Plat plat_makroud  = new Plat(3, "Makroud", 1.0, 12, "Dessert");
        Plat plat_jus      = new Plat(4, "Jus d'Orange", 2.0, 0, "Boisson");  // épuisé
        menu2.ajouterPlat(plat_couscous);
        menu2.ajouterPlat(plat_brick);
        menu2.ajouterPlat(plat_makroud);
        menu2.ajouterPlat(plat_jus);

        // ─────────────────────────────────────────────
        System.out.println("📌 Scénario 1 : Amine commande son repas");
        System.out.println("─────────────────────────────────────────");
        System.out.println("  1. Connexion d'Amine...");
        amine.seConnecter("amine@univ.tn", "amine123");
        System.out.println("  2. Consultation du menu...");
        menu2.afficherMenu();
        System.out.println("  3. Commande : Couscous + Brick à l'œuf");
        Commande cmdAmine = new Commande(201, amine, "12:15");
        cmdAmine.ajouterPlat(plat_couscous);
        cmdAmine.ajouterPlat(plat_brick);
        System.out.println("  4. Passage de la commande et paiement...");
        cmdAmine.passerCommande();
        toutesLesCommandes.add(cmdAmine);
        System.out.println();

        // ─────────────────────────────────────────────
        System.out.println("📌 Scénario 2 : Fatma commande mais solde insuffisant");
        System.out.println("────────────────────────────────────────────────────");
        System.out.println("  1. Connexion de Fatma...");
        fatma.seConnecter("fatma@univ.tn", "fatma456");
        Commande cmdFatma = new Commande(202, fatma, "12:20");
        cmdFatma.ajouterPlat(plat_makroud);
        System.out.println("  2. Paiement en cours...");
        cmdFatma.passerCommande();
        toutesLesCommandes.add(cmdFatma);
        System.out.println();

        // ─────────────────────────────────────────────
        System.out.println("📌 Scénario 3 : Livraison de la commande d'Amine");
        System.out.println("─────────────────────────────────────────────────");
        Livraison livAmine = new Livraison(101, cmdAmine, "Sami Ben Ali", "Hall A — Guichet 2");
        livAmine.demarrerLivraison();
        cmdAmine.setStatut(Commande.Statut.PRETE);
        livAmine.confirmerLivraison("12:45");
        toutesLesLivraisons.add(livAmine);

        Livraison livFatma = new Livraison(102, cmdFatma, "Sami Ben Ali", "Hall A — Guichet 2");
        livFatma.demarrerLivraison();
        cmdFatma.setStatut(Commande.Statut.PRETE);
        livFatma.confirmerLivraison("12:50");
        toutesLesLivraisons.add(livFatma);
        System.out.println();

        // ─────────────────────────────────────────────
        System.out.println("📌 Scénario 4 : Vérification des alertes stock");
        System.out.println("───────────────────────────────────────────────");
        menu2.verifierAlertesStock();
        System.out.println();

        // ─────────────────────────────────────────────
        System.out.println("📌 Scénario 5 : Tableau de bord Admin");
        System.out.println("──────────────────────────────────────");
        Admin admin = new Admin(1, "Bilel Gharbi", "admin@campuseats.tn",
                                tousLesEtudiants, toutesLesCommandes, toutesLesLivraisons);
        admin.afficherTableauDeBord();
        System.out.println();
        admin.listerEtudiants();
        System.out.println();
        admin.listerCommandes();
        System.out.println();
        admin.afficherStats();

        System.out.println();
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║  CampusEats — Démonstration terminée ✅  ║");
        System.out.println("╚══════════════════════════════════════════╝");
    }
}
