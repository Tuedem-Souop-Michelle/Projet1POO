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

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FichierPlanRepository {

    public void sauvegarderPlanCSV(ArrayList<ResultatVLSM> resultats) throws IOException {

        File dossier = new File("exports");
        if (!dossier.exists()) {
            dossier.mkdirs();
        }

        File fichier = new File(dossier, "plan.csv");

        FileWriter writer = new FileWriter(fichier);

        writer.write("Nom;Adresse;CIDR;Hotes;Capacite;Marge\n");

        for (ResultatVLSM r : resultats) {

            writer.write(
                    r.getNom() + ";" +
                    r.getAdresseReseau() + ";" +
                    r.getCidr() + ";" +
                    r.getHotesDemandes() + ";" +
                    r.getCapacite() + ";" +
                    r.getMarge() + "\n"
            );
        }

        writer.close();

        System.out.println("✔ CSV créé : " + fichier.getAbsolutePath());
    }
}