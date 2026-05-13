/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

/**
 *
 * @author MICHELLE
 */
import model.BTS;
import model.MS;
import model.Reseau;

public class TestReseau {

    public static void main(String[] args) {

        Reseau reseau =
                new Reseau(
                        "4G Campus",
                        "1710 MHz",
                        "1805 MHz",
                        "OFDMA",
                        150,
                        300,
                        10
                );

        BTS bts1 =
                new BTS(
                        1,
                        "Douala-Akwa",
                        30,
                        "Urbain",
                        2.5,
                        40,
                        10
                );

        reseau.ajouterBTS(bts1);

        MS michelle =
                new MS(
                        "Michelle",
                        "Tuedem",
                        "111"
                );

        MS drYankam =
                new MS(
                        "Dr",
                        "Yankam",
                        "222"
                );

        MS tuedem =
                new MS(
                        "Tuedem",
                        "Michelle",
                        "333"
                );

        try {

            bts1.ajouterMS(michelle);
            bts1.ajouterMS(drYankam);
            bts1.ajouterMS(tuedem);

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        reseau.afficherPerformances();

        bts1.afficherInformations();

        System.out.println("\n===== APPELS =====");

        michelle.appeler(drYankam);

        drYankam.appeler(tuedem);

        tuedem.appeler(michelle);

        michelle.afficherHistorique();

        drYankam.afficherHistorique();

        tuedem.afficherHistorique();
    }
}