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

public class RegleOptimisationBroadcast implements RegleRecommandation {

    @Override
    public List<Recommandation> analyser(List<ResultatVLSM> plan) {
        List<Recommandation> recs = new ArrayList<>();

        for (ResultatVLSM res : plan) {
            if (res.getMasqueCidr() <= 22) {
                recs.add(new Recommandation(
                        "Optimisation Broadcast",
                        "Le réseau " + res.getNom() + " est trop large",
                        "AVERTISSEMENT"
                ));
            }
        }
        return recs;
    }
}
    

