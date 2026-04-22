# 🍕 CampusEats — Système de Commande Cantine Universitaire

> **Projet AGL 2025/2026** — FSEGT, Université Tunis El Manar  
> **Enseignante :** Fatma Karray | Avril 2026

---

## 👥 Membres de l'Équipe

| Membre   | Nom Complet           | Rôle Scrum             | Fonctionnalité       |
|----------|-----------------------|------------------------|----------------------|
| Membre 1 | Mohamed Aziz Guedwar  | Product Owner + Dev    | Authentification     |
| Membre 2 | Chameseddine Jbali    | Scrum Master + Dev     | Menu & Stocks        |
| Membre 3 | Ghezlene Agerbi       | Développeur            | Commande & Paiement  |
| Membre 4 | Ghofrane Jlassi       | Développeur            | Livraison            |
| Membre 5 | Omar chedly Ftouhi    | Développeur            | Admin Dashboard      |

---

## 📋 Description

**CampusEats** est une application Java permettant aux étudiants de commander leurs repas à la cantine universitaire en ligne, évitant ainsi les files d'attente.

---

## 🗂️ Structure du Projet

```
CampusEats/
├── src/
│   └── com/
│       └── campuseats/
│           ├── models/
│              └── *.java
│          
├── out/
└── README.md
```

---

## ⚙️ Compilation et Exécution

### Compilation

```bash
javac -encoding UTF-8 -d out src/com/campuseats/models/*.java
```

### Exécution

```bash
java -Dfile.encoding=UTF-8 -cp out com.campuseats.models.Main
```

---

## 🚀 Fonctionnalités

| Fonctionnalité      | Description                                              | Responsable       |
|---------------------|----------------------------------------------------------|-------------------|
| Authentification    | Inscription, connexion et gestion des sessions étudiants | aziz gadwar       |
| Menu & Stocks       | Affichage du menu du jour et gestion des stocks          | chames jbali      |
| Commande & Paiement | Passage de commande et traitement du paiement en ligne   | ghezlene agrebi   |
| Livraison           | Suivi de livraison et gestion des créneaux               | ghofrane jlassi   |
| Admin Dashboard     | Tableau de bord administrateur pour la gestion globale   | omar chedli ftouhi|

---

## 🛠️ Technologies Utilisées

- **Langage :** Java
- **Méthodologie :** Scrum (Jira)
- **Encodage :** UTF-8

---

## 📌 Prérequis

- Java JDK 11 ou supérieur
- Encodage système UTF-8 recommandé

---

## 📝 Licence

Projet académique — FSEGT, Université Tunis El Manar © 2025/2026
