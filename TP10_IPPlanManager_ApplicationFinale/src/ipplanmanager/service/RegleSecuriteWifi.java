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
import java.util.List;

public class RegleSecuriteWifi implements RegleRecommandation {

    @Override
    public List<Recommandation> analyser(List<ResultatVLSM> plan) {

        List<Recommandation> recs = new ArrayList<>();

        for (ResultatVLSM res : plan) {

            if (res.getNom().toLowerCase().contains("wifi")) {

                recs.add(new Recommandation(
                        "Sécurité WiFi",
                        "Le réseau WiFi doit être isolé dans un VLAN sécurisé",
                        "SÉCURITÉ"
                ));
            }
        }

        return recs;
    }
}  
