/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager;

/**
 *
 * @author MICHELLE
 */
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
    

