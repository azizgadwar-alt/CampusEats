// Classe Menu — Membre 2 — Gestion du menu et stocks
package com.campuseats.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Menu — Fonctionnalité : Gestion du menu du jour
 * Responsable : Membre 2 (Cuisinier)
 * Branche Git : feature/menu-gestion
 */
public class Menu {

    // Champs privés
    private int id;
    private String date;
    private List<Plat> plats;
    private String cuisinier;

    // Constructeur vide
    public Menu() {
        this.plats = new ArrayList<>();
    }

    // Constructeur complet
    public Menu(int id, String date, String cuisinier) {
        this.id = id;
        this.date = date;
        this.cuisinier = cuisinier;
        this.plats = new ArrayList<>();
    }

    // ===== MÉTHODES MÉTIER =====

    /**
     * Ajoute un plat au menu du jour
     */
    public void ajouterPlat(Plat plat) {
        if (plat == null) {
            System.out.println("  ❌ Plat invalide.");
            return;
        }
        plats.add(plat);
        System.out.println("  ✅ Plat ajouté : " + plat.getNom() + " — " + plat.getPrix() + " DT");
    }

    /**
     * Supprime un plat du menu par son ID
     */
    public boolean supprimerPlat(int platId) {
        for (Plat p : plats) {
            if (p.getId() == platId) {
                plats.remove(p);
                System.out.println("  ✅ Plat supprimé : " + p.getNom());
                return true;
            }
        }
        System.out.println("  ❌ Plat introuvable (ID: " + platId + ")");
        return false;
    }

    /**
     * Affiche tous les plats du menu du jour
     */
    public void afficherMenu() {
        System.out.println("  === Menu du " + date + " (Cuisinier: " + cuisinier + ") ===");
        if (plats.isEmpty()) {
            System.out.println("  Aucun plat disponible aujourd'hui.");
            return;
        }
        for (Plat p : plats) {
            p.afficherDetails();
        }
    }

    /**
     * Recherche un plat par son ID
     */
    public Plat rechercherPlat(int platId) {
        for (Plat p : plats) {
            if (p.getId() == platId) {
                return p;
            }
        }
        System.out.println("  ❌ Plat introuvable (ID: " + platId + ")");
        return null;
    }

    /**
     * Retourne uniquement les plats disponibles (stock > 0)
     */
    public List<Plat> getPlatsDisponibles() {
        List<Plat> disponibles = new ArrayList<>();
        for (Plat p : plats) {
            if (p.isDisponible()) disponibles.add(p);
        }
        return disponibles;
    }

    /**
     * Vérifie si le stock d'un plat est faible (< 5)
     */
    public void verifierAlertesStock() {
        System.out.println("  --- Alertes Stock ---");
        boolean alerteTrouvee = false;
        for (Plat p : plats) {
            if (p.getStock() < 5 && p.getStock() > 0) {
                System.out.println("  ⚠️ Alerte : Stock faible pour " + p.getNom() + " (" + p.getStock() + " restants)");
                alerteTrouvee = true;
            } else if (p.getStock() == 0) {
                System.out.println("  ❌ Épuisé : " + p.getNom());
                alerteTrouvee = true;
            }
        }
        if (!alerteTrouvee) System.out.println("  ✅ Tous les stocks sont suffisants.");
    }

    @Override
    public String toString() {
        return "Menu{date='" + date + "', plats=" + plats.size() + " plats, cuisinier='" + cuisinier + "'}";
    }

    // ===== GETTERS & SETTERS =====
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public List<Plat> getPlats() { return plats; }
    public void setPlats(List<Plat> plats) { this.plats = plats; }
    public String getCuisinier() { return cuisinier; }
    public void setCuisinier(String cuisinier) { this.cuisinier = cuisinier; }
}
