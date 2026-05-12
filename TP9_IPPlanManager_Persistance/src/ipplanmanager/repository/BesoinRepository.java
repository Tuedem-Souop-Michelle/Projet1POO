/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager.repository;

/**
 *
 * @author MICHELLE
 */


import ipplanmanager.model.BesoinReseau;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BesoinRepository {

    public void sauvegarderBesoins(ArrayList<BesoinReseau> besoins, String cheminFichier) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(cheminFichier));

        for (BesoinReseau b : besoins) {

            writer.write(
                    b.getNom() + ";" +
                    b.getHotes() + ";" +
                    b.getPriorite() + "\n"
            );
        }

        writer.close();
    }
}
    

