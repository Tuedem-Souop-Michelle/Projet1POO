/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager.model;

/**
 *
 * @author MICHELLE
 */

public class ResultatVLSM {

    private String nom;
    private int masque;
    private VLAN vlanAssocie;

    public ResultatVLSM(String nom, int masque, VLAN vlanAssocie) {
        this.nom = nom;
        this.masque = masque;
        this.vlanAssocie = vlanAssocie;
    }

    public String getNom() {
        return nom;
    }

    public int getMasque() {
        return masque;
    }

    public VLAN getVlanAssocie() {
        return vlanAssocie;
    }
}