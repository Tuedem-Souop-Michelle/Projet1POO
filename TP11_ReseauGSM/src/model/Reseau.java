/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author MICHELLE
 */
import java.util.ArrayList;

public class Reseau {

    private String nom;
    private String bandeUplink;
    private String bandeDownlink;
    private String accesMultiple;
    private double debitMaxUplink;
    private double debitMaxDownlink;
    private int delaiMax;

    private ArrayList<BTS> btsList;

    public Reseau(String nom,
                  String bandeUplink,
                  String bandeDownlink,
                  String accesMultiple,
                  double debitMaxUplink,
                  double debitMaxDownlink,
                  int delaiMax) {

        this.nom = nom;
        this.bandeUplink = bandeUplink;
        this.bandeDownlink = bandeDownlink;
        this.accesMultiple = accesMultiple;
        this.debitMaxUplink = debitMaxUplink;
        this.debitMaxDownlink = debitMaxDownlink;
        this.delaiMax = delaiMax;

        btsList = new ArrayList<>();
    }

    public void ajouterBTS(BTS bts) {

        btsList.add(bts);
    }

    public void afficherPerformances() {

        System.out.println("\n===== RESEAU GSM =====");

        System.out.println("Nom : " + nom);
        System.out.println("Uplink : " + bandeUplink);
        System.out.println("Downlink : " + bandeDownlink);
        System.out.println("Accès multiple : " + accesMultiple);

        System.out.println(
                "Débit Max UL : "
                + debitMaxUplink
        );

        System.out.println(
                "Débit Max DL : "
                + debitMaxDownlink
        );

        System.out.println(
                "Délai Max : "
                + delaiMax
        );

        System.out.println(
                "Nombre BTS : "
                + btsList.size()
        );
    }
}