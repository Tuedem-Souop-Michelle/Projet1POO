/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager;

/**
 *
 * @author MICHELLE
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== Test de l'encapsulation d'AdresseIP ===");
        AdresseIP ipValide = new AdresseIP("192.168.1.1");
        ipValide.afficher();

        AdresseIP ipInvalide = new AdresseIP(""); // Doit afficher l'erreur et mettre 0.0.0.0
        ipInvalide.afficher();

        System.out.println("\n=== Test d'InterfaceReseau ===");
        InterfaceReseau eth0 = new InterfaceReseau("eth0", ipValide);
        eth0.activer();
        eth0.afficher();

        System.out.println("\n=== Test d'Equipement ===");
        Equipement routeur = new Equipement("Routeur-Principal", "Cisco 2911", eth0);
        routeur.afficher();

        System.out.println("\n=== Test de ReseauIP ===");
        ReseauIP monReseau = new ReseauIP("192.168.1.0", 24, "Reseau Local");
        monReseau.afficher();

        // Test de validation du masque
        ReseauIP reseauMasqueFaux = new ReseauIP("10.0.0.0", 45, "Test Masque");
        reseauMasqueFaux.afficher();
    }
}
 

    

