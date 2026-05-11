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

        System.out.println("===== TP6 VLAN + VLSM =====");

        GestionnaireVLAN gv = new GestionnaireVLAN();
        gv.ajouterVLAN(10, "Administration");
        gv.ajouterVLAN(20, "Technique");
        gv.ajouterVLAN(30, "WiFi");

        VLAN admin = gv.rechercherVlanParNom("Administration");
        VLAN tech = gv.rechercherVlanParNom("Technique");

        ResultatVLSM r1 = new ResultatVLSM("Admin", "192.168.1.0", 26, 62, admin);
        ResultatVLSM r2 = new ResultatVLSM("Tech", "192.168.1.64", 25, 126, tech);

        r1.afficher();
        r2.afficher();
    }
}