/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager;

/**
 *
 * @author MICHELLE
 */
public class SousReseau {
 // [cite: 269]
    private String nom; // [cite: 272]
    private ReseauIP reseau; // [cite: 272]

    public SousReseau(String nom, ReseauIP reseau) { // [cite: 278]
        setNom(nom); // [cite: 279]
        this.reseau = reseau; // [cite: 279]
    }

    public String getNom() { return nom; } // [cite: 282]

    public void setNom(String nom) { // [cite: 285, 289]
        if (nom == null || nom.isEmpty()) { // [cite: 290]
            this.nom = "Sous-reseau inconnu"; // [cite: 293]
        } else {
            this.nom = nom; // [cite: 292]
        }
    }

    public ReseauIP getReseau() { return reseau; } // [cite: 300]

    public void setReseau(ReseauIP reseau) { // [cite: 309]
        this.reseau = reseau; // [cite: 311]
    }

    public void afficher() { // [cite: 321]
        System.out.println("Sous-réseau : " + nom); // [cite: 323, 328]
        if (reseau != null) { // [cite: 324]
            reseau.afficher(); // [cite: 325]
        }
    }
}
    

