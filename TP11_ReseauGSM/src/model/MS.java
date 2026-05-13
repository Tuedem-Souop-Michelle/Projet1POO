/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author MICHELLE
 */
import java.util.ArrayList;

public class MS implements Appelable {

    private String nom;
    private String prenom;
    private String msisdn;

    private ArrayList<String> historique;

    public MS(String nom, String prenom, String msisdn) {

        this.nom = nom;
        this.prenom = prenom;
        this.msisdn = msisdn;

        historique = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getMsisdn() {
        return msisdn;
    }

    @Override
    public void appeler(MS destinataire) {

        String message =
                nom + " appelle "
                + destinataire.getNom()
                + " (" + destinataire.getMsisdn() + ")";

        System.out.println(message);

        destinataire.recevoirAppel(message);
    }

    @Override
    public void recevoirAppel(String message) {

        historique.add(message);
    }

    public void afficher() {

        System.out.println(
                nom + " "
                + prenom
                + " | "
                + msisdn
        );
    }

    public void afficherHistorique() {

        System.out.println("\nHistorique de " + nom);

        if (historique.isEmpty()) {

            System.out.println("Aucun appel");
        }

        for (String h : historique) {

            System.out.println(h);
        }
    }
}