

# TP6 : Gestion des VLANs et segmentation logique dans IPPlan-Manager

## 1. Objectif du TP

L’objectif de ce TP est d’intégrer la notion de VLAN (Virtual Local Area Network) dans le projet IPPlan-Manager afin de segmenter logiquement le réseau. Cela permet d’isoler les services, améliorer la sécurité et organiser les infrastructures réseau par département.

---

## 2. Notions étudiées

* VLAN (Virtual Local Area Network)
* Segmentation logique du réseau
* Association VLAN ↔ sous-réseau
* Gestion de collections (List)
* Recherche d’objets dans une liste

---

## 3. Architecture du projet

Le TP est composé des classes suivantes :

* VLAN
* GestionnaireVLAN
* ResultatVLSM (modifiée)
* MoteurVLSM (réutilisé du TP5)
* Main (test du système)

---

## 4. Codes des classes

### Classe VLAN

```java
package ipplanmanager;

public class VLAN {
    private int id;
    private String nom;

    public VLAN(int id, String nom) {
        setId(id);
        setNom(nom);
    }

    public int getId() { return id; }

    public void setId(int id) {
        if (id < 1 || id > 4094) {
            System.out.println("ID VLAN invalide, valeur par défaut attribuée.");
            this.id = 10;
        } else {
            this.id = id;
        }
    }

    public String getNom() { return nom; }

    public void setNom(String nom) {
        this.nom = (nom == null || nom.isEmpty()) ? "VLAN_SANS_NOM" : nom;
    }

    public void afficher() {
        System.out.println("VLAN ID : " + id + " | Nom : " + nom);
    }
}
```

---

### Classe GestionnaireVLAN

```java
package ipplanmanager;

import java.util.ArrayList;
import java.util.List;

public class GestionnaireVLAN {
    private List<VLAN> listeVlans = new ArrayList<>();

    public void ajouterVLAN(int id, String nom) {
        listeVlans.add(new VLAN(id, nom));
    }

    public VLAN rechercherVlanParNom(String nom) {
        for (VLAN v : listeVlans) {
            if (v.getNom().equalsIgnoreCase(nom)) {
                return v;
            }
        }
        return null;
    }
}
```

---

### Classe ResultatVLSM (modifiée)

```java
package ipplanmanager;

public class ResultatVLSM {
    private String nom;
    private String adresseReseau;
    private int masqueCidr;
    private int hotesReels;
    private VLAN vlanAssocie;

    public ResultatVLSM(String nom, String adresseReseau, int masqueCidr, int hotesReels, VLAN vlan) {
        this.nom = nom;
        this.adresseReseau = adresseReseau;
        this.masqueCidr = masqueCidr;
        this.hotesReels = hotesReels;
        this.vlanAssocie = vlan;
    }

    public void afficher() {
        System.out.println("--------------------------------");
        System.out.println("Sous-réseau : " + nom);
        System.out.println("Adresse : " + adresseReseau + "/" + masqueCidr);
        System.out.println("Hôtes : " + hotesReels);

        if (vlanAssocie != null) {
            vlanAssocie.afficher();
        }
    }
}
```

---

### Classe Main (TP6)

```java
package ipplanmanager;

public class Main {
    public static void main(String[] args) {

        System.out.println("===== TP6 VLAN + VLSM =====");

        GestionnaireVLAN gestionnaire = new GestionnaireVLAN();
        gestionnaire.ajouterVLAN(10, "Administration");
        gestionnaire.ajouterVLAN(20, "Technique");

        VLAN vlanAdmin = gestionnaire.rechercherVlanParNom("Administration");
        VLAN vlanTech = gestionnaire.rechercherVlanParNom("Technique");

        ResultatVLSM r1 = new ResultatVLSM("Admin", "192.168.1.0", 26, 62, vlanAdmin);
        ResultatVLSM r2 = new ResultatVLSM("Tech", "192.168.1.64", 25, 126, vlanTech);

        r1.afficher();
        r2.afficher();
    }
}
```

---

## 5. Tests réalisés

* Création et gestion des VLANs
* Association VLAN ↔ sous-réseau
* Affichage structuré des résultats VLSM
* Validation des IDs VLAN

---

## 6. Difficultés rencontrées

* Gestion des objets VLAN dans les résultats VLSM
* Organisation des classes entre logique et données
* Recherche dans une liste de VLANs

---

---

## 6. Réponses aux questions de compréhension

1. Qu'est-ce qu'un VLAN et quelle est sa fonction principale ?**
   Un VLAN est un réseau local virtuel qui permet de segmenter logiquement un réseau physique en plusieurs réseaux indépendants afin d’isoler les flux.

2. Pourquoi segmenter un réseau en VLANs ?**
   Pour améliorer la sécurité, réduire les domaines de broadcast et organiser le réseau par services ou départements.

3. Quelle est la plage valide pour un ID de VLAN ?**
   La plage standard est comprise entre **1 et 4094**.

4. Pourquoi a-t-on ajouté un objet VLAN dans ResultatVLSM ?**
   Pour lier le calcul d’adressage IP (couche 3) à la segmentation logique (couche 2) dans un même résultat.

5. Quel est l’intérêt de la classe GestionnaireVLAN ?**
   Elle centralise la création et la gestion des VLANs afin d’éviter leur manipulation dispersée dans le code.

6. Comment fonctionne la recherche par nom dans le gestionnaire ?**
   Elle parcourt la liste des VLANs et compare les noms en ignorant les majuscules/minuscules grâce à `equalsIgnoreCase`.

7. Que se passe-t-il si on saisit un ID de VLAN égal à 5000 ?**
   Le système détecte que l’ID est invalide (hors plage 1–4094) et attribue automatiquement une valeur par défaut (10).

8. Pourquoi isoler le WiFi invités dans un VLAN séparé ?**
   Pour empêcher les utilisateurs externes d’accéder aux ressources sensibles du réseau interne (serveurs, données administratives).

---

## 8. Conclusion

Ce TP permet de comprendre la segmentation logique d’un réseau à travers les VLANs et leur intégration dans un système de planification d’adressage IP.

---



