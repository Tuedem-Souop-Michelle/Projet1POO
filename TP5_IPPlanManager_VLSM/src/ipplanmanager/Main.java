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
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("===== MOTEUR VLSM =====");

        List<BesoinReseau> mesBesoins = new ArrayList<>();

        mesBesoins.add(new BesoinReseau("Administration", 50));
        mesBesoins.add(new BesoinReseau("Technique", 120));
        mesBesoins.add(new BesoinReseau("WiFi", 80));
        mesBesoins.add(new BesoinReseau("Serveurs", 20));

        List<ResultatVLSM> planAdressage =
                MoteurVLSM.calculerVLSM(
                        "192.168.1.0",
                        mesBesoins
                );

        for (ResultatVLSM res : planAdressage) {
            res.afficher();
            System.out.println();
        }
    }
}




    