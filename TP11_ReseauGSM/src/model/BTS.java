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

public class BTS {

    private int numero;
    private String emplacement;
    private double hauteur;
    private String milieu;
    private double rayonCouverture;
    private double puissanceEmission;
    private int nombreMaxUtilisateurs;

    private ArrayList<MS> utilisateurs;

    public BTS(int numero,
               String emplacement,
               double hauteur,
               String milieu,
               double rayonCouverture,
               double puissanceEmission,
               int nombreMaxUtilisateurs) {

        this.numero = numero;
        this.emplacement = emplacement;
        this.hauteur = hauteur;
        this.milieu = milieu;
        this.rayonCouverture = rayonCouverture;
        this.puissanceEmission = puissanceEmission;
        this.nombreMaxUtilisateurs = nombreMaxUtilisateurs;

        utilisateurs = new ArrayList<>();
    }

    public void ajouterMS(MS ms) throws Exception {

        if (utilisateurs.size() >= nombreMaxUtilisateurs) {

            throw new Exception("BTS saturée !");
        }

        utilisateurs.add(ms);
    }

    public void afficherInformations() {

        System.out.println("\n===== BTS =====");

        System.out.println("Numero : " + numero);
        System.out.println("Emplacement : " + emplacement);
        System.out.println("Hauteur : " + hauteur);
        System.out.println("Milieu : " + milieu);
        System.out.println("Rayon : " + rayonCouverture);
        System.out.println("Puissance : " + puissanceEmission);

        System.out.println(
                "Utilisateurs connectés : "
                + utilisateurs.size()
        );

        for (MS ms : utilisateurs) {

            ms.afficher();
        }
    }
}