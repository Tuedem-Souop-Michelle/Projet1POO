/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager.main;

/**
 *
 * @author MICHELLE
 */
import ipplanmanager.model.ResultatVLSM;
import ipplanmanager.model.Recommandation;
import ipplanmanager.model.VLAN;
import ipplanmanager.service.MoteurRecommandations;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        MoteurRecommandations moteur = new MoteurRecommandations();

        VLAN vlan1 = new VLAN(1, "Default");
        VLAN vlan2 = new VLAN(2, "WiFi");

        List<ResultatVLSM> plan = new ArrayList<>();

        plan.add(new ResultatVLSM("reseau_wifi", 24, vlan1));
        plan.add(new ResultatVLSM("reseau_admin", 26, vlan2));

        List<Recommandation> recs = moteur.genererRecommandations(plan);

        System.out.println("===== RECOMMANDATIONS TP9 =====");

        for (Recommandation r : recs) {
            System.out.println(r);
        }
    }
}