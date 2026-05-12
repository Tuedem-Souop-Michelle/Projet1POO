/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager.service;

/**
 *
 * @author MICHELLE
 */
public class GestionnaireVLAN {

    private int id;
    private String nom;

    public GestionnaireVLAN(int id, String nom) {
        setId(id);
        setNom(nom);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 1 || id > 4094) {
            this.id = 10;
        } else {
            this.id = id;
        }
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = (nom == null || nom.isEmpty()) ? "VLAN_SANS_NOM" : nom;
    }
}