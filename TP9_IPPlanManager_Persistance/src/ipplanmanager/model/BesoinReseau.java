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
    private int hotes;
    private String priorite;

    public BesoinReseau(String nom, int hotes, String priorite) {
        this.nom = nom;
        this.hotes = hotes;
        this.priorite = priorite;
    }

    public String getNom() {
        return nom;
    }

    public int getHotes() {
        return hotes;
    }

    public String getPriorite() {
        return priorite;
    }
}  

