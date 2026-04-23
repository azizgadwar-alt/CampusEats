# :pizza: CampusEats — Système de Commande Cantine Universitaire

> *Projet AGL 2025/2026* — FSEGT, Université Tunis El Manar  
> *Enseignante :* Fatma Karray | Avril 2026

---

## :busts_in_silhouette: Membres de l'Équipe

| Membre   | Nom Complet           | Rôle Scrum             | Fonctionnalité       |
|----------|-----------------------|------------------------|----------------------|
| Membre 1 | Mohamed Aziz Guedwar  | Développeur            | Authentification     |
| Membre 2 | Chameseddine Jbali    | Product Owner + Dev    | Menu & Stocks        |
| Membre 3 | Ghezlene Agerbi       | Développeur            | Commande & Paiement  |
| Membre 4 | Ghofrane Jlassi       | Scrum master +Dev      | Livraison            |
| Membre 5 | Omar chedly Ftouhi    | Développeur            | Admin Dashboard      |

---

## :clipboard: Description

*CampusEats* est une application Java permettant aux étudiants de commander leurs repas à la cantine universitaire en ligne, évitant ainsi les files d'attente.

---

## :dividers: Structure du Projet


CampusEats/
│
├── docs/
│   └── captures/
│       ├── maquettes/
│       ├── kanban/
│       └── reviews/
│
├── diagrammes/
│   ├── DCU_CampusEats.puml
│   ├── DC_CampusEats.puml
│   └── DS_*.puml
│
├── src/
│   └── com/campuseats/models/
│       ├── Main.java
│       └── *.java
│
└── README.md

  

---

## :gear: Compilation et Exécution

### Compilation

bash
javac -encoding UTF-8 -d out src/com/campuseats/models/*.java


### Exécution

bash
java -Dfile.encoding=UTF-8 -cp out com.campuseats.models.Main


---

## :rocket: Fonctionnalités

| Fonctionnalité      | Description                                              | Responsable       |
|---------------------|----------------------------------------------------------|-------------------|
| Authentification    | Inscription, connexion et gestion des sessions étudiants | aziz gadwar       |
| Menu & Stocks       | Affichage du menu du jour et gestion des stocks          | chames jbali      |
| Commande & Paiement | Passage de commande et traitement du paiement en ligne   | ghezlene agrebi   |
| Livraison           | Suivi de livraison et gestion des créneaux               | ghofrane jlassi   |
| Admin Dashboard     | Tableau de bord administrateur pour la gestion globale   | omar chedli ftouhi|

---

## :tools: Technologies Utilisées

- *Langage :* Java
- *Méthodologie :* Scrum (Jira)
- *Encodage :* UTF-8

---

## :pushpin: Prérequis

- Java JDK 11 ou supérieur
- Encodage système UTF-8 recommandé

---

## :pencil: Licence

Projet académique — FSEGT, Université Tunis El Manar © 2025/2026
