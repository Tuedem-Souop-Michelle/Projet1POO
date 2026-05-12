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

public class MoteurRecommandations {

    private List<RegleRecommandation> regles;

    public MoteurRecommandations() {
        regles = new ArrayList<>();
        regles.add(new RegleSecuriteWifi());
        regles.add(new RegleOptimisationBroadcast());
    }

    public List<Recommandation> genererRecommandations(List<ResultatVLSM> plan) {
        List<Recommandation> resultats = new ArrayList<>();

        for (RegleRecommandation regle : regles) {
            resultats.addAll(regle.analyser(plan));
        }

        return resultats;
    }
}
    
