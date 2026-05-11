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
import java.util.Comparator;
import java.util.List;

public class MoteurVLSM {

    public static int calculerMasquePourBesoin(int besoin) {

        for (int cidr = 30; cidr >= 8; cidr--) {

            double capacite =
                    Math.pow(2, 32 - cidr) - 2;

            if (capacite >= besoin) {
                return cidr;
            }
        }

        return 32;
    }

    public static List<ResultatVLSM> calculerVLSM(
            String adresseDepart,
            List<BesoinReseau> besoins) {

        // TRI DÉCROISSANT
        besoins.sort(
                Comparator.comparingInt(
                        BesoinReseau::getNombreHotesDemandes
                ).reversed()
        );

        List<ResultatVLSM> resultats =
                new ArrayList<>();

        String adresseCourante = adresseDepart;

        for (BesoinReseau b : besoins) {

            int cidr =
                    calculerMasquePourBesoin(
                            b.getNombreHotesDemandes()
                    );

            int capacite =
                    (int) Math.pow(2, 32 - cidr) - 2;

            resultats.add(
                    new ResultatVLSM(
                            b.getNom(),
                            adresseCourante,
                            cidr,
                            capacite
                    )
            );

            adresseCourante = "Suivant...";
        }

        return resultats;
    }
}




