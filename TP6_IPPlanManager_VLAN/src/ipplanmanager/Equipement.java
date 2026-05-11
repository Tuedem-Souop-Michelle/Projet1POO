/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager;

/**
 *
 * @author MICHELLE
 */
import java.util.ArrayList; // [cite: 141]

public class Equipement {
    private String nom; // [cite: 156]
    private String type; // [cite: 157]
    private ArrayList<InterfaceReseau> interfaces; // [cite: 158]

    public Equipement(String nom, String type) { // [cite: 160]
        setNom(nom); // [cite: 161]
        setType(type); // [cite: 161]
        interfaces = new ArrayList<>(); // [cite: 169]
    }

    public String getNom() { return nom; } // [cite: 167]

    public void setNom(String nom) { // [cite: 172]
        if (nom == null || nom.isEmpty()) { // [cite: 171]
            this.nom = "equipement_inconnu"; // [cite: 177]
        } else {
            this.nom = nom; // [cite: 178]
        }
    }

    public String getType() { return type; } // [cite: 179]

    public void setType(String type) { // [cite: 189]
        if (type == null || type.isEmpty()) { // [cite: 190]
            this.type = "type_inconnu"; // [cite: 191]
        } else {
            this.type = type; // [cite: 192]
        }
    }

    public void ajouterInterface(InterfaceReseau interfaceReseau) { // [cite: 198]
        interfaces.add(interfaceReseau); // [cite: 196]
    }

    public void afficherInterfaces() { // [cite: 200]
        for (InterfaceReseau interfaceReseau : interfaces) { // [cite: 204]
            interfaceReseau.afficher(); // [cite: 205]
            System.out.println(); // [cite: 206]
        }
    }

    public void afficher() { // [cite: 208]
        System.out.println("Nom : " + nom); // [cite: 212]
        System.out.println("Type : " + type); // [cite: 212]
        System.out.println("Nombre d'interfaces : " + interfaces.size()); // [cite: 212, 213]
        afficherInterfaces(); // [cite: 217, 219]
    }
}
    

