/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager.repository;

/**
 *
 * @author MICHELLE
 */


import ipplanmanager.model.ResultatVLSM;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FichierPlanRepository {

    public void sauvegarderPlan(List<ResultatVLSM> resultats) {

        try {

            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("exports/plan.txt")
            );

            for (ResultatVLSM r : resultats) {

                writer.write(
                        r.getNom() + ";" +
                        r.getMasque() + ";" +
                        r.getVlanAssocie().getId() + "\n"
                );
            }

            writer.close();

            System.out.println("Plan sauvegardé avec succès");

        }catch (IOException e) {
            System.out.println("Erreur sauvegarde : " + e.getMessage());
        }
    }
}
    

