/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager;

/**
 *
 * @author MICHELLE
 */
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

    // Analyse si l'IP commence par 192. (Locale)
    public boolean estAdresseLocale() {
        return this.valeur.startsWith("192.");
    }

    // Analyse si l'IP est privée (Classes A, B, C)
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


