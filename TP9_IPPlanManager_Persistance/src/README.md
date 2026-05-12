#  TP9 - Persistance et organisation professionnelle

## Objectif

Ajouter la lecture et l'écriture de fichiers afin de sauvegarder les besoins, les plans, les VLANs, les recommandations et les rapports.

---

## Notions étudiées

Persistance, fichiers CSV, lecture de fichier, écriture de fichier, repository, service, packages, architecture professionnelle.

---

##  Fichiers utilisés

###  Fichiers d’entrée

* `besoins.csv` : liste des besoins réseau à traiter

###  Fichiers générés

* `exports/plan.txt` : plan VLSM généré
* `exports/recommandations.txt` : recommandations système (si activé)
* `exports/rapport.txt` : rapport global du traitement (si implémenté)

---

##  Scénarios testés

* Génération d’un plan VLSM à partir de plusieurs besoins réseau
* Association automatique des VLANs aux réseaux
* Détection de problèmes de sécurité WiFi
* Application des règles de recommandation
* Sauvegarde du plan généré dans un fichier texte
* Lecture des besoins depuis un fichier CSV

---

##  Difficultés rencontrées

* Gestion des erreurs de compilation dues aux différences entre anciennes et nouvelles versions des classes
* Problèmes de cohérence entre `VLAN` et `Vlan`
* Erreurs liées aux méthodes manquantes dans `ResultatVLSM`
* Problèmes d’encodage des caractères (accents dans la console)
* Mauvaise synchronisation entre les packages `model`, `service` et `repository`

---

##  Travail supplémentaire demandé

Méthode à ajouter dans `BesoinRepository` :

```java id="besoinrepo1"
public void sauvegarderBesoins(ArrayList<BesoinReseau> besoins, String cheminFichier) throws IOException
```

### Rôle :

Cette méthode permet d’enregistrer les besoins réseau dans un fichier CSV afin de permettre la réutilisation et la persistance des données utilisateur.

---

##  Questions de compréhension

### 1. Qu’est-ce que la persistance des données ?

La persistance des données est la capacité d’une application à sauvegarder des informations sur un support (fichier, base de données) afin de les réutiliser plus tard même après l’arrêt du programme.

---

### 2. Pourquoi une application professionnelle doit-elle sauvegarder ses résultats ?

Pour éviter la perte de données, permettre la continuité du service et faciliter l’analyse ou la réutilisation des résultats.

---

### 3. Quelle est la différence entre un fichier CSV et un rapport texte ?

* CSV : format structuré, utilisé pour les données (tableaux, import/export)
* Texte : format lisible humain, utilisé pour les rapports et explications

---

### 4. Pourquoi a-t-on créé un package repository ?

Pour gérer uniquement la lecture et l’écriture des données (persistance).

---

### 5. Pourquoi a-t-on créé un package service ?

Pour gérer la logique métier (traitement, règles, algorithmes).

---

### 6. Pourquoi ne faut-il pas écrire tout le code dans la classe Main ?

Parce que cela rend le code difficile à maintenir, à lire et à corriger.

---

### 7. Pourquoi le fichier besoins.csv rend-il l’application plus flexible ?

Parce qu’on peut modifier les besoins sans changer le code source.

---

### 8. Pourquoi la séparation en packages améliore-t-elle la maintenabilité du projet ?

Elle permet une meilleure organisation, facilite les corrections et rend le projet évolutif.

---


