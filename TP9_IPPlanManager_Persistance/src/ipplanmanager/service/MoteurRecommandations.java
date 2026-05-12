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

public class MoteurRecommandations {

    private List<RegleRecommandation> regles = new ArrayList<>();

    public MoteurRecommandations() {
        regles.add(new RegleSecuriteWifi());
        regles.add(new RegleOptimisationBroadcast());
    }

    // ✔ MÉTHODE MANQUANTE (celle que ton Main appelle)
    public List<Recommandation> genererRecommandations(List<ResultatVLSM> plan) {

        List<Recommandation> toutes = new ArrayList<>();

        for (RegleRecommandation r : regles) {
            toutes.addAll(r.analyser(plan));
        }

        return toutes;
    }
}