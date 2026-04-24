# 🍕 CampusEats — Système de Commande Cantine Universitaire

**Projet AGL 2025/2026 — FSEGT, Université Tunis El Manar**  
**Enseignante : Fatma Karray**  
**Date : Avril 2026**

---

## 👥 Membres de l'Équipe

| Membre | Nom Complet | Rôle Scrum | Fonctionnalité |
|--------|-------------|------------|----------------|
| Membre 1 | Mohamed Aziz Guedwar | Développeur | Authentification |
| Membre 2 | Chameseddine Jbali | Product Owner + Dev | Menu & Stocks |
| Membre 3 | Ghezlene Agerbi | Développeur | Commande & Paiement |
| Membre 4 | Ghofrane Jlassi | Scrum Master + Dev | Livraison |
| Membre 5 | Omar Chedly Ftouhi | Développeur | Admin Dashboard |

---

## 📋 Description

**CampusEats** est une application Java permettant aux étudiants de commander leurs repas à la cantine universitaire en ligne.  
L'objectif principal est d’optimiser le flux des services et de réduire les files d’attente aux heures de pointe.

---

## 🎨 Design & Maquettes

Le design de l’interface utilisateur (**UI/UX**) a été conçu sur **Figma**.

🔗 **Accéder au prototype Figma**  
*(https://www.figma.com/make/JrxsZQtuHM2wVJYKpDu9h6/Create-it?t=WSMVSCxhDhMaEjjn-1&preview-route=%2Fremise)*

---

## 🗂️ Structure du Projet

```plaintext
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


⚙️ Compilation et Exécution
**javac -encoding UTF-8 -d out src/com/campuseats/models/*.java**
Exécution
java -Dfile.encoding=UTF-8 -cp out com.campuseats.models.Main

