/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager;

/**
 *
 * @author MICHELLE
 */
public class VLAN {
    private int id;
    private String nom;

    public VLAN(int id, String nom) {
        setId(id);
        setNom(nom);
    }

    public int getId() { return id; }

    public void setId(int id) {
        if (id < 1 || id > 4094) {
            System.out.println("ID VLAN invalide, valeur par défaut 10");
            this.id = 10;
        } else {
            this.id = id;
        }
    }

    public String getNom() { return nom; }

    public void setNom(String nom) {
        if (nom == null || nom.isEmpty()) {
            this.nom = "VLAN_SANS_NOM";
        } else {
            this.nom = nom;
        }
    }

    public void afficher() {
        System.out.println("VLAN ID : " + id + " | Nom : " + nom);
    }
}
    

