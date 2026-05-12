/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager.service;

/**
 *
 * @author MICHELLE
 */
import ipplanmanager.model.VLAN;
import java.util.ArrayList;

public class GestionnaireVLAN {

    private ArrayList<VLAN> vlans;

    public GestionnaireVLAN() {
        vlans = new ArrayList<>();
    }

    public void ajouterVlan(int id, String nom) {
        vlans.add(new VLAN(id, nom));
    }

    public ArrayList<VLAN> getVlans() {
        return vlans;
    }
}