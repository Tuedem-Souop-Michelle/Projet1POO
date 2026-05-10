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

        InfrastructureReseau infrastructure =
            new InfrastructureReseau("Infrastructure IUT"); 

        ReseauIP reseauAdmin =
            new ReseauIP("192.168.1.0", 24, "Réseau admin"); 

        ReseauIP reseauTech =
            new ReseauIP("192.168.2.0", 24, "Réseau technique"); 

        ReseauIP reseauWifi =
            new ReseauIP("192.168.3.0", 24, "Réseau WiFi");

        SousReseau admin = new SousReseau("ADMIN", reseauAdmin);
        SousReseau tech = new SousReseau("TECH", reseauTech);
        SousReseau wifi = new SousReseau("WIFI", reseauWifi);

        infrastructure.ajouterSousReseau(admin);
        infrastructure.ajouterSousReseau(tech);
        infrastructure.ajouterSousReseau(wifi);

        AdresseIP ip1 = new AdresseIP("192.168.1.1");
        AdresseIP ip2 = new AdresseIP("10.0.0.1");
        AdresseIP ipServeur = new AdresseIP("192.168.1.10");

        InterfaceReseau srvEth0 =
            new InterfaceReseau("eth0", ipServeur);

        srvEth0.activer();

        Equipement serveur =
            new Equipement("SRV-DNS", "Serveur");

        serveur.ajouterInterface(srvEth0);

        infrastructure.ajouterEquipement(serveur);

        InterfaceReseau eth0 =
            new InterfaceReseau("eth0", ip1);

        InterfaceReseau eth1 =
            new InterfaceReseau("eth1", ip2);

        eth0.activer();
        eth1.activer(); 

        Equipement routeur =
            new Equipement("R1 EDGE", "Routeur"); 

        routeur.ajouterInterface(eth0);
        routeur.ajouterInterface(eth1); 

        AdresseIP ipSwitch =
            new AdresseIP("192.168.1.2");

        InterfaceReseau swEth0 =
            new InterfaceReseau("eth0", ipSwitch);

        swEth0.activer();

        Equipement switch1 =
            new Equipement("SW1", "Switch");

        switch1.ajouterInterface(swEth0);

        infrastructure.ajouterEquipement(routeur);
        infrastructure.ajouterEquipement(switch1);

        infrastructure.afficher();

        System.out.println();
        System.out.println("===== RECHERCHE D'EQUIPEMENT =====");

        infrastructure.rechercherEquipement("R1 EDGE");

        System.out.println();

        // ✔ correction ici
        infrastructure.rechercherEquipement("SW1");
    }
}
