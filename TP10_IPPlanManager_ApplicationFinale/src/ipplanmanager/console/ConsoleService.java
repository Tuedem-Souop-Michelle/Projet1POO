/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager.console;

import ipplanmanager.model.BesoinReseau;
import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleService {

    private Scanner sc = new Scanner(System.in);

    public String saisirTexte(String msg) {
        System.out.print(msg);
        return sc.nextLine();
    }

    public int saisirEntier(String msg) {
        System.out.print(msg);
        return Integer.parseInt(sc.nextLine());
    }

    public ArrayList<BesoinReseau> saisirBesoins() {

        ArrayList<BesoinReseau> list = new ArrayList<>();

        int n = saisirEntier("Nombre de besoins : ");

        for (int i = 0; i < n; i++) {
            String nom = saisirTexte("Nom : ");
            int h = saisirEntier("Hôtes : ");
            list.add(new BesoinReseau(nom, h));
        }

        return list;
    }

    public String menu() {
        System.out.println("\n1. Générer plan");
        System.out.println("2. Quitter");
        return saisirTexte("Choix : ");
    }
}