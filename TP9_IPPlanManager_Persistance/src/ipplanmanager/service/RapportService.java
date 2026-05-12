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
import java.io.FileWriter;
import java.util.List;

public class RapportService {

    public void genererRapport(String fichier, List<Recommandation> recommandations) {

        try {

            FileWriter writer = new FileWriter(fichier);

            writer.write("===== RAPPORT IPPLAN-MANAGER =====\n\n");

            for (Recommandation r : recommandations) {

                writer.write("- " + r.toString() + "\n");
            }

            writer.close();

            System.out.println("Rapport généré : " + fichier);

        } catch (Exception e) {

            System.out.println("Erreur génération rapport : " + e.getMessage());
        }
    }
}
    

