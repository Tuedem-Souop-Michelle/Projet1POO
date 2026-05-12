/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager.service;

/**
 *
 * @author MICHELLE
 */
import java.util.ArrayList;
import java.util.List;
import ipplanmanager.model.ResultatVLSM;
import ipplanmanager.model.Recommandation;

public class RegleSecuriteWifi implements RegleRecommandation {

    @Override
    public List<Recommandation> analyser(List<ResultatVLSM> plan) {

        List<Recommandation> recs = new ArrayList<>();

        for (ResultatVLSM res : plan) {

            if (res.getNom().toLowerCase().contains("wifi")
                    && res.getVlanAssocie().getId() == 1) {

                recs.add(new Recommandation(
                        "Sécurité WiFi",
                        "Le WiFi utilise le VLAN par défaut (risque de sécurité)",
                        "SÉCURITÉ"
                ));
            }
        }

        return recs;
    }
}
    
