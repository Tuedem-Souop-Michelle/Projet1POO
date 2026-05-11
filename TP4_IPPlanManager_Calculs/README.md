# TP4 : Calcul automatique des masques, capacités réseau et premières analyses intelligentes

## 1. Objectif du TP

L'objectif de ce TP est d'automatiser les calculs réseau afin d'éviter les erreurs manuelles et d'optimiser l'utilisation des adresses IP. Ce TP introduit également des analyses automatiques des réseaux et des adresses IP dans le projet IPPlan-Manager.

## 2. Notions étudiées

- Méthodes de calcul réseau
- Opérations mathématiques en Java
- Automatisation des calculs d'adresses
- Analyse d'adresses IP
- Réseaux privés et publics
- Classes d'adresses IP

## 3. Codes des classes

### Classe AdresseIP

package ipplanmanager;

public class AdresseIP {
    private String valeur;

    public AdresseIP(String valeur) {
        setValeur(valeur);
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        if (valeur == null || valeur.isEmpty()) {
            System.out.println("Erreur: adresse IP invalide.");
            this.valeur = "0.0.0.0";
        } else {
            this.valeur = valeur;
        }
    }

    public boolean estAdresseLocale() {
        return this.valeur.startsWith("192.");
    }

    public boolean estAdressePrivee() {
        if (valeur.startsWith("10.")) return true;

        if (valeur.startsWith("172.")) {
            return true;
        }

        if (valeur.startsWith("192.168.")) return true;

        return false;
    }

    public void afficher() {
        System.out.println("Adresse IP : " + valeur);
    }
}


### Classe ReseauIP

package ipplanmanager;

public class ReseauIP {
    private String adresseReseau;
    private int masqueCidr;
    private String description;

    public ReseauIP(String adresseReseau, int masqueCidr, String description) {
        setAdresseReseau(adresseReseau);
        setMasqueCidr(masqueCidr);
        setDescription(description);
    }

    public void setAdresseReseau(String adresseReseau) {
        if (adresseReseau == null || adresseReseau.isEmpty()) {
            this.adresseReseau = "0.0.0.0";
        } else {
            this.adresseReseau = adresseReseau;
        }
    }

    public void setMasqueCidr(int masqueCidr) {
        if (masqueCidr < 0 || masqueCidr > 32) {
            this.masqueCidr = 24;
        } else {
            this.masqueCidr = masqueCidr;
        }
    }

    public void setDescription(String description) {
        if (description == null || description.isEmpty()) {
            this.description = "Aucune description";
        } else {
            this.description = description;
        }
    }

    public long calculerNombreHotes() {
        int bitsHotes = 32 - masqueCidr;

        if (masqueCidr >= 31) {
            return 0;
        }

        return (long) Math.pow(2, bitsHotes) - 2;
    }

    public long calculerCapaciteTotale() {
        return (long) Math.pow(2, 32 - masqueCidr);
    }

    public String determinerClasseReseau() {
        String[] octets = adresseReseau.split("\\.");

        int premierOctet = Integer.parseInt(octets[0]);

        if (premierOctet >= 1 && premierOctet <= 126) {
            return "Classe A";
        }

        if (premierOctet >= 128 && premierOctet <= 191) {
            return "Classe B";
        }

        if (premierOctet >= 192 && premierOctet <= 223) {
            return "Classe C";
        }

        return "Classe Spéciale";
    }

    public void afficher() {
        System.out.println("Réseau : " + adresseReseau + "/" + masqueCidr);
        System.out.println("Classe : " + determinerClasseReseau());
        System.out.println("Capacité : " + calculerCapaciteTotale() + " adresses");
        System.out.println("Hôtes utilisables : " + calculerNombreHotes());
        System.out.println("Description : " + description);
    }
}


### Classe Main

package ipplanmanager;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== TP4 : Calculs Réseau Automatiques ===");

        ReseauIP lan = new ReseauIP(
                "192.168.1.0",
                24,
                "LAN Bureau"
        );

        lan.afficher();

        System.out.println("\n--- Test sur un réseau /28 ---");

        ReseauIP wifi = new ReseauIP(
                "10.0.0.0",
                28,
                "WiFi Invités"
        );

        wifi.afficher();

        System.out.println("\n--- Test Analyse IP ---");

        AdresseIP ip = new AdresseIP("10.5.1.20");

        System.out.println("IP : " + ip.getValeur());
        System.out.println("Est privée ? " + ip.estAdressePrivee());
        System.out.println("Est locale (192.) ? " + ip.estAdresseLocale());
    }
}
```

## 4. Tests réalisés

* Test de calcul de capacité totale pour un réseau /24.
* Test de calcul du nombre d’hôtes utilisables.
* Test de détection automatique des classes réseau.
* Test d’un réseau de classe A.
* Test d’un réseau de classe C.
* Test d’identification d’une adresse IP privée.
* Test d’identification d’une adresse IP locale.

## 5. Difficultés rencontrées

* Compréhension de la formule de calcul des hôtes.
* Utilisation de `Math.pow()` avec conversion en `long`.
* Utilisation de `split("\\.")` pour séparer les octets.
* Gestion des masques CIDR spéciaux comme /31 et /32.

## 6. Réponses aux questions de compréhension

### 1. Pourquoi automatiser les calculs réseau ?

Pour éviter les erreurs humaines et accélérer les configurations réseau.

### 2. Quelle est la formule pour calculer le nombre d’hôtes utilisables ?

La formule est :

2^(32 - CIDR) - 2

### 3. À quoi sert le split("\.") dans le code ?

Il sert à découper l’adresse IP en plusieurs octets afin de les analyser séparément.

### 4. Pourquoi utilise-t-on le type long pour la capacité ?

Parce que certains réseaux contiennent un très grand nombre d’adresses qui dépassent la capacité du type `int`.

### 5. Quel est l’intérêt de la méthode estAdressePrivee() ?

Elle permet de savoir si une adresse IP appartient à un réseau privé interne.

### 6. Comment le code reconnaît-il un réseau de Classe C ?

Le programme vérifie si le premier octet est compris entre 192 et 223.

### 7. Pourquoi soustrait-on 2 dans le calcul des hôtes ?

Parce qu’il faut retirer l’adresse réseau et l’adresse de broadcast.

### 8. Quel est l’avantage des méthodes de calcul dans la classe ReseauIP ?

Cela respecte l’encapsulation et centralise les traitements réseau dans une seule classe.


