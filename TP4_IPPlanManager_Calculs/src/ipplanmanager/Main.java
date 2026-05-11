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

        System.out.println("=== TP4 : Calculs Réseau Automatiques ===");

        // Réseau /24
        ReseauIP lan =
                new ReseauIP(
                        "192.168.1.0",
                        24,
                        "LAN Bureau"
                );

        lan.afficher();

        System.out.println("\n--- Test sur un réseau /28 ---");

        // Réseau /28
        ReseauIP wifi =
                new ReseauIP(
                        "10.0.0.0",
                        28,
                        "WiFi Invités"
                );

        wifi.afficher();

        System.out.println("\n--- Test Analyse IP ---");

        AdresseIP ip =
                new AdresseIP("10.5.1.20");

        System.out.println("IP : " + ip.getValeur());

        System.out.println("Est privée ? "
                + ip.estAdressePrivee());

        System.out.println("Est locale (192.) ? "
                + ip.estAdresseLocale());
    }
}

    