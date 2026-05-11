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

public class InfrastructureReseau { 
    private String nom; 
    private ArrayList<Equipement> equipements; 
    private ArrayList<SousReseau> sousReseaux; 

    public InfrastructureReseau(String nom) { 
        this.nom = nom; 
        this.equipements = new ArrayList<>(); 
        this.sousReseaux = new ArrayList<>(); 
    }

    public void ajouterEquipement(Equipement equipement) { 
        equipements.add(equipement); 
    }

    public void ajouterSousReseau(SousReseau sousReseau) { 
        sousReseaux.add(sousReseau); 
    }
public void rechercherEquipement(String nom) {
    
    for (Equipement equipement : equipements) {

        if (equipement.getNom().equalsIgnoreCase(nom)) {

            System.out.println("Equipement trouvé :");
            equipement.afficher();
            return;
        }
        
    }

    System.out.println("Equipement introuvable.");
}
    public void afficherEquipements() { 
        for (Equipement equipement : equipements) { 
            equipement.afficher(); 
            System.out.println(); 
        }
    }

    public void afficherSousReseaux() { 
        for (SousReseau sousReseau : sousReseaux) { 
            sousReseau.afficher(); 
            System.out.println(); 
        }
    }

    public void afficher() { 
        System.out.println("Infrastructure : " + nom); 
        System.out.println(); 
        System.out.println("===== SOUS-RÉSEAUX ====="); 
        afficherSousReseaux(); 
        System.out.println();
        System.out.println("===== ÉQUIPEMENTS ====="); 
        afficherEquipements(); 
        System.out.println();
        
    }
}
    

