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

        System.out.println("===== TP8 RECOMMANDATIONS =====");

        VLAN vlanDefault = new VLAN(1, "Default");

        List<ResultatVLSM> plan = new ArrayList<>();
        plan.add(new ResultatVLSM("WiFi Invités", "192.168.1.0", 24, 254, vlanDefault));
        plan.add(new ResultatVLSM("Data Center", "10.0.0.0", 16, 65534, vlanDefault));

        MoteurRecommandations moteur = new MoteurRecommandations();

        List<Recommandation> recs = moteur.genererRecommandations(plan);

        if (recs.isEmpty()) {
            System.out.println("Aucune recommandation");
        } else {
            for (Recommandation r : recs) {
                r.afficher();
            }
        }
    }
}
    

