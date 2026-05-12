/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager.service;

/**
 *
 * @author MICHELLE
 */
import ipplanmanager.console.ConsoleService;
import ipplanmanager.model.BesoinReseau;
import ipplanmanager.model.ResultatVLSM;
import ipplanmanager.repository.FichierPlanRepository;

import java.util.ArrayList;

public class ApplicationIPPlanManager {

    private ConsoleService console = new ConsoleService();
    private MoteurVLSM moteur = new MoteurVLSM();
    private GestionnaireVLAN vlanManager = new GestionnaireVLAN();
    private FichierPlanRepository repo = new FichierPlanRepository();

    public void demarrer() {

        while (true) {

            String choix = console.menu();

            if (choix.equals("1")) {

                try {

                    String ip = console.saisirTexte("Adresse réseau : ");
                    ArrayList<BesoinReseau> besoins = console.saisirBesoins();

                    ArrayList<ResultatVLSM> resultats =
                            moteur.genererPlan(ip, besoins);

                    System.out.println("\n===== PLAN =====");

                    int vlanId = 10;

                    for (ResultatVLSM r : resultats) {

                        r.afficher();

                        vlanManager.ajouterVlan(vlanId, r.getNom());

                        vlanId += 10;
                    }

                    repo.sauvegarderPlanCSV(resultats);

                    System.out.println("\n✔ Fichier CSV généré dans exports");

                } catch (Exception e) {
                    System.out.println("Erreur : " + e.getMessage());
                }

            } else {
                break;
            }
        }
    }
}