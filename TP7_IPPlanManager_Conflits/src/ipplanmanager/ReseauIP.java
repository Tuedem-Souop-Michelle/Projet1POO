/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager;

/**
 *
 * @author MICHELLE
 */
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

    // Calcul du nombre d'hôtes utilisables
    public long calculerNombreHotes() {

        int bitsHotes = 32 - masqueCidr;

        if (masqueCidr >= 31) {
            return 0;
        }

        return (long) Math.pow(2, bitsHotes) - 2;
    }

    // Calcul capacité totale
    public long calculerCapaciteTotale() {

        return (long) Math.pow(2, 32 - masqueCidr);
    }

    // Détermination classe réseau
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

        System.out.println("Capacité : "
                + calculerCapaciteTotale()
                + " adresses");

        System.out.println("Hôtes utilisables : "
                + calculerNombreHotes());

        System.out.println("Description : " + description);
    }
}