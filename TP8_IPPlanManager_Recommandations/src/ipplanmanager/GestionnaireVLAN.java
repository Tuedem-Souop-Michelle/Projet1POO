/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager;

/**
 *
 * @author MICHELLE
 */
import java.util.ArrayList;
import java.util.List;

public class GestionnaireVLAN {
    private List<VLAN> listeVlans = new ArrayList<>();

    public void ajouterVLAN(int id, String nom) {
        listeVlans.add(new VLAN(id, nom));
    }

    public VLAN rechercherVlanParNom(String nom) {
        for (VLAN v : listeVlans) {
            if (v.getNom().equalsIgnoreCase(nom)) {
                return v;
            }
        }
        return null;
    }

    public List<VLAN> getListeVlans() {
        return listeVlans;
    }
}
    

