# TP5 : Conception du moteur VLSM dans IPPlan-Manager

## 1. Objectif du TP

L'objectif de ce TP est de concevoir le cœur technique de l'application : le moteur VLSM (Variable Length Subnet Mask). Ce moteur permet de transformer un besoin exprimé en nombre d'hôtes en un découpage réseau optimisé afin de réduire le gaspillage d'adresses IP.

## 2. Notions étudiées

* Algorithme VLSM
* Tri de collections
* Utilisation de Comparator
* Collections ArrayList
* Calcul automatique des masques CIDR
* Génération de sous-réseaux
* Séparation des modèles et des traitements

## 3. Codes des classes

### Classe BesoinReseau

```java
package ipplanmanager;

public class BesoinReseau {

    private String nom;
    private int nombreHotesDemandes;

    public BesoinReseau(String nom, int nombreHotesDemandes) {
        this.nom = nom;
        this.nombreHotesDemandes = nombreHotesDemandes;
    }

    public String getNom() {
        return nom;
    }

    public int getNombreHotesDemandes() {
        return nombreHotesDemandes;
    }
}
```

### Classe ResultatVLSM

```java
package ipplanmanager;

public class ResultatVLSM {

    private String nom;
    private String adresseReseau;
    private int masqueCidr;
    private int hotesReels;

    public ResultatVLSM(
            String nom,
            String adresseReseau,
            int masqueCidr,
            int hotesReels) {

        this.nom = nom;
        this.adresseReseau = adresseReseau;
        this.masqueCidr = masqueCidr;
        this.hotesReels = hotesReels;
    }

    public void afficher() {

        System.out.println("Sous-réseau : " + nom);

        System.out.println(
                "  > Adresse : "
                + adresseReseau
                + "/"
                + masqueCidr
        );

        System.out.println(
                "  > Capacité réelle : "
                + hotesReels
                + " hôtes"
        );
    }
}
```

### Classe MoteurVLSM

```java
package ipplanmanager;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MoteurVLSM {

    public static int calculerMasquePourBesoin(int besoin) {

        for (int cidr = 30; cidr >= 8; cidr--) {

            double capacite =
                    Math.pow(2, 32 - cidr) - 2;

            if (capacite >= besoin) {
                return cidr;
            }
        }

        return 32;
    }

    public static List<ResultatVLSM> calculerVLSM(
            String adresseDepart,
            List<BesoinReseau> besoins) {

        besoins.sort(
                Comparator.comparingInt(
                        BesoinReseau::getNombreHotesDemandes
                ).reversed()
        );

        List<ResultatVLSM> resultats =
                new ArrayList<>();

        String adresseCourante = adresseDepart;

        for (BesoinReseau b : besoins) {

            int cidr =
                    calculerMasquePourBesoin(
                            b.getNombreHotesDemandes()
                    );

            int capacite =
                    (int) Math.pow(2, 32 - cidr) - 2;

            resultats.add(
                    new ResultatVLSM(
                            b.getNom(),
                            adresseCourante,
                            cidr,
                            capacite
                    )
            );

            adresseCourante = "Suivant...";
        }

        return resultats;
    }
}
```

### Classe Main

```java
package ipplanmanager;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("===== MOTEUR VLSM =====");

        List<BesoinReseau> mesBesoins = new ArrayList<>();

        mesBesoins.add(new BesoinReseau("Administration", 50));
        mesBesoins.add(new BesoinReseau("Technique", 120));
        mesBesoins.add(new BesoinReseau("WiFi", 80));
        mesBesoins.add(new BesoinReseau("Serveurs", 20));

        List<ResultatVLSM> planAdressage =
                MoteurVLSM.calculerVLSM(
                        "192.168.1.0",
                        mesBesoins
                );

        for (ResultatVLSM res : planAdressage) {
            res.afficher();
            System.out.println();
        }
    }
}
```

## 4. Tests réalisés

* Test du tri décroissant des besoins réseau.
* Vérification des CIDR générés automatiquement.
* Vérification des capacités réelles des sous-réseaux.
* Test du fonctionnement du moteur VLSM avec plusieurs besoins.
* Vérification de l'utilisation correcte des collections.

## 5. Difficultés rencontrées

* Utilisation du Comparator pour trier une collection d'objets.
* Compréhension du calcul automatique du masque CIDR.
* Gestion des listes d'objets avec ArrayList.
* Compréhension du principe du VLSM.

## 6. Réponses aux questions de compréhension

1. Pourquoi doit-on trier les besoins par taille décroissante ?
   Pour attribuer les plus grands sous-réseaux en premier et éviter le gaspillage d'adresses IP.

2. Qu'est-ce que le VLSM apporte par rapport au découpage classique ?
   Le VLSM permet d'utiliser des masques différents selon les besoins de chaque sous-réseau.

3. Quelle différence existe entre BesoinReseau et ResultatVLSM ?
   BesoinReseau représente la demande utilisateur alors que ResultatVLSM représente le résultat calculé.

4. Pourquoi utiliser des méthodes statiques dans MoteurVLSM ?
   Parce que le moteur effectue uniquement des calculs sans stocker d'état interne.

5. Comment la liste est-elle triée ?
   Avec Comparator.comparingInt(...).reversed().

6. Pourquoi soustrait-on 2 dans le calcul des hôtes ?
   Pour retirer l'adresse réseau et l'adresse de broadcast.

7. Quel masque est attribué pour 50 hôtes ?
   Le masque /26 car il permet 62 hôtes utilisables.

8. Pourquoi séparer les données et les traitements ?
   Pour respecter l'organisation de la programmation orientée objet et faciliter la maintenance du projet.

