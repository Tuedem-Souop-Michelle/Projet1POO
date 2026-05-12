# TP8 : Moteur de recommandations intelligentes dans IPPlan-Manager

## 1. Objectif du TP

L’objectif de ce TP est d’ajouter une couche d’intelligence au système IPPlan-Manager afin d’analyser automatiquement un plan d’adressage réseau et produire des recommandations liées à la sécurité, à l’optimisation et aux bonnes pratiques réseau.

---

## 2. Notions étudiées

* Interfaces Java
* Polymorphisme
* Implémentations multiples
* Moteur de règles
* Analyse automatique d’un plan réseau

---

## 3. Classes utilisées

* `Recommandation`
* `RegleRecommandation`
* `RegleSecuriteWifi`
* `RegleOptimisationBroadcast`
* `MoteurRecommandations`
* `Main`

---

## 4. Fonctionnement général

Le système analyse automatiquement une liste de sous-réseaux et applique plusieurs règles :

* Vérification de la sécurité du WiFi
* Détection des réseaux trop larges
* Génération de recommandations automatiques

Chaque règle est indépendante et implémente l’interface `RegleRecommandation`.

---

## 5. Tests réalisés

* Test d’un VLAN WiFi utilisant le VLAN par défaut
* Test d’un réseau très large (/16)
* Vérification du fonctionnement du moteur avec plusieurs règles
* Vérification de l’affichage des niveaux d’alerte

---

## 6. Difficultés rencontrées

* Compréhension des interfaces Java
* Utilisation du polymorphisme
* Gestion des listes de recommandations
* Compréhension du rôle d’un moteur de règles

---

## 7. Réponses aux questions de compréhension

### 1. Quel est le rôle d’un moteur de recommandations dans un outil IPAM ?

Il permet d’analyser automatiquement un plan réseau afin de fournir des conseils liés à la sécurité, à l’organisation et à l’optimisation du réseau.

---

### 2. Pourquoi utilise-t-on une interface pour les règles de recommandation ?

L’interface permet d’ajouter facilement de nouvelles règles sans modifier le moteur principal, ce qui rend le système évolutif.

---

### 3. Quelle est la différence entre une classe concrète et une interface ?

Une classe concrète contient le code complet des méthodes tandis qu’une interface définit uniquement un contrat que les classes doivent respecter.

---

### 4. Pourquoi la méthode analyser() peut-elle retourner null ?

Parce qu’aucune recommandation peut être trouvée pour un plan donné. Dans ce TP, on préfère retourner une liste vide.

---

### 5. Pourquoi le moteur de recommandations illustre-t-il le polymorphisme ?

Parce qu’il manipule plusieurs types de règles différentes à travers une même interface `RegleRecommandation`.

---

### 6. Pourquoi est-il préférable de créer une classe par règle au lieu de mettre tous les tests dans Main ?

Cela rend le code plus propre, plus lisible, plus facile à maintenir et permet de tester chaque règle séparément.

---

### 7. Pourquoi un VLAN WiFi invité doit-il être isolé des réseaux internes ?

Pour empêcher les utilisateurs externes d’accéder aux ressources sensibles de l’entreprise.

---

### 8. Pourquoi les VLANs de grande taille doivent-ils être surveillés ?

Parce qu’ils génèrent beaucoup de trafic broadcast pouvant ralentir le réseau et saturer les équipements.

---

## 8. Conclusion

Ce TP a permis de mettre en place un moteur intelligent capable de produire automatiquement des recommandations réseau grâce aux interfaces, au polymorphisme et aux règles d’analyse.

