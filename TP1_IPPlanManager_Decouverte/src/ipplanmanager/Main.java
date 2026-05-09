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

        System.out.println("===== IPPlan-Manager : TP1 =====");

        // Adresses IP
        AdresseIP ipRouteur = new AdresseIP("192.168.1.1");
        AdresseIP ipServeur = new AdresseIP("192.168.1.10");
        AdresseIP ipClient = new AdresseIP("192.168.1.50");
        AdresseIP ipSwitch = new AdresseIP("192.168.1.2");
        AdresseIP ipWifi = new AdresseIP("192.168.2.1");
        AdresseIP ipClient2 = new AdresseIP("192.168.2.20");

        // Interfaces réseau
        InterfaceReseau interfaceRouteur =
                new InterfaceReseau("eth0", ipRouteur);

        InterfaceReseau interfaceServeur =
                new InterfaceReseau("eth0", ipServeur);

        InterfaceReseau interfaceClient =
                new InterfaceReseau("wlan0", ipClient);

        InterfaceReseau interfaceSwitch =
                new InterfaceReseau("eth1", ipSwitch);

        InterfaceReseau interfaceWifi =
                new InterfaceReseau("wlan1", ipWifi);

        InterfaceReseau interfaceClient2 =
                new InterfaceReseau("wlan0", ipClient2);

        // Interface sans IP
        InterfaceReseau interfaceSansIP =
                new InterfaceReseau("eth2", null);

        // Activation des interfaces
        interfaceRouteur.activer();
        interfaceServeur.activer();
        interfaceSwitch.activer();
        interfaceWifi.activer();

        // Équipements
        Equipement routeur =
                new Equipement("R1_EDGE", "Routeur", interfaceRouteur);

        Equipement serveur =
                new Equipement("SRV_DNS", "Serveur", interfaceServeur);

        Equipement client =
                new Equipement("PC_ADMIN", "Poste client", interfaceClient);

        Equipement switchReseau =
                new Equipement("SW_CORE", "Switch", interfaceSwitch);

        Equipement pointWifi =
                new Equipement("AP_WIFI", "Point d'accès WiFi", interfaceWifi);

        Equipement client2 =
                new Equipement("PC_SALLE2", "Poste client", interfaceClient2);

        Equipement equipementSansIP =
                new Equipement("TEST_INTERFACE", "Switch", interfaceSansIP);

        // Réseaux
        ReseauIP reseauPrincipal =
                new ReseauIP(
                        "192.168.1.0",
                        24,
                        "Réseau principal du laboratoire"
                );

        ReseauIP reseauWifi =
                new ReseauIP(
                        "192.168.2.0",
                        24,
                        "Réseau WiFi étudiants"
                );

        // Affichage des réseaux
        System.out.println("\n----- Réseaux créés -----");

        reseauPrincipal.afficher();
        System.out.println();

        reseauWifi.afficher();

        // Affichage des équipements
        System.out.println("\n----- Équipements créés -----");

        System.out.println();
        routeur.afficher();

        System.out.println();
        serveur.afficher();

        System.out.println();
        client.afficher();

        System.out.println();
        switchReseau.afficher();

        System.out.println();
        pointWifi.afficher();

        System.out.println();
        client2.afficher();

        System.out.println();
        equipementSansIP.afficher();
    }
}  

    

