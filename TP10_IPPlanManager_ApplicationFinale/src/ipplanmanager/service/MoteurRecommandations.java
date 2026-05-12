/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager.service;

/**
 *
 * @author MICHELLE
 */
import ipplanmanager.model.Recommandation;
import ipplanmanager.model.ResultatVLSM;

import java.util.ArrayList;

public class MoteurRecommandations {

    public ArrayList<Recommandation> analyser(
            ArrayList<ResultatVLSM> resultats) {

        ArrayList<Recommandation> recs = new ArrayList<>();

        for (ResultatVLSM r : resultats) {

            if (r.getNom().toLowerCase().contains("wifi")) {

                recs.add(
                        new Recommandation(
                                "Sécurité WiFi",
                                "Isoler le WiFi dans un VLAN dédié",
                                "SECURITE"
                        )
                );
            }

            if (r.getMarge() < 5) {

                recs.add(
                        new Recommandation(
                                "Capacité faible",
                                "Prévoir plus d'adresses pour "
                                        + r.getNom(),
                                "OPTIMISATION"
                        )
                );
            }
        }

        return recs;
    }
}