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

public class RegleOptimisationBroadcast implements RegleRecommandation {

    @Override
    public List<Recommandation> analyser(List<ResultatVLSM> plan) {

        List<Recommandation> recs = new ArrayList<>();

        for (ResultatVLSM res : plan) {

            if (res.getMasque() < 24) {

                recs.add(new Recommandation(
                        "Broadcast élevé",
                        "Le réseau " + res.getNom() + " a un domaine de broadcast trop large",
                        "PERFORMANCE"
                ));
            }
        }

        return recs;
    }
}
    

