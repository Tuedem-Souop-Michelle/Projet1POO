#  TP10 - Application finale IPPlan-Manager

## Objectif

Assembler toutes les fonctionnalités développées dans les TPs précédents afin de produire une application console complète de planification d’adressage IP.

L’application permet de :

* saisir les besoins réseau
* générer un plan VLSM
* créer les VLANs
* valider le plan
* produire des recommandations
* sauvegarder les résultats
* générer un rapport technique

---

##  Fonctionnalités réalisées

* Saisie des besoins utilisateur
* Génération automatique du plan VLSM
* Calcul des sous-réseaux, masques et capacités
* Création automatique des VLANs
* Validation du plan d’adressage
* Génération de recommandations
* Sauvegarde des résultats en CSV
* Génération de fichiers dans le dossier `exports`

---

##  Organisation du projet

###  model

Contient les classes métier :

* BesoinReseau
* ResultatVLSM
* VLAN
* Recommandation

### service

Contient les traitements :

* CalculateurReseau
* MoteurVLSM
* GestionnaireVLAN
* ValidateurPlanAdressage
* MoteurRecommandation
* RecommandationWifiInvite
* RecommandationServeurs
* RecommandationGrandVLAN

### repository

* BesoinRepository
* FichierPlanRepository

###  exception

* AdresseIPInvalideException
* ConflitVLANException
* ChevauchementReseauException

###  console

* ConsoleService

###  main

* Main (lancement de l’application)

---

##  Scénarios testés

###  Scénario 1 : Campus IRT

* ETUDIANTS : 500 hôtes
* WIFI_INVITES : 200 hôtes
* ENSEIGNANTS : 120 hôtes
* LABORATOIRES : 60 hôtes
* SERVEURS : 30 hôtes

###  Scénario 2 : PME

* ADMINISTRATION : 50 hôtes
* COMPTABILITE : 20 hôtes
* WIFI_INVITES : 80 hôtes
* SERVEURS : 15 hôtes
* VOIP : 40 hôtes

### Scénario 3 : Entreprise multi-services

* TECHNIQUE : 120 hôtes
* DIRECTION : 25 hôtes
* CAMERAS : 60 hôtes
* SUPPORT : 35 hôtes
* INVITES : 100 hôtes

---

##  Fichiers générés

Tous les fichiers sont générés dans le dossier :

```
exports/
```

Exemples :

* plan.csv
* vlans.csv
* recommandations.txt
* rapport.txt

---

##  Difficultés rencontrées

* Gestion des dépendances entre classes
* Erreurs de compilation liées aux méthodes manquantes
* Organisation des packages
* Synchronisation entre moteur VLSM et résultats
* Gestion des exports CSV

---

##Réponses aux questions

1. TP10 est une application complète car il assemble toutes les fonctionnalités des TPs précédents.
2. ApplicationIPPlanManager orchestre toute l’application.
3. Main reste courte pour respecter la séparation des responsabilités.
4. La séparation des packages permet une architecture propre et maintenable.
5. ConsoleService centralise la saisie utilisateur.
6. La validation évite les erreurs de plan d’adressage.
7. Les recommandations analysent le plan généré.
8. La sauvegarde permet la réutilisation des résultats.
9. Le rapport est important pour la documentation professionnelle.
10. On peut ajouter une interface graphique ou une base de données.

---

## ? Conclusion 

Ce projet permet de comprendre comment la programmation orientée objet peut être utilisée pour construire une application réseau complète, structurée et professionnelle en Java.




