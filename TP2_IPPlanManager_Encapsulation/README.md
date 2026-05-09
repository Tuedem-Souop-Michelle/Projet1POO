# TP1 - IPPlan-Manager

## Objectif du TP

Ce TP permet de découvrir les premières classes Java du projet IPPlan-Manager.
L’objectif est de représenter des éléments réseau sous forme d’objets Java en utilisant la Programmation Orientée Objet.

---

## Classes créées

- AdresseIP
- ReseauIP
- InterfaceReseau
- Equipement
- Main

---

## Travail réalisé

Les objets réseau suivants ont été créés et testés dans NetBeans :

### Réseaux
- Réseau principal : 192.168.1.0/24
- Réseau WiFi étudiants : 192.168.2.0/24

### Équipements
- Routeur R1_EDGE
- Serveur SRV_DNS
- Poste client PC_ADMIN
- Switch SW_CORE
- Point d’accès WiFi AP_WIFI
- Deuxième poste client PC_SALLE2
- Équipement TEST_INTERFACE (interface sans IP)

### Interfaces testées
- Interface active (routeur, serveur, switch, WiFi)
- Interface inactive (PC client)
- Interface sans adresse IP

### Tests effectués
- Exécution du programme via la classe Main
- Vérification de l’affichage des réseaux
- Vérification de l’affichage des équipements
- Vérification des états des interfaces (active / inactive)
- Vérification des interfaces sans adresse IP

Le programme s’exécute correctement sans erreur et affiche toutes les informations attendues dans la console.

## Réponses aux questions

### 1. Pourquoi une adresse IP a-t-elle été représentée par une classe ?

Parce qu’une adresse IP possède des caractéristiques et des traitements spécifiques.
L’utilisation d’une classe permet de mieux organiser le programme .

### 2. Quelle est la différence entre une classe et un objet ?

Une classe est un modèle.
Un objet est une instance créée à partir de cette classe.

### 3. Quel est le rôle du constructeur dans une classe Java ?

Le constructeur permet d’initialiser les attributs d’un objet lors de sa création.

### 4. Pourquoi la classe InterfaceReseau contient-elle un objet de type AdresseIP ?

Parce qu’une interface réseau possède une adresse IP.

### 5. Pourquoi la classe Equipement contient-elle un objet de type InterfaceReseau ?

Parce qu’un équipement réseau utilise une interface réseau pour communiquer.

### 6. Quelle est la limite actuelle de la classe Equipement dans ce TP ?

Un équipement ne peut contenir qu’une seule interface réseau.

### 7. Pourquoi cette première version n’est-elle pas encore suffisante pour produire automatiquement un plan d’adressage IP ?

Parce qu’il n’y a pas encore de calcul automatique des sous-réseaux ni de gestion complète des adresses IP.
