##  1. Objectif du TP

L’objectif de ce TP est d’améliorer la fiabilité du système IPPlan-Manager en ajoutant un mécanisme de validation capable de détecter automatiquement :

* les erreurs de format d’adresses IP
* les conflits d’IDs VLAN
* les incohérences dans un plan d’adressage réseau

---

## 2. Notions utilisées

* Exceptions personnalisées en Java
* Gestion des erreurs avec `try/catch`
* Levée d’exception avec `throw` et `throws`
* Validation de données réseau
* Détection de conflits dans des structures de données

---

## 3. Classes du TP7

### ✔ ConflitReseauException

Permet de gérer les erreurs spécifiques au réseau.
java
package ipplanmanager;

public class ConflitReseauException extends Exception {
    public ConflitReseauException(String message) {
        super("ERREUR RÉSEAU : " + message);
    }
}
```

---

###  ValidateurPlan

Classe de validation des données réseau.

java
package ipplanmanager;

import java.util.List;

public class ValidateurPlan {

    public static void verifierConflitVlan(List<VLAN> vlans) throws ConflitReseauException {
        for (int i = 0; i < vlans.size(); i++) {
            for (int j = i + 1; j < vlans.size(); j++) {
                if (vlans.get(i).getId() == vlans.get(j).getId()) {
                    throw new ConflitReseauException("Conflit d'ID VLAN détecté : " + vlans.get(i).getId());
                }
            }
        }
    }

    public static void validerFormatIP(String ip) throws ConflitReseauException {
        if (ip == null || ip.split("\\.").length != 4) {
            throw new ConflitReseauException("IP invalide : " + ip);
        }
    }

    public static void detecterChevauchement(List<ResultatVLSM> resultats) throws ConflitReseauException {
        if (resultats.isEmpty()) {
            throw new ConflitReseauException("Le plan d'adressage est vide.");
        }
    }
}
```

---

### Main (test du TP7)

java
package ipplanmanager;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("===== TP7 : VALIDATION ET CONFLITS =====");

        try {
            ValidateurPlan.validerFormatIP("192.168.1");
        } catch (ConflitReseauException e) {
            System.err.println(e.getMessage());
        }

        List<VLAN> vlans = new ArrayList<>();
        vlans.add(new VLAN(10, "Administration"));
        vlans.add(new VLAN(10, "Comptabilité"));

        try {
            ValidateurPlan.verifierConflitVlan(vlans);
        } catch (ConflitReseauException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("Fin TP7");
    }
}
```

---

## 4. Tests réalisés

* Test de validation d’une adresse IP incorrecte
* Test de détection de conflit d’ID VLAN
* Utilisation de `try/catch` pour gérer les erreurs
* Vérification du bon fonctionnement des exceptions personnalisées

---

## 5. Difficultés rencontrées

* Compréhension des exceptions personnalisées
* Différence entre `throw` et `throws`
* Gestion des boucles imbriquées pour détecter les doublons
* Validation correcte du format d’adresse IP

---

## 6. Réponses aux questions de compréhension

### 1. Pourquoi est-il important de détecter les conflits dans un plan d’adressage ?

Pour éviter les erreurs réseau (doublons IP ou VLAN) qui peuvent provoquer des pannes ou des conflits de communication.

---

### 2. Qu’est-ce qu’une exception personnalisée ?

C’est une classe créée par le développeur qui hérite de `Exception` pour gérer des erreurs spécifiques au projet.

---

### 3. Différence entre throw et throws ?

* `throw` : lance une exception
* `throws` : déclare qu’une méthode peut lancer une exception

---

### 4. À quoi sert try/catch ?

À gérer les erreurs sans arrêter le programme brutalement.

---

### 5. Comment détecter un doublon VLAN ?

En comparant chaque VLAN avec les autres via une double boucle.

---

### 6. Pourquoi valider une IP avant traitement ?

Pour éviter des erreurs lors des calculs ou du découpage réseau.

---

### 7. Que fait getMessage() ?

Affiche uniquement le message d’erreur sans le détail technique.

---

### 8. Que se passe-t-il si une exception n’est pas capturée ?

Le programme s’arrête immédiatement (crash).

---

## 7. Conclusion

Ce TP permet de rendre le système IPPlan-Manager plus robuste en ajoutant une couche de validation permettant de détecter les erreurs critiques avant qu’elles n’impactent le réseau.


