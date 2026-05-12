/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager.model;

/**
 *
 * @author MICHELLE
 */


public class BesoinReseau {

    private String nom;
    private int nombreHotes;

    public BesoinReseau(String nom, int nombreHotes) {
        this.nom = nom;
        this.nombreHotes = nombreHotes;
    }

    public String getNom() { return nom; }
    public int getNombreHotes() { return nombreHotes; }
}

